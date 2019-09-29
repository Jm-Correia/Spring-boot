package br.com.c2c.condosdecision;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.c2c.condosdecision.domain.Categoria;
import br.com.c2c.condosdecision.domain.Cidade;
import br.com.c2c.condosdecision.domain.Cliente;
import br.com.c2c.condosdecision.domain.Endereco;
import br.com.c2c.condosdecision.domain.Estado;
import br.com.c2c.condosdecision.domain.Produto;
import br.com.c2c.condosdecision.enums.TipoCliente;
import br.com.c2c.condosdecision.repositories.CategoriaRepository;
import br.com.c2c.condosdecision.repositories.CidadeRepository;
import br.com.c2c.condosdecision.repositories.ClienteRepository;
import br.com.c2c.condosdecision.repositories.EnderecoRepository;
import br.com.c2c.condosdecision.repositories.EstadoRepository;
import br.com.c2c.condosdecision.repositories.ProdutoRepository;

@SpringBootApplication
public class CondosDecisionApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CondosDecisionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/**
		 * CATERGORIA E PRODUTO
		 */
		
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1,cat2));
				
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		/**
		 * CIDADE E ESTADO
		 */
		
		Estado est1 = new Estado(null, "Pernambuco");
		
		Cidade cid1 = new Cidade(null, "Recife", est1);
		Cidade cid2 = new Cidade(null, "Olinda", est1);
		Cidade cid3 = new Cidade(null, "Caruaru", est1);
		
		est1.getCidades().addAll(Arrays.asList(cid1, cid2, cid3));
		
		estadoRepository.save(est1);
		cidadeRepository.saveAll(Arrays.asList(cid1,cid2, cid3));

		/**
		 * CLIENTE E ENDERECO
		 */
		
		Cliente cli1 = new Cliente(null, "Fulano de tal da silva", "13258963212", TipoCliente.PF, "fulano_tal_silva@Gmail.com");
		
		Endereco end1 = new Endereco(null, "Rua Dias Recife", "101", "Apt 802", "Jardins", "50000100", cli1, cid1);
		
		cli1.getEnderecos().add(end1);
		cli1.getTelefones().addAll(Arrays.asList("8125412245", "8132659871"));
		
		clienteRepository.save(cli1);
		enderecoRepository.save(end1);
		
				
		
		
	}

}
