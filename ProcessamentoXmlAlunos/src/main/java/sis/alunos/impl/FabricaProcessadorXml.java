package sis.alunos.impl;

public class FabricaProcessadorXml {

	public static IProcessarXmlAlunos getProcessadorXmlAlunos() {
		IProcessarXmlAlunos processadorXmlAlunos = new ProcessarXmlAlunos();
		return processadorXmlAlunos;
	}
	
}
