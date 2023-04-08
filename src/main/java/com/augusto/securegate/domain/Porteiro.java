package com.augusto.securegate.domain;

import java.util.ArrayList;
import java.util.List;

public class Porteiro extends Pessoa {
	
	private List<Controle> controles = new ArrayList<>();

	public Porteiro() {
		super();
	}

	public Porteiro(Integer id, String nome, String cpf) {
		super(id, nome, cpf);
	}

	public List<Controle> getControles() {
		return controles;
	}

	public void setControles(List<Controle> controles) {
		this.controles = controles;
	}
	
	

}
