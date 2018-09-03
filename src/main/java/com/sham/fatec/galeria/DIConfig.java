/**
 * 
 */
package com.sham.fatec.galeria;

import javax.persistence.EntityManagerFactory;
import com.sham.fatec.galeria.model.Imagem;
import com.sham.fatec.galeria.model.Usuario;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Sham
 */

@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
@ComponentScan(value = { "com.sham.fatec.galeria" })
public class DIConfig {

	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/galeria?useTimezone=true&amp;serverTimezone=UTC");
		dataSource.setUsername("root");
		dataSource.setPassword("fatec");
		return dataSource;
	}

	public EntityManagerFactory entityManagerFactory() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
		vendorAdapter.setGenerateDdl(false);
		vendorAdapter.setShowSql(true);

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan("com.sham.fatec.galeria");
		factory.setDataSource(dataSource());
		factory.afterPropertiesSet();

		return factory.getObject();
	}

	public PlatformTransactionManager transactionManager() {

		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory());

		return txManager;
	}

	@Bean
	@Scope("prototype")
	public Imagem imagem() {
		Imagem imagem = new Imagem();
		imagem.setNome("Imagem Protótipo");
		imagem.setTipo("Protótipo");
		return imagem;
	}

	@Bean
	@Scope("prototype")
	public Usuario usuario() {
		Usuario usuario = new Usuario();
		return usuario;
	}

}
