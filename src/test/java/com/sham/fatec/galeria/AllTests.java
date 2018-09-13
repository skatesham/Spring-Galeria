package com.sham.fatec.galeria;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.sham.fatec.galeria.repository.ImagemRepositoryTest;
import com.sham.fatec.galeria.repository.PapelRepositoryTest;
import com.sham.fatec.galeria.repository.UsuarioRepositoryTest;
import com.sham.fatec.galeria.service.UsuarioServiceImplTest;

@RunWith(Suite.class)
@SuiteClasses({ 
	ImagemRepositoryTest.class,
	UsuarioRepositoryTest.class,
	UsuarioServiceImplTest.class,
	PapelRepositoryTest.class
})
public class AllTests {

}
