package br.com.c2c.condosdecision.enums;

public enum TipoCliente {

	PF(1, "Pessoa Fisíca"),
	PJ(2, "Pessoa Juridica");
	
	private int cod;
	private String descricao;
	
	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	//TOENUM 
	public static TipoCliente toEnum(int cod) {

		for(TipoCliente c: TipoCliente.values()) {
			if(cod == c.getCod()) {
				return c;
			}
		}
		
		throw new IllegalArgumentException("Código inválido: " + cod);
	}
	
}
