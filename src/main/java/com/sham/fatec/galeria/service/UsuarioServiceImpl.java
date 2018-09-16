package com.sham.fatec.galeria.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sham.fatec.galeria.model.EnumPapel;
import com.sham.fatec.galeria.model.Papel;
import com.sham.fatec.galeria.model.Usuario;
import com.sham.fatec.galeria.repository.UsuarioRepository;

@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	PapelService papelService;

	@Override
	@Transactional
	public Usuario incluirUsuario(Usuario usuario, EnumPapel papel) {

		Optional<Papel> p = papelService.lerPapelByDescricao(papel);

		if (p.isPresent()) {
			usuario.setPapel(p.get());
		}
		return usuarioRepository.save(usuario);
		
	}

	@Override
	@Transactional
	public Optional<Usuario> lerUsuarioByNomeUsuario(String nomeUsuario) {
		return usuarioRepository.findByUsuario(nomeUsuario);
	}

	@Override
	@Transactional
	public Optional<Usuario> atualizarUsuario(Usuario usuario, Usuario atualizacao) {
		System.out.println("Not Suported Yet");
		return null;
	}

}
