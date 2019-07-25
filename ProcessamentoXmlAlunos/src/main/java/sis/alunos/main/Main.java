package sis.alunos.main;

import java.io.File;

import sis.alunos.excecoes.ExAluno;
import sis.alunos.impl.EstruturaDeDiretorio;
import sis.alunos.impl.FabricaProcessadorXml;
import sis.alunos.impl.GerarRelatorio;
import sis.alunos.impl.IProcessarXmlAlunos;
import sis.alunos.impl.MontarEstruturaDeDiretorios;
import sis.alunos.model.TurmaAluno;

public class Main {

	public static void main(String[] args) {
		try {
			EstruturaDeDiretorio estruturaDeDiretorios = MontarEstruturaDeDiretorios.build();
			IProcessarXmlAlunos processadorXmlAlunos = FabricaProcessadorXml.getProcessadorXmlAlunos();
		
			System.out.println("******************************** Inicio Processamento ********************************");
			if(estruturaDeDiretorios.getCaminhoUsuarioDadosInput().listFiles().length > 0) {
				int count = 1, qdeArquivos = estruturaDeDiretorios.getCaminhoUsuarioDadosInput().listFiles().length;
				
				for (File arquivoXmlAluno : estruturaDeDiretorios.getCaminhoUsuarioDadosInput().listFiles()) {
					System.out.println("---------------------------------------------------------------------------------------");
					System.out.println("Processando o arquivo "+count+" de "+qdeArquivos+" => "+arquivoXmlAluno.getName());
					System.out.println("---------------------------------------------------------------------------------------");
					estruturaDeDiretorios.setCaminhoUsuarioDadosInput(arquivoXmlAluno);
					estruturaDeDiretorios.setNomeArquivoInput(arquivoXmlAluno.getName());
					
					TurmaAluno turmaAluno = processadorXmlAlunos.converterXmlParaTurmaAluno(arquivoXmlAluno);
	
					if (turmaAluno.getAlunos() == null || turmaAluno.getAlunos().isEmpty()) throw new ExAluno("Não foram encontrados alunos para a turma");
	
					TurmaAluno turmaAlunoCalculada = processadorXmlAlunos.calcularTurmaAlunos(turmaAluno);
								
					processadorXmlAlunos.salvarArquivoCalculado(turmaAlunoCalculada, estruturaDeDiretorios);
					GerarRelatorio.imprimir(turmaAlunoCalculada);
					count++;
					
					System.out.println("---------------------------------------------------------------------------------------");
				}
			} else System.out.println("Nao foram encontrados arquivos para serem processados");
			System.out.println("********************************** Fim processamento **********************************");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
 