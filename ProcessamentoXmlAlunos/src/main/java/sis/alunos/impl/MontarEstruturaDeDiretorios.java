package sis.alunos.impl;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MontarEstruturaDeDiretorios {
	
	public static EstruturaDeDiretorio build() {
		try {
			EstruturaDeDiretorio estruturaDeDiretorio = new EstruturaDeDiretorio();
			Path caminhoUsuario = Paths.get(System.getProperty("user.home"));
			if(caminhoUsuario != null) {
				File caminhoDefaultUsuario = new File(caminhoUsuario.toString()+File.separator+"processamentoXxmlAlunos");
				estruturaDeDiretorio.setCaminhoUsuarioDadosInput(new File(caminhoDefaultUsuario.getAbsoluteFile().toString()+File.separator+"dados-input"));
				estruturaDeDiretorio.setCaminhoUsuarioDadosOutput(new File(caminhoDefaultUsuario.getAbsoluteFile().toString()+File.separator+"dados-output"));
				estruturaDeDiretorio.setCaminhoUsuarioDadosBackup(new File(caminhoDefaultUsuario.getAbsoluteFile().toString()+File.separator+"dados-backup"));
				if(!caminhoDefaultUsuario.exists()) {
					System.out.println("-------------------------------------------------------------------");
					System.out.println("-----------Iniciando a criacao da estrutura de diretorios----------");
					System.out.println("-------------------------------------------------------------------");
					estruturaDeDiretorio.getCaminhoUsuarioDadosInput().mkdirs();
					System.out.println("OK -> Diretorio para inserir os aquivos.xml dos alunos => "+estruturaDeDiretorio.getCaminhoUsuarioDadosInput().getAbsolutePath());
					estruturaDeDiretorio.getCaminhoUsuarioDadosOutput().mkdirs();
					System.out.println("OK -> Diretorio de Backup dos arquivos.xml processados => "+estruturaDeDiretorio.getCaminhoUsuarioDadosOutput().getAbsolutePath());
					estruturaDeDiretorio.getCaminhoUsuarioDadosBackup().mkdirs();
					System.out.println("OK -> Diretorio dos aquivos.xml dos alunos processados => "+estruturaDeDiretorio.getCaminhoUsuarioDadosBackup().getAbsolutePath());
					System.out.println("-------------------------------------------------------------------");
					System.out.println("-----------Estrutuda de Diretorios Criada com Sucesso--------------");
					System.out.println("-------------------------------------------------------------------");
					System.out.println(" ");
					System.out.println("**********************************************************************************************************************");
					System.out.println("***** Para processar os arquivos.xml dos alunos, coloque todos os arquivos no diretorio de input, exibido abaixo ******");
					System.out.println(""+estruturaDeDiretorio.getCaminhoUsuarioDadosInput().getAbsolutePath());
					System.out.println("*************** Em seguida execute novamente o programa para calcular os arquivos.xml dos alunos *********************");
					System.out.println("**********************************************************************************************************************");
				}
			} 
			return estruturaDeDiretorio;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}	

}
