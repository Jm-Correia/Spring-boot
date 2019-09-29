package br.com.c2c.condosdecision.servicos;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.c2c.condosdecision.domain.Cliente;
import br.com.c2c.condosdecision.exception.ObjetoNotFoundExpection;
import br.com.c2c.condosdecision.repositories.ClienteRepository;

@Service
public class ClienteServico {

	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjetoNotFoundExpection(
				"Objeto Não Encontrado! id: " + id + ", tipo " + Cliente.class.getName()));
				
	}
	
	public Cliente inserir(Cliente cliente) {
		return repo.save(cliente);
	}
	
}
