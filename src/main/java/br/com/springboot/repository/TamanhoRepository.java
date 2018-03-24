package br.com.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.springboot.dominio.Tamanho;

public interface TamanhoRepository extends CrudRepository<Tamanho, Integer> {
	
	
}
