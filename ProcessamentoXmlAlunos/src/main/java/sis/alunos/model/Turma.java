package sis.alunos.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("resumo")
public class Turma {

	@XStreamAlias("media_geral")
	private Double mediaGeral;

	@XStreamAlias("nota_maxima")
	private Double notaMaxima;

	@XStreamAlias("nota_minima")
	private Double notaMinima;

	@XStreamAlias("quantidade_alunos")
	private Integer quantidadeDeAlunos;

	public Turma() {
		super();
	}

	public Turma(Double mediaGeral, Double notaMaxima, Double notaMinima, Integer quantidadeDeAlunos) {
		super();
		this.mediaGeral = mediaGeral;
		this.notaMaxima = notaMaxima;
		this.notaMinima = notaMinima;
		this.quantidadeDeAlunos = quantidadeDeAlunos;
	}

	public Double getMediaGeral() {
		return mediaGeral;
	}

	public void setMediaGeral(Double mediaGeral) {
		this.mediaGeral = mediaGeral;
	}

	public Double getNotaMaxima() {
		return notaMaxima;
	}

	public void setNotaMaxima(Double notaMaxima) {
		this.notaMaxima = notaMaxima;
	}

	public Double getNotaMinima() {
		return notaMinima;
	}

	public void setNotaMinima(Double notaMinima) {
		this.notaMinima = notaMinima;
	}

	public Integer getQuantidadeDeAlunos() {
		return quantidadeDeAlunos;
	}

	public void setQuantidadeDeAlunos(Integer quantidadeDeAlunos) {
		this.quantidadeDeAlunos = quantidadeDeAlunos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mediaGeral == null) ? 0 : mediaGeral.hashCode());
		result = prime * result + ((notaMaxima == null) ? 0 : notaMaxima.hashCode());
		result = prime * result + ((notaMinima == null) ? 0 : notaMinima.hashCode());
		result = prime * result + ((quantidadeDeAlunos == null) ? 0 : quantidadeDeAlunos.hashCode());
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
		Turma other = (Turma) obj;
		if (mediaGeral == null) {
			if (other.mediaGeral != null)
				return false;
		} else if (!mediaGeral.equals(other.mediaGeral))
			return false;
		if (notaMaxima == null) {
			if (other.notaMaxima != null)
				return false;
		} else if (!notaMaxima.equals(other.notaMaxima))
			return false;
		if (notaMinima == null) {
			if (other.notaMinima != null)
				return false;
		} else if (!notaMinima.equals(other.notaMinima))
			return false;
		if (quantidadeDeAlunos == null) {
			if (other.quantidadeDeAlunos != null)
				return false;
		} else if (!quantidadeDeAlunos.equals(other.quantidadeDeAlunos))
			return false;
		return true;
	}

}
