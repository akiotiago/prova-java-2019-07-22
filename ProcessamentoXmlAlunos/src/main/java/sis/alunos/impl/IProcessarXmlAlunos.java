package sis.alunos.impl;

import java.io.File;

import sis.alunos.excecoes.ExAluno;
import sis.alunos.model.TurmaAluno;

public interface IProcessarXmlAlunos {

	public Object getConversorXmlAluno();
	
	public TurmaAluno converterXmlParaTurmaAluno(File file);

	public void salvarArquivoCalculado(TurmaAluno turmaAluno, EstruturaDeDiretorio estruturaDeDiretorio) throws ExAluno;
	
	public TurmaAluno calcularTurmaAlunos(TurmaAluno turmaAluno);
	public TurmaAluno calcularTurmaAlunos(TurmaAluno turmaAluno, CalculoDeProcessamento calculoDeProcessamento);
	
}
