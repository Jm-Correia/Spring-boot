package br.com.c2c.condosdecision.domain;

import java.util.Date;

import br.com.c2c.condosdecision.util.Constantes;

public class Morador {

	private Integer id;
	
	private String hashPublico;
	
	private String primeiroNome;
	private String sobreNome;
	
	private Date inicioResidencia;
	private Date fimResidencia;
	
	private Byte donoImovel = Constantes.MORADOR_PROPRIETARIO;
	
	private Byte aptoVotacao;
	
	private Usuario usuario;
	
	private Condominio condominio;
	
}
