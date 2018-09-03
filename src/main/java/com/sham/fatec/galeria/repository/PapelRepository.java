package com.sham.fatec.galeria.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.sham.fatec.galeria.model.Papel;

public interface PapelRepository extends CrudRepository<Papel, Long> {

	public Optional<Papel> findByDescricao(String descricao);

}
