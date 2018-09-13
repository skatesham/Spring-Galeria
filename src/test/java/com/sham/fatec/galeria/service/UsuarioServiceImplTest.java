package com.sham.fatec.galeria.service;

import static org.junit.Assert.assertEquals;
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
import com.sham.fatec.galeria.repository.PapelRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DIConfig.class})
@Transactional
public class UsuarioServiceImplTest {
	
	private static final String nome = "Usuario X";
	private static final String email = "user@user.com";
	private static final String user = "user";
	private static final String senha = "123";
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	PapelRepository papelRepository;
	
	@Test
	public void incluirUsuarioTest() {
		Usuario expected = new Usuario();
		expected.setNome(nome);
		expected.setEmail(email);;
		expected.setSenha(senha);
		expected.setUsuario(user);
		EnumPapel papel = EnumPapel.ADMINISTRADOR;
		
		Usuario actual = usuarioService.incluirUsuario(expected, papel);
		
		assertNotNull(actual.getId());

	}
	
	
	@Test
	public void buscarByUsuarioTest() {
		Usuario expected = new Usuario();
		expected.setNome(nome);
		expected.setEmail(email);;
		expected.setSenha(senha);
		expected.setUsuario(user);
		EnumPapel papel = EnumPapel.ADMINISTRADOR;
		
		expected = usuarioService.incluirUsuario(expected, papel);
		
		Usuario actual = usuarioService.lerUsuarioByNomeUsuario(user).get();
		
		assertEquals(expected, actual);
	}
	
}
