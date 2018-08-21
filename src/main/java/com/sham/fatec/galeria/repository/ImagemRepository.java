package com.sham.fatec.galeria.repository;

import org.springframework.data.repository.CrudRepository;

import com.sham.fatec.galeria.model.Imagem;

public interface ImagemRepository extends CrudRepository<Imagem, Long> {
	
}
