package com.sham.fatec.galeria.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.sham.fatec.galeria.DIConfig;
import com.sham.fatec.galeria.model.EnumPapel;
import com.sham.fatec.galeria.model.Imagem;
import com.sham.fatec.galeria.model.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DIConfig.class })
@Transactional
public class ImagemServiceImplTest {

	private static final String nomeU = "Usuario X";
	private static final String emailU = "user@user.com";
	private static final String userU = "user";
	private static final String senhaU = "123";

	private static final String nomeI1 = "Imagem 1";
	private static final String nomeI2 = "Imagem 2";
	private static final String tipoI1 = ".jpg";
	private static final String tamanhoI1 = "10x10";
	private static final String path = "img/img.png";

	@Autowired
	ImagemService imagemService;

	@Autowired
	UsuarioService usuarioService;

	@Test
	public void incluirImageTest() {
		Usuario user = new Usuario();
		user.setNome(nomeU);
		user.setEmail(emailU);
		;
		user.setSenha(senhaU);
		user.setUsuario(userU);
		EnumPapel papel = EnumPapel.ADMINISTRADOR;
		user = usuarioService.incluirUsuario(user, papel);

		Imagem expected = new Imagem(path);
		expected.setNome(nomeI1);
		expected.setTipo(tipoI1);
		expected.setTamanho(tamanhoI1);
		expected.setUsuario(user);

		Imagem actual = imagemService.incluirImage(expected);

		assertEquals(expected, actual);

	}

	@Test
	public void lerImagemByIdTest() {
		Usuario user = new Usuario();
		user.setNome(nomeU);
		user.setEmail(emailU);
		;
		user.setSenha(senhaU);
		user.setUsuario(userU);
		EnumPapel papel = EnumPapel.ADMINISTRADOR;
		user = usuarioService.incluirUsuario(user, papel);

		Imagem expected = new Imagem(path);
		expected.setNome(nomeI1);
		expected.setTipo(tipoI1);
		expected.setTamanho(tamanhoI1);
		expected.setUsuario(user);

		expected = imagemService.incluirImage(expected);

		Imagem actual = imagemService.lerImagemById(expected.getId()).get();

		assertEquals(expected, actual);

	}

	@Test
	public void lerImagensByUsuarioTest() {
		Usuario user = new Usuario();
		user.setNome(nomeU);
		user.setEmail(emailU);
		;
		user.setSenha(senhaU);
		user.setUsuario(userU);
		EnumPapel papel = EnumPapel.ADMINISTRADOR;
		user = usuarioService.incluirUsuario(user, papel);

		Set<Imagem> expected = new HashSet<Imagem>();

		Imagem img1 = new Imagem(path);
		img1.setNome(nomeI1);
		img1.setTipo(tipoI1);
		img1.setTamanho(tamanhoI1);
		img1.setUsuario(user);
		expected.add(img1);

		Imagem img2 = new Imagem(path);
		img2.setNome(nomeI2);
		img2.setTipo(tipoI1);
		img2.setTamanho(tamanhoI1);
		img2.setUsuario(user);
		expected.add(img2);

		img1 = imagemService.incluirImage(img1);
		img2 = imagemService.incluirImage(img2);

		Set<Imagem> actual = imagemService.lerImagensByUsuario(user);

		Iterator<Imagem> actualIterator = actual.iterator();

		assertEquals(2, actual.size());

		assertFalse(expected.isEmpty());

		assertEquals(img1, actualIterator.next());

		assertEquals(img2, actualIterator.next());

		assertEquals(expected, actual);
	}

}
