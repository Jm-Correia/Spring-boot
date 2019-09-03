package br.com.c2c.condosdecision.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.c2c.condosdecision.util.Constantes;

@Entity
@Table(name = "User")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "email", nullable = false, unique = true )
	private String login;
	@Column(name = "hash", nullable = false)
	private String hashSenha;
		
	
	public Usuario() {
	}


	public Usuario(String login, String hashSenha) {
		this.login = login;
		this.hashSenha = hashSenha;
	}


	public Usuario(String login, String hashSenha, Byte sindico) {
		this.login = login;
		this.hashSenha = hashSenha;
	}

	public Usuario(Integer id, String login, String hashSenha) {
		super();
		this.id = id;
		this.login = login;
		this.hashSenha = hashSenha;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getHashSenha() {
		return hashSenha;
	}


	public void setHashSenha(String hashSenha) {
		this.hashSenha = hashSenha;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
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
		Usuario other = (Usuario) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else {
			return (!login.equals(other.login));
		}
		return true;
	}
	
	
	
	
	
}
