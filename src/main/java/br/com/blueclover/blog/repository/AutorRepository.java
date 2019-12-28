package br.com.blueclover.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.blueclover.blog.entity.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long>{
	
	Autor findByNome(String nome);
}
