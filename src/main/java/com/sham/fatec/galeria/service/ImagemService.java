package com.sham.fatec.galeria.service;

import java.util.Optional;
import java.util.Set;

import com.sham.fatec.galeria.model.Imagem;
import com.sham.fatec.galeria.model.Usuario;

public interface ImagemService {
	
	public Imagem incluirImage(Imagem img);
	
	public Optional<Imagem> lerImagemById(long id);
	
	public Set<Imagem> lerImagensByUsuario(Usuario usuario);

}
