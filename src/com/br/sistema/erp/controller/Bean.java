package com.br.sistema.erp.controller;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

import com.br.sistema.erp.model.Modelo;
import com.br.sistema.erp.repository.ModeloRepository;

@Named
public class Bean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ModeloRepository modeloRepository;
	
	public void executar() {
		modeloRepository.salvar(new Modelo());
		System.out.println("Teste");
	}

}
