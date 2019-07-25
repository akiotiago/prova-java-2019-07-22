package sis.alunos.impl;

import sis.alunos.model.Aluno;
import sis.alunos.model.TurmaAluno;

public class GerarRelatorio {

	public static void imprimir(TurmaAluno turmaAluno) {
		StringBuffer relatorio = new StringBuffer();
		relatorio.append("  ID | Nome                                               | Média | \n");
		relatorio.append("------------------------------------------------------------------------------------------\n");
		for (Aluno aluno : turmaAluno.getAlunos()) {
			relatorio.append(inserirEspacos(aluno.getId().toString(), 4, 0)+inserirEspacos(aluno.getNome().toString(), 50, 1)+inserirEspacos(aluno.getMedia().toString(), 5, 0)+"\n");
		}
		relatorio.append("------------------------------------------------------------------------------------------\n");
		relatorio.append("Média geral                                                   "+turmaAluno.getTurma().getMediaGeral());
		System.out.println(relatorio.toString());
	}
	
	public static String inserirEspacos(String nome1, int qdeEspacos, int lado) {
		StringBuilder spaces = new StringBuilder();
		if(lado==1) spaces.append(nome1);
		for (int i = 0; i < qdeEspacos-nome1.length(); i++) {
			spaces.append(" ");
		}
		if(lado==0) spaces.append(nome1);
		spaces.append(" | ");
		return spaces.toString();
	}
	
}
