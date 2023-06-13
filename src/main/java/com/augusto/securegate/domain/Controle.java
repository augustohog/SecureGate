package com.augusto.securegate.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.augusto.securegate.domain.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Controle implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataEntrada = LocalDate.now();
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataSaida;
	
	private Status status;
	private String observações;
	
	@ManyToOne
	@JoinColumn(name = "porteiro_id")
	private Porteiro porteiro;
	
	@ManyToOne
	@JoinColumn(name = "morador_id")
	private Morador morador;
	
	public Controle() {
		super();
	}
	
	public Controle(Integer id, Status status, String observações, Porteiro porteiro, Morador morador) {
		super();
		this.id = id;
		this.status = status;
		this.observações = observações;
		this.porteiro = porteiro;
		this.morador = morador;
	}
	
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
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
	public String getObservações() {
		return observações;
	}
	public void setObservações(String observações) {
		this.observações = observações;
	}
	public Porteiro getPorteiro() {
		return porteiro;
	}
	public void setPorteiro(Porteiro porteiro) {
		this.porteiro = porteiro;
	}
	public Morador getMorador() {
		return morador;
	}
	public void setMorador(Morador morador) {
		this.morador = morador;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Controle other = (Controle) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
