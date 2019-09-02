package br.com.c2c.condosdecision.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.c2c.condosdecision.domain.Categoria;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@GetMapping
	public List<Categoria> listar() {
		Categoria cat1 = new Categoria(1, "Informatica");
		Categoria cat2 = new Categoria(2, "Escritorio");
		
		List<Categoria>  categorias = new ArrayList<>();
		categorias.add(cat1);
		categorias.add(cat2);
		
		return categorias;
	}
	
	
}
