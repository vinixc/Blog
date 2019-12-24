package br.com.blueclover.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.blueclover.blog.entity.Avatar;

public interface AvatarRepository extends JpaRepository<Avatar, Long>{

}
