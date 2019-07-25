package sis.alunos.impl;

import java.io.File;

public class EstruturaDeDiretorio {

	private File caminhoUsuarioDadosInput;
	private File caminhoUsuarioDadosBackup;
	private File caminhoUsuarioDadosOutput;
	private boolean efetuarBackup = true;
	private String nomeArquivoInput;

	public EstruturaDeDiretorio() {
		super();
	}

	public EstruturaDeDiretorio(File caminhoUsuarioDadosInput, File caminhoUsuarioDadosBackup,
			File caminhoUsuarioDadosOutput) {
		super();
		this.caminhoUsuarioDadosInput = caminhoUsuarioDadosInput;
		this.caminhoUsuarioDadosBackup = caminhoUsuarioDadosBackup;
		this.caminhoUsuarioDadosOutput = caminhoUsuarioDadosOutput;
	}

	public File getCaminhoUsuarioDadosInput() {
		return caminhoUsuarioDadosInput;
	}

	public void setCaminhoUsuarioDadosInput(File caminhoUsuarioDadosInput) {
		this.caminhoUsuarioDadosInput = caminhoUsuarioDadosInput;
	}

	public File getCaminhoUsuarioDadosBackup() {
		return caminhoUsuarioDadosBackup;
	}

	public void setCaminhoUsuarioDadosBackup(File caminhoUsuarioDadosBackup) {
		this.caminhoUsuarioDadosBackup = caminhoUsuarioDadosBackup;
	}

	public File getCaminhoUsuarioDadosOutput() {
		return caminhoUsuarioDadosOutput;
	}

	public void setCaminhoUsuarioDadosOutput(File caminhoUsuarioDadosOutput) {
		this.caminhoUsuarioDadosOutput = caminhoUsuarioDadosOutput;
	}

	public boolean isEfetuarBackup() {
		return efetuarBackup;
	}

	public void setEfetuarBackup(boolean efetuarBackup) {
		this.efetuarBackup = efetuarBackup;
	}

	public String getNomeArquivoInput() {
		return nomeArquivoInput;
	}
	
	public String getNomeArquivoInputParaBackup() {
		return this.nomeArquivoInput+".bak";
	}

	public void setNomeArquivoInput(String nomeArquivoInput) {
		this.nomeArquivoInput = nomeArquivoInput;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((caminhoUsuarioDadosBackup == null) ? 0 : caminhoUsuarioDadosBackup.hashCode());
		result = prime * result + ((caminhoUsuarioDadosInput == null) ? 0 : caminhoUsuarioDadosInput.hashCode());
		result = prime * result + ((caminhoUsuarioDadosOutput == null) ? 0 : caminhoUsuarioDadosOutput.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EstruturaDeDiretorio other = (EstruturaDeDiretorio) obj;
		if (caminhoUsuarioDadosBackup == null) {
			if (other.caminhoUsuarioDadosBackup != null)
				return false;
		} else if (!caminhoUsuarioDadosBackup.equals(other.caminhoUsuarioDadosBackup))
			return false;
		if (caminhoUsuarioDadosInput == null) {
			if (other.caminhoUsuarioDadosInput != null)
				return false;
		} else if (!caminhoUsuarioDadosInput.equals(other.caminhoUsuarioDadosInput))
			return false;
		if (caminhoUsuarioDadosOutput == null) {
			if (other.caminhoUsuarioDadosOutput != null)
				return false;
		} else if (!caminhoUsuarioDadosOutput.equals(other.caminhoUsuarioDadosOutput))
			return false;
		return true;
	}

}
