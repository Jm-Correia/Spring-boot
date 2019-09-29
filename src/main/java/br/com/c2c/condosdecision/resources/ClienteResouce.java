package br.com.c2c.condosdecision.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.c2c.condosdecision.domain.Cliente;
import br.com.c2c.condosdecision.servicos.ClienteServico;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResouce {
	
	@Autowired
	private ClienteServico service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> listar(@PathVariable Integer id) {
		Cliente obj = service.buscar(id);

		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<?> inserir(String nome) {
		Cliente cat = new Cliente();
		cat.setNome(nome);
		
		cat = service.inserir(cat);
		
		return ResponseEntity.ok().body(cat);
	}
	
	
}
