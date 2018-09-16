package com.sham.fatec.galeria.service;

import java.util.Optional;

import com.sham.fatec.galeria.model.EnumPapel;
import com.sham.fatec.galeria.model.Papel;

public interface PapelService {
	
	public Papel incluirPapel(Papel papel);

	public Optional<Papel> lerPapelById(long id);
	
	public Optional<Papel> lerPapelByDescricao(EnumPapel enumPapel);
	
}
