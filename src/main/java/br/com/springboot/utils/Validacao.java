package br.com.springboot.utils;

import br.com.springboot.dominio.BaseDominio;
import br.com.springboot.exception.BaseException;

public class Validacao {
	
	
	
	public static void validarId(Integer id) throws BaseException {
		if (id==null || id.compareTo(new Integer(0))==0) {
			throw new BaseException("ID do Tamanho invalido!");
		}		
	}
	

	public static void validarExistencia(BaseDominio base) throws BaseException {
		
		if (base==null) {
			throw new BaseException("Registro nao encontrado!");
		}
	}

	
}
