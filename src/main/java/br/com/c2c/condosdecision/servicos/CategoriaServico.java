package br.com.c2c.condosdecision.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.c2c.condosdecision.domain.Categoria;
import br.com.c2c.condosdecision.exception.DataIntegrityExpection;
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
		categoria.setId(null);
		return repo.save(categoria);
	}
	
	public Categoria alterar(Categoria categoria) {
		buscar(categoria.getId());
		return repo.save(categoria);
	}
	
	public void delete(Integer id) {
		buscar(id);
		try {
			repo.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityExpection("Não é Possivel deletar uma categoria que tem produtos");
		}
	}
	
	public List<Categoria> buscarTodos(){
		return repo.findAll();
	}
	
	public Page<Categoria> buscarPagina(Integer page, Integer linhasPorPagina, String orderBy, String direction){
		PageRequest pagaRequest = PageRequest.of(page, linhasPorPagina, Direction.valueOf(direction), orderBy);
		return repo.findAll(pagaRequest);
	}
	
}
