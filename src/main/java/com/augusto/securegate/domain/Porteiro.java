package com.augusto.securegate.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.augusto.securegate.domain.enums.Perfil;

@Entity
public class Porteiro extends Pessoa {
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy = "porteiro")
	private List<Controle> controles = new ArrayList<>();

	public Porteiro() {
		super();
		addPerfil(Perfil.PORTEIRO);
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
