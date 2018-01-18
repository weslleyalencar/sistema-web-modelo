package erp.sistema.controller;

import java.util.List;

import javax.persistence.EntityManager;

public class DaoGenerico<T, ID> {

	private Class<T> clazz;
	private EntityManager manager;

	public DaoGenerico(Class<T> clazz) {
		this.clazz = clazz;
	}

	public void salvar(T objeto) {
		manager.getTransaction().begin();
		manager.merge(objeto);
		manager.getTransaction().commit();
	}

	public void remover(T objeto) {
		manager.getTransaction().begin();
		manager.remove(objeto);
		manager.getTransaction().commit();
	}

	public T buscarPorId(ID id) {
		T objeto = manager.find(clazz, id);
		return objeto;
	}

	public List<T> listarTodos() {
		return manager.createQuery("from " + clazz.getSimpleName(), clazz).getResultList();
	}

}
