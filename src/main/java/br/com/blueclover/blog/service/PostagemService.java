package br.com.blueclover.blog.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.blueclover.blog.entity.Postagem;
import br.com.blueclover.blog.repository.PostagemRepository;
import br.com.blueclover.blog.util.MyReplaceString;

@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class PostagemService {
	
	@Autowired
	private PostagemRepository repository;
	
	public List<Postagem> findAll(){
		return repository.findAll();
	}
	
	public Postagem findByPermalink(String permalink) {
		return repository.findByPermalink(permalink);
	}
	
	public Postagem findById(Long id) {
		return repository.findById(id).get();
	}
	
	@Transactional(readOnly = false)
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	@Transactional(readOnly = false)
	public void saveOrUpdate(Postagem postagem) {
		if(postagem.getId() == null) {
			save(postagem);
		}else {
			update(postagem);
		}
	}

	private void update(Postagem postagem) {
		
		Postagem persistente = repository.findById(postagem.getId()).get();
		if(!persistente.getTitulo().equals(postagem.getTitulo())) {
			persistente.setTitulo(postagem.getTitulo());
		}
		
		if(!persistente.getTexto().equals(postagem.getTexto())) {
			persistente.setTexto(postagem.getTexto());
		}
		repository.save(persistente);
	}

	private void save(Postagem postagem) {
		String permalink = MyReplaceString.formatarPermalink(postagem.getTitulo());
		postagem.setPermalink(permalink);
		postagem.setDataPostagem(LocalDateTime.now());
		repository.save(postagem);
	}

	
}
