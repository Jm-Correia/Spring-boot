package br.com.c2c.condosdecision.exception;

public class ObjetoNotFoundExpection extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ObjetoNotFoundExpection(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public ObjetoNotFoundExpection(String arg0) {
		super(arg0);
	}

	
	
}
