package br.com.c2c.condosdecision.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.c2c.condosdecision.domain.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {

}
