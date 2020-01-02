package br.com.blueclover.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.blueclover.blog.entity.Categoria;
import br.com.blueclover.blog.repository.CategoriaRepository;
import br.com.blueclover.blog.util.MyReplaceString;

@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repository;
	
	public List<Categoria> findAll(){
		return repository.findAll();
	}
	
	public Categoria findByDescricao(String descricao) {
		return repository.findByDescricao(descricao);
	}
	
	public Categoria findById(Long id) {
		return repository.findById(id).get();
	}
	
	@Transactional(readOnly = false)
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	@Transactional(readOnly = false)
	public void saveOrUpdate(Categoria categoria) {
		String permalink = MyReplaceString.formatarPermalink(categoria.getDescricao());
		categoria.setPermalink(permalink);
		repository.save(categoria);
	}

}
