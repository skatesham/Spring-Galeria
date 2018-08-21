package com.sham.fatec.galeria;

import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sham.fatec.galeria.model.Papel;
import com.sham.fatec.galeria.model.Usuario;
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
        
        Optional<Papel> papel = papelRepository.findById(1L);
        Usuario usuario = (Usuario) context.getBean("usuario");
        usuario.setNome("Sham Vinicius Fiorin");
        usuario.setSenha("123");
        usuario.setEmail("sham.vinicius@gmail.com");
        usuario.setUsuario("sham");
        usuario.setPapel(papel.get());
        
        //usuarioRepository.save(usuario);
        //papelRepository.save();
        //papelRepository.save(new Papel("Visitante"));
        
        Optional<Usuario> u = usuarioRepository.findByUsuario("sham");
        
        System.out.println(u.get());
        context.close();
    }
}
