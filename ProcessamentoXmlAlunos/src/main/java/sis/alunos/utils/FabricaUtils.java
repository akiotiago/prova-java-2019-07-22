package sis.alunos.utils;

public class FabricaUtils {

	public static IUtilsArquivos getUtilsArquivos() {
		IUtilsArquivos utilsArquivos = new UtilsArquivos();
		return utilsArquivos;
	}
	
}
