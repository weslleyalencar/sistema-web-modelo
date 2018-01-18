package erp.sistema.controller;

import javax.inject.Inject;
import javax.inject.Named;

import erp.sistema.repository.ContaRepository;

@Named
public class ContaBean {
	
	@Inject
	private ContaRepository contaRepository;
	
	private String nome;
	
	public void executar() {
		contaRepository.executar();
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
