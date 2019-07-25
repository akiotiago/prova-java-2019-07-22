package sis.alunos.utils;

import java.util.ArrayList;
import java.util.List;

public class Arquivos {

	private String caminhoParaBuscar;
	private List<String> listArquivosEncontrados = new ArrayList<>();
	
	public Arquivos() {
	}

	public Arquivos(String caminhoParaBuscar, List<String> listArquivosEncontrados) {
		super();
		this.caminhoParaBuscar = caminhoParaBuscar;
		this.listArquivosEncontrados = listArquivosEncontrados;
	}

	public String getCaminhoParaBuscar() {
		return caminhoParaBuscar;
	}

	public void setCaminhoParaBuscar(String caminhoParaBuscar) {
		this.caminhoParaBuscar = caminhoParaBuscar;
	}

	public List<String> getListArquivosEncontrados() {
		return listArquivosEncontrados;
	}

	public void setListArquivosEncontrados(List<String> listArquivosEncontrados) {
		this.listArquivosEncontrados = listArquivosEncontrados;
	}

}
