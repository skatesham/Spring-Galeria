package com.sham.fatec.galeria.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sham.fatec.galeria.model.EnumPapel;
import com.sham.fatec.galeria.model.Papel;
import com.sham.fatec.galeria.repository.PapelRepository;

@Service("papelService")
public class PapelServiceImpl implements PapelService {
	
	@Autowired
	PapelRepository papelRepo;
	
	@Override
	public Papel incluirPapel(Papel papel) {
		return papelRepo.save(papel);
	}

	@Override
	public Optional<Papel> lerPapelById(long id) {
		return papelRepo.findById(id);
	}

	@Override
	public Optional<Papel> lerPapelByDescricao(EnumPapel enumPapel) {
		return papelRepo.findByDescricao(enumPapel.getDescricao());
	}
	
	
	
}
