package br.com.c2c.condosdecision.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.c2c.condosdecision.domain.Categoria;
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
	public ResponseEntity<?> inserir(String nome) {
		Categoria cat = new Categoria();
		cat.setNome(nome);
		
		cat = service.inserir(cat);
		
		return ResponseEntity.ok().body(cat);
	}
	
	
}
