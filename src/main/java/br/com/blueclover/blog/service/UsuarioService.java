package br.com.blueclover.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.blueclover.blog.entity.Avatar;
import br.com.blueclover.blog.entity.Usuario;
import br.com.blueclover.blog.repository.UsuarioRepository;

@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public Usuario findById(Long id) {
		return repository.findById(id).get();
	}
	
	public Usuario findByAvatar(Avatar avatar) {
		return repository.findByAvatar(avatar);
	}
	
	public Usuario findByEmail(String email) {
		return repository.findByEmail(email);
	}
	
	public List<Usuario> findAll(){
		return repository.findAll();
	}
}	
