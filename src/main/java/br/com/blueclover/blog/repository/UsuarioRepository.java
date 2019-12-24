package br.com.blueclover.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.blueclover.blog.entity.Avatar;
import br.com.blueclover.blog.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	Usuario findByEmail(String email);
	
	Usuario findByAvatar(Avatar avatar);

}
