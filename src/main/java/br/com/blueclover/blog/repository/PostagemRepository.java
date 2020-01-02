package br.com.blueclover.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.blueclover.blog.entity.Postagem;

public interface PostagemRepository extends JpaRepository<Postagem, Long>{
	
	Postagem findByPermalink(String permalink);

}
