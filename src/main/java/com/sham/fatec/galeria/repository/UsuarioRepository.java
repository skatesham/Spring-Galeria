package com.sham.fatec.galeria.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sham.fatec.galeria.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	public Optional<Usuario> findByUsuario(String usuario);

	@Query("select u from Usuario u where u.email = ?1 ")
	public Optional<Usuario> buscarUsuarioPorEmail(String email);
	
}
