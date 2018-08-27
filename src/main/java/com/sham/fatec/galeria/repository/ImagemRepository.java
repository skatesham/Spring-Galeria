package com.sham.fatec.galeria.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.sham.fatec.galeria.model.Imagem;
import com.sham.fatec.galeria.model.Usuario;

public interface ImagemRepository extends CrudRepository<Imagem, Long> {
	
	public Set<Imagem> findByUsuario(Usuario usuario);
	
}
