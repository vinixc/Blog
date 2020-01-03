package br.com.blueclover.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.blueclover.blog.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
	Categoria findByDescricao(String descricao);
	

}
