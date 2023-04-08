package com.augusto.securegate.domain;

import java.time.LocalDate;
import java.util.Objects;

public class Controle {
	
	private Integer id;
	private LocalDate dataEntrada = LocalDate.now();
	private LocalDate dataSaida;
	private String observações;
	
	private Porteiro porteiro;
	private Morador morador;
	public Controle() {
		super();
	}
	
	public Controle(Integer id, String observações, Porteiro porteiro, Morador morador) {
		super();
		this.id = id;
		this.observações = observações;
		this.porteiro = porteiro;
		this.morador = morador;
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
