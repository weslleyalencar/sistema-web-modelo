package com.br.sistema.erp.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class CrudRepository<E, ID> {
	
	@Inject
	private EntityManager manager;
	private Class<E> clazz;

	@SuppressWarnings("unchecked")
	public CrudRepository() {
		this.clazz = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public void salvar(E objeto) {
		manager.getTransaction().begin();
		manager.merge(objeto);
		manager.getTransaction().commit();
	}

	public void remover(E objeto) {
		manager.getTransaction().begin();
		manager.remove(objeto);
		manager.getTransaction().commit();
	}

	public E buscarPorId(ID id) {
		E objeto = manager.find(clazz, id);
		return objeto;
	}

	public List<E> listarTodos() {
		return manager.createQuery("from " + clazz.getSimpleName(), clazz).getResultList();
	}

}
