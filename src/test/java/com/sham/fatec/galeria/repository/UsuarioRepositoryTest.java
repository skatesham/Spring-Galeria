package com.sham.fatec.galeria.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.sham.fatec.galeria.DIConfig;
import com.sham.fatec.galeria.model.EnumPapel;
import com.sham.fatec.galeria.model.Papel;
import com.sham.fatec.galeria.model.Usuario;

/**
 * @author Sham e Lucas
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DIConfig.class})
@Transactional
public class UsuarioRepositoryTest {
	
	private static final String nome = "Usuario X";
	private static final String email = "user@user.com";
	private static final String user = "user";
	private static final String senha = "123";
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PapelRepository papelRepository;

	public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	public void setPapelRepository(PapelRepository papelRepository) {
		this.papelRepository = papelRepository;
	}



	@Test
	public void insercaoUsuarioTest() {
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setEmail(email);;
		usuario.setSenha(senha);
		usuario.setUsuario(user);
		Papel papel = new Papel(EnumPapel.ADMINISTRADOR);
		papel = papelRepository.save(papel);
		usuario.setPapel(papel);
		usuarioRepository.save(usuario);
		assertNotNull(usuario.getId());
		
	}
	
	@Test
	public void buscaUsuarioTest() {
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setEmail(email);;
		usuario.setSenha(senha);
		usuario.setUsuario(user);
		
		Papel papel = new Papel(EnumPapel.ADMINISTRADOR);
		papel = papelRepository.save(papel);
		usuario.setPapel(papel);
		usuarioRepository.save(usuario);
		
		Usuario expected = usuarioRepository.findById(usuario.getId()).get();
		assertEquals(expected, usuario);
	}
	

	@Test
	public void BuscaPorEmailTest() {
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setEmail(email);;
		usuario.setSenha(senha);
		usuario.setUsuario(user);
		Papel papel = new Papel(EnumPapel.ADMINISTRADOR);
		papel = papelRepository.save(papel);
		usuario.setPapel(papel);
		usuarioRepository.save(usuario);
		
		Usuario actual = usuarioRepository.buscarUsuarioPorEmail(email).get();
		
		assertEquals(usuario, actual);
		
	}
	
	@Test
	public void exclusaoUsuarioTest() {
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setEmail(email);;
		usuario.setSenha(senha);
		usuario.setUsuario(user);
		Papel papel = new Papel(EnumPapel.ADMINISTRADOR);
		papel = papelRepository.save(papel);
		usuario.setPapel(papel);
		usuarioRepository.save(usuario);
		usuarioRepository.delete(usuario);
		
		assertFalse(usuarioRepository.buscarUsuarioPorEmail(email).isPresent());
		
		
		
	}
	
	
}
