package br.com.c2c.condosdecision.dto;

import java.io.Serializable;

import br.com.c2c.condosdecision.domain.Categoria;

public class CategoriaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	
	public CategoriaDTO(Categoria cat) {
		this.id = cat.getId();
		this.nome = cat.getNome();
	}
	
	public CategoriaDTO() {
		super();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
