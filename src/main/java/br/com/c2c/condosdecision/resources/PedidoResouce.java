package br.com.c2c.condosdecision.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.c2c.condosdecision.domain.Pedido;
import br.com.c2c.condosdecision.servicos.PedidoServico;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResouce {
	
	@Autowired
	private PedidoServico service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> listar(@PathVariable Integer id) {
		Pedido obj = service.buscar(id);

		return ResponseEntity.ok().body(obj);
	}
	

	
	
}
