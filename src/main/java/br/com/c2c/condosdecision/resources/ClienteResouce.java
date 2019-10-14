package br.com.c2c.condosdecision.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		
		
		obj = new ClienteDTO(service.inserir(obj.retCliente()));
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> alterar(@RequestBody Cliente obj, @PathVariable Integer id){
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
	public ResponseEntity<List<ClienteDTO>> buscarTodos(){
		
		List<ClienteDTO> lista = service.buscarTodos().stream().map(obj -> new ClienteDTO(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/page")
	public ResponseEntity<Page<ClienteDTO>> buscarPage(
			@RequestParam(value="page", defaultValue = "0") Integer page, 
			@RequestParam(value="linhasPorPagina", defaultValue = "4") Integer linhasPorPagina, 
			@RequestParam(value="orderBy", defaultValue = "nome") String orderBy, 
			@RequestParam(value="direction", defaultValue = "DESC") String direction){
		
		Page<ClienteDTO> lista = service.buscarPagina(page, linhasPorPagina, orderBy, direction).map(obj -> new ClienteDTO(obj));
		
		return ResponseEntity.ok().body(lista);
	}
	
}
