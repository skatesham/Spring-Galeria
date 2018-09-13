package com.sham.fatec.galeria;

import java.util.Optional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sham.fatec.galeria.model.EnumPapel;
import com.sham.fatec.galeria.model.Usuario;
import com.sham.fatec.galeria.repository.ImagemRepository;
import com.sham.fatec.galeria.repository.PapelRepository;
import com.sham.fatec.galeria.service.UsuarioService;

/**
 * Sistema de Galerias de Imagens Pessoais
 *
 */
public class App {
	public static void main(String[] args) {

		// Contexto XML
		// ClassPathXmlApplicationContext context = new
		// ClassPathXmlApplicationContext("applicationContext.xml");

		// Contexto Java Based Configuration !! ERROR !!
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DIConfig.class);

		// Beans Repository
		PapelRepository papelRepository = (PapelRepository) context.getBean("papelRepository");
		ImagemRepository imagemRepository = (ImagemRepository) context.getBean("imagemRepository");
		UsuarioService usuarioService = (UsuarioService) context.getBean("usuarioService");
		
		//Teste Serviço inserir Usuario
		Usuario usuario = (Usuario) context.getBean("usuario");
		usuario.setNome("Minedao");
		usuario.setSenha("123");
		usuario.setEmail("minedao@fatec.sp.gov.br");
		usuario.setUsuario("minedao");
		usuario = usuarioService.incluirUsuario(usuario, EnumPapel.VISITANTE);
		System.out.println(usuario.getEmail());

		// Teste Serviço, Ler Usuario
		Optional<Usuario> u = usuarioService.lerUsuarioByNomeUsuario("lucas");

		/*
		 * String path = "img/img.png"; Imagem imagem = new Imagem(path);
		 * imagem.setNome("Imagem 2"); imagem.setUsuario(u.get());
		 * //imagem.extrairBlob(path); imagemRepository.save(imagem);
		 */

		/*
		 * Teste - Ler Galeria Imagem Set<Imagem> img =
		 * imagemRepository.findByUsuario(u.get()); for(Imagem i : img) {
		 * System.out.println(i); }
		 */

		// Set<Imagem> imagens = imagemRepository.findByUsuario(u.get());
		// System.out.println(imagens.size());

		// Optional<Papel> papel = papelRepository.findById(1L);

		// usuarioRepository.save(usuario);
		// papelRepository.save();
		// papelRepository.save(new Papel("Visitante"));

		// System.out.println(u.get());

		context.close();
	}
}
