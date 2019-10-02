package br.com.c2c.condosdecision.exception;

public class DataIntegrityExpection extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DataIntegrityExpection(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public DataIntegrityExpection(String arg0) {
		super(arg0);
	}

	
	
}
