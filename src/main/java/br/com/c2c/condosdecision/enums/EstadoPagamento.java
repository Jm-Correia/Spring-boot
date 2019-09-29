package br.com.c2c.condosdecision.enums;

public enum EstadoPagamento {

	PENDENTE(1, "Pendente"),
	QUITADO(2, "Quitado"),
	CANCELADO(3, "Cancelado");
	
	private int cod;
	private String value;
	
	private EstadoPagamento(int cod, String value) {
		this.cod = cod;
		this.value = value;
	}

	public int getCod() {
		return cod;
	}

	public String getValue() {
		return value;
	}

	//TOENUM 
	public static EstadoPagamento toEnum(int cod) {

		for(EstadoPagamento c: EstadoPagamento.values()) {
			if(cod == c.getCod()) {
				return c;
			}
		}
		
		throw new IllegalArgumentException("Código inválido: " + cod);
	}
	
	
	
}
