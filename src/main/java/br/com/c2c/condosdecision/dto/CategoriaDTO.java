package br.com.c2c.condosdecision.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import br.com.c2c.condosdecision.domain.Categoria;

public class CategoriaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message = "Preenchimento Obrigátorio")
	@Size(min = 5 ,max = 80, message = "o tamanho deve ser entre 5 e 80 caracteres")
	private String nome;
	
	public CategoriaDTO(Categoria cat) {
		this.id = cat.getId();
		this.nome = cat.getNome();
	}
	
	public Categoria fromDTO() {
		return new Categoria(this.id, this.nome);
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
