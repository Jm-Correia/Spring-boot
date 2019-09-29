package br.com.c2c.condosdecision.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.c2c.condosdecision.domain.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Integer> {

}
