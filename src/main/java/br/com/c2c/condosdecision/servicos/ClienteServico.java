package br.com.c2c.condosdecision.servicos;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.c2c.condosdecision.domain.Cliente;
import br.com.c2c.condosdecision.exception.ObjetoNotFoundExpection;
import br.com.c2c.condosdecision.repositories.ClienteRepository;
import br.com.c2c.condosdecision.repositories.EnderecoRepository;

@Service
public class ClienteServico {

	@Autowired
	private ClienteRepository repo;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjetoNotFoundExpection(
				"Objeto Não Encontrado! id: " + id + ", tipo " + Cliente.class.getName()));
				
	}
	
	@Transactional
	public Cliente inserir(Cliente cliente) {
		cliente.setId(null);
		cliente = repo.save(cliente);
		enderecoRepository.saveAll(cliente.getEnderecos());
		return repo.save(cliente);
	}
	
}
