package com.sham.fatec.galeria.service;

import java.util.Optional;

import com.sham.fatec.galeria.model.EnumPapel;
import com.sham.fatec.galeria.model.Usuario;

public interface UsuarioService {

	public Usuario incluirUsuario(Usuario usuario, EnumPapel papel);
	public Optional<Usuario> lerUsuarioByNomeUsuario(String nomeUsuario);
	public Optional<Usuario> atualizarUsuario(Usuario usuario);
	
}
