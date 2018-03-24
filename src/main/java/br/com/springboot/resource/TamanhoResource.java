package br.com.springboot.resource;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.dominio.Tamanho;
import br.com.springboot.service.BaseService;


 
@RestController
@RequestMapping("/tamanho")
public class TamanhoResource extends BaseResource<Tamanho, Integer> {

	
}
