package sis.alunos.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class UtilsArquivos implements IUtilsArquivos {

	@Override
	public List<String> buscarArquivos(File fileFind, String caminhoPasta) {
//		if(fileFind != null && fileFind.canRead()){
//			for (File file : fileFind.listFiles()) {
//				
//			}
//		} else System.out.println("Permiss�o de acesso do Sistema Operacional Negada!");
//		return listaArquivosEncontrados;
		return null;
	}
	
	public static File criarArquivo(String nomeArquivo, String caminhoDestino) {
		Path destino = Paths.get(caminhoDestino);
		File arquivo = new File(destino.toString(), nomeArquivo);
		try {
			if(arquivo.exists()) arquivo.delete();
			arquivo.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return arquivo;
	}


	


	
}
