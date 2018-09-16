package com.sham.fatec.galeria.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sham.fatec.galeria.model.Imagem;
import com.sham.fatec.galeria.model.Usuario;
import com.sham.fatec.galeria.repository.ImagemRepository;

@Service("imagemService")
public class ImagemServiceImpl implements ImagemService {

	@Autowired
	ImagemRepository imagemRepo;
	
	@Override
	@Transactional
	public Imagem incluirImage(Imagem img) {
		return imagemRepo.save(img);
	}

	@Override
	public Optional<Imagem> lerImagemById(long id) {
		return imagemRepo.findById(id);
	}

	@Override
	public Set<Imagem> lerImagensByUsuario(Usuario usuario) {		
		return imagemRepo.findByUsuario(usuario);
	}
	
	

}
