package br.com.c2c.condosdecision.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.c2c.condosdecision.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
