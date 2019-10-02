package br.com.c2c.condosdecision.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.c2c.condosdecision.domain.Categoria;
import br.com.c2c.condosdecision.dto.CategoriaDTO;
import br.com.c2c.condosdecision.servicos.CategoriaServico;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaServico service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> listar(@PathVariable Integer id) {
		Categoria obj = service.buscar(id);

		return ResponseEntity.ok().body(obj);
	}
	
	
	@PostMapping
	public ResponseEntity<Void> inserir(@RequestBody Categoria obj) {
	
		obj = service.inserir(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> alterar(@RequestBody Categoria obj, @PathVariable Integer id){
		obj.setId(id);
		obj = service.alterar(obj);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> buscarTodos(){
		
		List<CategoriaDTO> lista = service.buscarTodos().stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(lista);
	}
	
	
}
