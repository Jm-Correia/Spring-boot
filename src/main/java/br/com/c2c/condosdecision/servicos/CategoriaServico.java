package br.com.c2c.condosdecision.servicos;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.c2c.condosdecision.domain.Categoria;
import br.com.c2c.condosdecision.exception.ObjetoNotFoundExpection;
import br.com.c2c.condosdecision.repositories.CategoriaRepository;

@Service
public class CategoriaServico {

	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjetoNotFoundExpection(
				"Objeto Não Encontrado! id: " + id + ", tipo " + Categoria.class.getName()));
				
	}
	
	public Categoria inserir(Categoria categoria) {
		return repo.save(categoria);
	}
	
}
