package com.augusto.securegate.domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import com.augusto.securegate.domain.enums.Perfil;

public abstract class Pessoa {
	
	protected Integer id;
	protected String nome;
	protected String cpf;
	protected Set<Integer> perfis = new HashSet<>();
	protected LocalDate dataCriacao = LocalDate.now();
	
	
	public Pessoa() {
		super();
		addPerfil(Perfil.MORADOR);
		// TODO Auto-generated constructor stub
	}


	public Pessoa(Integer id, String nome, String cpf) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		addPerfil(Perfil.MORADOR);
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}


	public void addPerfil(Perfil perfil) {
		this.perfis.add(perfil.getCodigo());
	}


	public LocalDate getDataCriacao() {
		return dataCriacao;
	}


	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cpf, id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(id, other.id);
	}
	
	

}
