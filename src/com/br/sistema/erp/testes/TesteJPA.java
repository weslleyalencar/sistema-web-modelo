package com.br.sistema.erp.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.br.sistema.erp.model.Modelo;

public class TesteJPA {

	public static void main(String[] args) {
		
		EntityManagerFactory factory =  Persistence.createEntityManagerFactory("JPA");
		EntityManager manager = factory.createEntityManager();

		Modelo modelo = new Modelo();
		modelo.setDescricao("Nome");
		
		manager.getTransaction().begin();
		manager.persist(modelo);
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();

	}
}
