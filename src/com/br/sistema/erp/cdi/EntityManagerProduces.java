package com.br.sistema.erp.cdi;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProduces {
	
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA");
	
	
	@Produces
	@RequestScoped
	public EntityManager getManager() {
		System.out.println("ABRINDO ENTITYMANAGER");
		return factory.createEntityManager();
	}
	
	public void close(@Disposes EntityManager manager) {
		System.out.println("FECHANDO ENTITYMANAGER");
		manager.close();
	}

}
