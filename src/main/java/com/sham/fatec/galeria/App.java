package com.sham.fatec.galeria;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Optional;
import java.util.Set;

import javax.imageio.ImageIO;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sham.fatec.galeria.model.Imagem;
import com.sham.fatec.galeria.model.Papel;
import com.sham.fatec.galeria.model.Usuario;
import com.sham.fatec.galeria.repository.ImagemRepository;
import com.sham.fatec.galeria.repository.PapelRepository;
import com.sham.fatec.galeria.repository.UsuarioRepository;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        UsuarioRepository usuarioRepository = (UsuarioRepository) context.getBean("usuarioRepository");
        PapelRepository papelRepository = (PapelRepository) context.getBean("papelRepository");
        ImagemRepository imagemRepository = (ImagemRepository) context.getBean("imagemRepository");
        
        Optional<Usuario> u = usuarioRepository.findByUsuario("sham");
        
        //Set<Imagem> imagens = imagemRepository.findByUsuario(u.get());
        //System.out.println(imagens.size());
        
        /*Optional<Papel> papel = papelRepository.findById(1L);
        Usuario usuario = (Usuario) context.getBean("usuario");
        usuario.setNome("Sham Vinicius Fiorin");
        usuario.setSenha("123");
        usuario.setEmail("sham.vinicius@gmail.com");
        usuario.setUsuario("sham");
        usuario.setPapel(papel.get());
        */
        
        /*
        
        Imagem imagem = (Imagem) context.getBean("imagem");
        imagem.setNome("Imagem 1");
        imagem.setUsuario(u.get());

        byte[] imagemBlob;
        
        try {
        	File file = new File("img/img.png");
        	BufferedImage img = ImageIO.read(file);
            imagem.setTamanho(img.getWidth()+"x"+img.getHeight());
            imagem.setTipo(file.getName().substring(file.getName().indexOf("."), file.getName().length()));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(img, "png", baos);
            imagemBlob = baos.toByteArray();
            imagem.setImagemBlob(imagemBlob);
            
        } catch (Exception e) {
			e.printStackTrace();
		}
        
       imagemRepository.save(imagem);
       
       */
        //usuarioRepository.save(usuario);
        //papelRepository.save();
        //papelRepository.save(new Papel("Visitante"));
        
        
        
        //System.out.println(u.get());
        
        
        context.close();
    }
}
