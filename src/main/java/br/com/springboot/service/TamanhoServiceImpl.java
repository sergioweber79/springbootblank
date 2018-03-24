package br.com.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springboot.dominio.Tamanho;
import br.com.springboot.exception.BaseException;
import br.com.springboot.repository.TamanhoRepository;
import br.com.springboot.utils.Validacao;

@Service
public class TamanhoServiceImpl implements BaseService<Tamanho, Integer> {

	
	@Autowired 
	private TamanhoRepository tamanhoRepository;
	
	@Override
	public Tamanho save(Tamanho tamanho) throws BaseException {

		validarTamanho(tamanho);
		tamanhoRepository.save(tamanho);
		return tamanho;
	}

	@Override
	public Tamanho update(Tamanho tamanho) throws BaseException {
	
		validarIdTamanho(tamanho);
		validarTamanho(tamanho);
		
		tamanhoRepository.save(tamanho);
		return tamanho;
	}

	
	
	@Override
	public Iterable<Tamanho> findAll(){
		return tamanhoRepository.findAll();
	}


	@Override
	public Tamanho remove(Integer id)  throws BaseException {
		Validacao.validarId(id);		
		
		Tamanho tamanho = tamanhoRepository.findOne(id);
		
		
		Validacao.validarExistencia(tamanho);
	

		tamanhoRepository.delete(tamanho);
		return new Tamanho();
	}

	@Override
	public Tamanho findbyId(Integer id)  throws BaseException {
		
		Validacao.validarId(id);
		
		Tamanho tamanho = tamanhoRepository.findOne(id);

		Validacao.validarExistencia(tamanho);
		
		return tamanho; 
	}
	
	
	private void validarTamanho(Tamanho tamanho) throws BaseException {
		if (tamanho==null || tamanho.getDscTamanho()==null || tamanho.getDscTamanho().equals("")) {
			throw new BaseException("Tamanho ou descrição invalido!");
		}
		if (tamanho.getSigla()==null || tamanho.getSigla().equals("")) {
			throw new BaseException("Sigla invalida!");
		}
		if (tamanho.getSigla().length()>1) {
			throw new BaseException("A Sigla do tamanho deve ter 1 digito.");
		}
		
	}
	
	private void validarIdTamanho(Tamanho tamanho) throws BaseException {
		if (tamanho==null || tamanho.getIdTamanho()==null || tamanho.getIdTamanho().compareTo(new Integer(0))==0 ) {
			throw new BaseException("ID Tamanho invalido!");
		}
		
	}
	
	

}
