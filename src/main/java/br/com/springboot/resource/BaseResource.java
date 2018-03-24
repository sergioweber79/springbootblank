package br.com.springboot.resource;


import br.com.springboot.dominio.BaseDominio;
import br.com.springboot.dominio.BaseErro;
import br.com.springboot.service.BaseService;

import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;





public class BaseResource<T extends BaseDominio, ID extends Serializable> {

	@Autowired
	private BaseService<T,ID> service;
	
	
	@PostMapping(path="/add")
	public ResponseEntity<BaseDominio> add (@RequestBody T obj) {
		try {
			service.save(obj);
			return new ResponseEntity<>(obj, HttpStatus.CREATED);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new BaseErro(HttpStatus.UNPROCESSABLE_ENTITY.value(), e.getMessage(), e.getMessage()), HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	
	@PostMapping(path="/update") 
	public ResponseEntity<BaseDominio> update (@RequestBody T obj) {
		try {
			
			
			service.update(obj);
			return new ResponseEntity<>(obj, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new BaseErro(HttpStatus.UNPROCESSABLE_ENTITY.value(), e.getMessage(), e.getMessage()), HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	
	
	@GetMapping(path="/remove/{id}") 
	public ResponseEntity<BaseDominio> remove (@PathVariable("id") ID id) {
		try {

			
			return new ResponseEntity<>(service.remove(id), HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new BaseErro(HttpStatus.UNPROCESSABLE_ENTITY.value(), e.getMessage(), e.getMessage()), HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	
	@GetMapping(path="/{id}") 
	public ResponseEntity<BaseDominio> get (@PathVariable("id") ID id) {
		try {
			
			return new ResponseEntity<>(service.findbyId(id), HttpStatus.FOUND);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new BaseErro(HttpStatus.NOT_FOUND.value(), e.getMessage(), e.getMessage()), HttpStatus.NOT_FOUND);
		}
	}

	
	
	@GetMapping(path="/all")
	public @ResponseBody ResponseEntity<Iterable<T>> getAll() {

		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}	


}
