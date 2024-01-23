package org.olympus.mobilemvcapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.olympus.mobilemvcapp")
public class MobileConfig {

	@Bean
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("dev").createEntityManager();
	}
	
	@Bean
	public EntityTransaction getTransaction() {
		return getEntityManager().getTransaction();
	}
}
