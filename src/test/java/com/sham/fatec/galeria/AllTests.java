package com.sham.fatec.galeria;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.sham.fatec.galeria.repository.ImagemRepositoryTest;
import com.sham.fatec.galeria.repository.PapelRepositoryTest;
import com.sham.fatec.galeria.repository.UsuarioRepositoryTest;
import com.sham.fatec.galeria.service.ImagemServiceImplTest;
import com.sham.fatec.galeria.service.UsuarioServiceImplTest;

@RunWith(Suite.class)
@SuiteClasses({ 
	
	PapelRepositoryTest.class,
	PapelRepositoryTest.class,
	UsuarioRepositoryTest.class,
	UsuarioServiceImplTest.class,
	ImagemRepositoryTest.class,
	ImagemServiceImplTest.class
	
	
})
public class AllTests {

}
