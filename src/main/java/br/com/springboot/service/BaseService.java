package br.com.springboot.service;

import java.io.Serializable;

import br.com.springboot.dominio.BaseDominio;
import br.com.springboot.exception.BaseException;


public interface BaseService<T extends BaseDominio, ID extends Serializable> {
	
	public T save(T entity) throws BaseException;
	
	public T update(T entity) throws BaseException;
	
	
	public T remove(ID id)  throws BaseException;
	
	
	public T findbyId(ID id)  throws BaseException;
	
	public Iterable<T> findAll(); 
	

}
