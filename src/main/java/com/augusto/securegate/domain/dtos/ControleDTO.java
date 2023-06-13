package com.augusto.securegate.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import com.augusto.securegate.domain.Controle;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ControleDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataEntrada = LocalDate.now();
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataSaida;
	private Integer status;
	private String observações;
	private Integer porteiro;
	private Integer morador;
	private String nomePorteiro;
	private String nomeMorador;
	
	public ControleDTO() {
		super();
	}

	public ControleDTO(Controle obj) {
		this.id = obj.getId();
		this.dataEntrada = obj.getDataEntrada();
		this.dataSaida = obj.getDataSaida();
		this.status = obj.getStatus().getCodigo();
		this.observações = obj.getObservações();
		this.porteiro = obj.getPorteiro().getId();
		this.morador = obj.getMorador().getId();
		this.nomeMorador = obj.getMorador().getNome();
		this.nomePorteiro = obj.getPorteiro().getNome();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public LocalDate getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getObservações() {
		return observações;
	}

	public void setObservações(String observações) {
		this.observações = observações;
	}

	public Integer getPorteiro() {
		return porteiro;
	}

	public void setPorteiro(Integer porteiro) {
		this.porteiro = porteiro;
	}

	public Integer getMorador() {
		return morador;
	}

	public void setMorador(Integer morador) {
		this.morador = morador;
	}

	public String getNomePorteiro() {
		return nomePorteiro;
	}

	public void setNomePorteiro(String nomePorteiro) {
		this.nomePorteiro = nomePorteiro;
	}

	public String getNomeMorador() {
		return nomeMorador;
	}

	public void setNomeMorador(String nomeMorador) {
		this.nomeMorador = nomeMorador;
	}
	
	
}
	

	
