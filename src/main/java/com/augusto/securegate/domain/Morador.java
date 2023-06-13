package com.augusto.securegate.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.augusto.securegate.domain.dtos.MoradorDTO;
import com.augusto.securegate.domain.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Morador extends Pessoa {
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@OneToMany(mappedBy = "morador")
	private List<Controle> controles = new ArrayList<>();

	public Morador() {
		super();
		addPerfil(Perfil.MORADOR);
	}

	public Morador(Integer id, String nome, String cpf, String email, String senha) {
		super(id, nome, cpf, email, senha);
	}
	
	public Morador(MoradorDTO obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
		this.perfis = obj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
		this.dataCriacao = obj.getDataCriacao();
	}

	public List<Controle> getControles() {
		return controles;
	}

	public void setControles(List<Controle> controles) {
		this.controles = controles;
	}
	
	
	
	
	
	
	
	

}
