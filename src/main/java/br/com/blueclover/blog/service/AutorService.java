package br.com.blueclover.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.blueclover.blog.entity.Autor;
import br.com.blueclover.blog.repository.AutorRepository;

@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class AutorService {
	
	@Autowired
	private AutorRepository autorRepository;
	
	@Transactional(readOnly = false)
	public void save(Autor autor) {
		autorRepository.save(autor);
	}
	
	public List<Autor> findAll(){
		return autorRepository.findAll();
	}
	
	public Autor findByNome(String nome) {
		return  autorRepository.findByNome(nome);
	}
	
	public Autor findById(Long id) {
		return autorRepository.findById(id).get();
	}

}
