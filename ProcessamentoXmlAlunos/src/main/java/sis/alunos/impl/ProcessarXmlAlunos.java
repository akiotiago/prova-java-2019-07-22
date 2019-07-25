package sis.alunos.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.DoubleSummaryStatistics;
import java.util.Scanner;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;

import sis.alunos.excecoes.ExAluno;
import sis.alunos.model.Aluno;
import sis.alunos.model.Turma;
import sis.alunos.model.TurmaAluno;

public class ProcessarXmlAlunos implements IProcessarXmlAlunos {
	
	@Override
	public Object getConversorXmlAluno() {
		Class<?>[] classes = new Class[] { Aluno.class, Turma.class, TurmaAluno.class };

		XStream xStream = new XStream(new DomDriver(StandardCharsets.UTF_8.name(), new XmlFriendlyNameCoder("_-", "_")));
		XStream.setupDefaultSecurity(xStream);
		xStream.allowTypes(classes);
		xStream.autodetectAnnotations(true);
		
		xStream.alias("root", TurmaAluno.class);
		xStream.alias("resumo", Turma.class);
		xStream.aliasField("alunos", TurmaAluno.class, "alunos");
		xStream.alias("aluno", Aluno.class);
		xStream.processAnnotations(TurmaAluno.class);
		xStream.processAnnotations(Turma.class);
		xStream.processAnnotations(Aluno.class);
		return xStream;
	}
	
	@Override
	public TurmaAluno converterXmlParaTurmaAluno(File file) {
		XStream conversorXmlAluno = (XStream) getConversorXmlAluno();
		return (TurmaAluno) conversorXmlAluno.fromXML(file);
	}

	@Override
	public void salvarArquivoCalculado(TurmaAluno turmaAluno, EstruturaDeDiretorio estruturaDeDiretorio) throws ExAluno {
		XStream conversorTurmaAlunoParaXml = (XStream) getConversorXmlAluno();
		String preProcessamento = conversorTurmaAlunoParaXml.toXML(turmaAluno);
		if(preProcessamento != null && !preProcessamento.isEmpty()) {
			preProcessamento = preProcessamento.replace("></aluno>", "/>");
		}
		if(estruturaDeDiretorio.isEfetuarBackup()) {
			estruturaDeDiretorio.getCaminhoUsuarioDadosInput().renameTo(new File(estruturaDeDiretorio.getCaminhoUsuarioDadosBackup(), estruturaDeDiretorio.getNomeArquivoInputParaBackup()));
			if(estruturaDeDiretorio.getCaminhoUsuarioDadosInput().exists()) {
				estruturaDeDiretorio.getCaminhoUsuarioDadosInput().delete();
			}
		}
		
		try (FileOutputStream gravar = new FileOutputStream(new File(estruturaDeDiretorio.getCaminhoUsuarioDadosOutput(), estruturaDeDiretorio.getNomeArquivoInput()))){
			gravar.write(preProcessamento.getBytes());
			gravar.close();
		} catch (IOException ex) {
			throw new ExAluno(ex);
		}
	}

	@Override
	public TurmaAluno calcularTurmaAlunos(TurmaAluno turmaAluno) {
		return calcularTurmaAlunos(turmaAluno, CalculoDeProcessamento.UM_A_UM);
	}

	@Override
	public TurmaAluno calcularTurmaAlunos(TurmaAluno turmaAluno, CalculoDeProcessamento calculoDeProcessamento) throws ExAluno {
		try {
			if(turmaAluno == null) throw new ExAluno("Objeto turmaAluno vazio!");
			if(turmaAluno.getAlunos() == null || turmaAluno.getAlunos().isEmpty()) throw new ExAluno("Nao foram encontrados alunos para calcular a media");
			
			Turma resumo = null;
			switch (calculoDeProcessamento) {
				case UM_A_UM:
					resumo = new Turma(processarMediaGeral(turmaAluno), processarNotaMaxima(turmaAluno), processarNotaMinima(turmaAluno), processarQuantidadeDeAlunos(turmaAluno));
					break;
				case TODOS:
					DoubleSummaryStatistics resumoDoSumarioEstatistico = processarMediaNotaMaxMinQuantAluno(turmaAluno);
					resumo = new Turma(resumoDoSumarioEstatistico.getAverage(), resumoDoSumarioEstatistico.getMax(), resumoDoSumarioEstatistico.getMin(), (int) resumoDoSumarioEstatistico.getCount());
					break;
				default:
					resumo = new Turma(processarMediaGeral(turmaAluno), processarNotaMaxima(turmaAluno), processarNotaMinima(turmaAluno), processarQuantidadeDeAlunos(turmaAluno));
					break;
			}
			
			turmaAluno.setTurma(resumo);
			turmaAluno.setAlunos(turmaAluno.getAlunos());
			return turmaAluno;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ExAluno("Verifique o formato do xml! ");
		}
	}
	
	public static DoubleSummaryStatistics processarMediaNotaMaxMinQuantAluno(TurmaAluno turmaAluno) throws ExAluno {
		try {
			return turmaAluno.getAlunos().parallelStream().mapToDouble(Aluno::getMedia).summaryStatistics();
		} catch (Exception e) {
			throw new ExAluno(e);
		}
	}
	
	public static Double processarMediaGeral(TurmaAluno turmaAluno) throws ExAluno {
		try {
			return turmaAluno.getAlunos().parallelStream().mapToDouble(Aluno::getMedia).average().getAsDouble();
		} catch (Exception e) {
			throw new ExAluno(e);
		}
	}

	public static Double processarNotaMaxima(TurmaAluno turmaAluno) throws ExAluno {
		try {
			return turmaAluno.getAlunos().parallelStream().mapToDouble(Aluno::getMedia).max().getAsDouble();
		} catch (Exception e) {
			throw new ExAluno(e);
		}
	}

	public static Double processarNotaMinima(TurmaAluno turmaAluno) throws ExAluno {
		try {
			return turmaAluno.getAlunos().parallelStream().mapToDouble(Aluno::getMedia).min().getAsDouble();
		} catch (Exception e) {
			throw new ExAluno(e);
		}
	}

	public static Integer processarQuantidadeDeAlunos(TurmaAluno turmaAluno) throws ExAluno {
		try {
			return turmaAluno.getAlunos().size();
		} catch (Exception e) {
			throw new ExAluno(e);
		}
	}
	
	public static String digiteCaminhoDosArquivos() {
		try (Scanner scan = new Scanner(System.in);){
			System.out.println("Digite o caminho dos arquivos .xml dos alunos: ");
			return scan.nextLine().trim();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
	}

}
