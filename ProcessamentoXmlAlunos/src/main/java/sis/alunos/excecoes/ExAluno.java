package sis.alunos.excecoes;

public class ExAluno extends RuntimeException {

	private static final long serialVersionUID = -3409602540515520043L;

	public ExAluno() {
		super();
	}

	public ExAluno(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ExAluno(String message, Throwable cause) {
		super(message, cause);
	}

	public ExAluno(String message) {
		super(message);
	}

	public ExAluno(Throwable cause) {
		super(cause);
	}

}
