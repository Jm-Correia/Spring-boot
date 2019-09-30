package br.com.c2c.condosdecision.servicos;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.c2c.condosdecision.domain.Pedido;
import br.com.c2c.condosdecision.exception.ObjetoNotFoundExpection;
import br.com.c2c.condosdecision.repositories.PedidoRepository;

@Service
public class PedidoServico {

	@Autowired
	private PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjetoNotFoundExpection(
				"Objeto Não Encontrado! id: " + id + ", tipo " + Pedido.class.getName()));
				
	}
	

	
}
