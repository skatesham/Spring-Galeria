package com.sham.fatec.galeria;

import java.util.Iterator;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sham.fatec.galeria.model.EnumPapel;
import com.sham.fatec.galeria.model.Imagem;
import com.sham.fatec.galeria.model.Papel;
import com.sham.fatec.galeria.model.Usuario;
import com.sham.fatec.galeria.service.ImagemService;
import com.sham.fatec.galeria.service.PapelService;
import com.sham.fatec.galeria.service.UsuarioService;

/**
 * Sistema de Galerias de Imagens Pessoais
 *
 */
public class App {
	public static void main(String[] args) {
		
		// Context XML
		// ClassPathXmlApplicationContext("applicationContext.xml");

		// Context Java Based Configuration !!
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DIConfig.class);

		// Serviços do sistema
		PapelService papelService = (PapelService) context.getBean("papelService");
		UsuarioService usuarioService = (UsuarioService) context.getBean("usuarioService");
		ImagemService imagemService = (ImagemService) context.getBean("imagemService");

		// Lendo papel By descrição
		Papel papel = papelService.lerPapelByDescricao(EnumPapel.VISITANTE).get();
		
		// Iniciando beans
		Usuario usuarioBean = (Usuario) context.getBean("usuario");
		Imagem imagemBean = (Imagem) context.getBean("imagem");
		
		// Incluir usuario com enum papel
		
		/*
			??? Por que servico lança exception (duplicado)???
		*/
		//usuarioBean = usuarioService.incluirUsuario(usuarioBean, EnumPapel.VISITANTE);
		
		// Ler usuario by nome usuario
		usuarioBean = usuarioService.lerUsuarioByNomeUsuario(usuarioBean.getUsuario()).get();
		
		// Set usuario a Imagem
		imagemBean.setUsuario(usuarioBean);
		
		// Incluir imagem para usuarioBean
		imagemService.incluirImage(imagemBean);
		
		// ler imagens by usuario
		Iterator<Imagem> imagensIterator = imagemService.lerImagensByUsuario(usuarioBean).iterator();
		
		System.out.println("Demonstração:");
		System.out.println(papel);
		System.out.println(usuarioBean);
		
		/*
		 ??? Por que a busca para o Usuario LAZY não executa ???
		*/
		imagensIterator.forEachRemaining(img -> System.out.println(img));
		
		context.close();
	}
}
