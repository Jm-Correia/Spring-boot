package br.com.c2c.condosdecision.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.c2c.condosdecision.domain.Cliente;
import br.com.c2c.condosdecision.dto.ClienteDTO;
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
	public ResponseEntity<Void> inserir(@Valid @RequestBody ClienteDTO obj) {
		
		
		obj = new ClienteDTO(service.inserir(obj.getCliente()));
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	
}
