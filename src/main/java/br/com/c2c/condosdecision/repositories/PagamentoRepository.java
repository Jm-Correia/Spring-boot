package br.com.c2c.condosdecision.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.c2c.condosdecision.domain.Pagamento;

public interface PagamentoRepository extends CrudRepository<Pagamento, Integer> {

}
