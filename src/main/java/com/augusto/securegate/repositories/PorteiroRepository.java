package com.augusto.securegate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.augusto.securegate.domain.Porteiro;

public interface PorteiroRepository extends JpaRepository<Porteiro, Integer> {
	

}
