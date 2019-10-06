package br.com.c2c.condosdecision.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import br.com.c2c.condosdecision.domain.Cliente;
import br.com.c2c.condosdecision.domain.Endereco;
import br.com.c2c.condosdecision.enums.TipoCliente;

public class ClienteDTO {

	private Integer id;
	
	@NotEmpty
	@Size(min = 5, max = 20, message = "O nome deve conter entre 5 e 20 caracteres")
	private String nome;
	
	@NotEmpty
	@Size(min = 11, max = 14, message = "O cpfOuCnpj deve ter 13 ou 14 caracteres")
	private String cpfOuCnpj;

	@NotEmpty
	@Email
	private String email;
	
	private TipoCliente tipoCliente;
	
	@NotEmpty
	private List<Endereco> enderecos = new ArrayList<>();
	
	@NotEmpty
	@Size(min = 2, max = 3, message = "É necessario ter entre 2 a 3 telefones")
	private Set<String> telefones = new HashSet<>();

	public ClienteDTO() {
		super();
	}

	public ClienteDTO(Integer id, String nome, String cpfOuCnpj, String email, TipoCliente tipoCliente, List<Endereco> enderecos, Set<String> telefones) {
		super();
		this.nome = nome;
		this.cpfOuCnpj = cpfOuCnpj;
		this.email = email;
		this.tipoCliente = tipoCliente;
		this.enderecos = enderecos;
	}
	
	public Cliente getCliente() {
		Cliente c = new Cliente(null, this.nome, this.cpfOuCNPJ, this.tipoCliente, this.email);
		for(Endereco end: this.enderecos) {
			end.setCliente(c);
		}
		
		c.getEnderecos().addAll(this.enderecos);
		c.getTelefones().addAll(this.telefones);
		return c;
	}
	
	public ClienteDTO(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.cpfOuCnpj = cliente.getCpfOuCnpj();
		this.email = cliente.getEmail(); 
		this.tipoCliente = cliente.getTipoCliente();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpfOuCNPJ() {
		return cpfOuCnpj;
	}

	public void setCpfOuCNPJ(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public TipoCliente getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}
	
	
	
	
	
}
