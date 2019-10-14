package br.com.c2c.condosdecision.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.c2c.condosdecision.domain.Cliente;
import br.com.c2c.condosdecision.exception.DataIntegrityExpection;
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
	
	
	public Cliente alterar(Cliente cliente) {
		buscar(cliente.getId());
		return repo.save(cliente);
	}
	

	public void delete(Integer id) {
		buscar(id);
		try {
			repo.deleteById(id);
			
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityExpection("Não é Possivel deletar um Cliente que pedido realizado!");
		}
	}
	
	public List<Cliente> buscarTodos(){
		return repo.findAll();
	}
	
	public Page<Cliente> buscarPagina(Integer page, Integer linhasPorPagina, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linhasPorPagina, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
}
