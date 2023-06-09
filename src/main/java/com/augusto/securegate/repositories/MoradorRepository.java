package com.augusto.securegate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.augusto.securegate.domain.Morador;

public interface MoradorRepository extends JpaRepository<Morador, Integer> {
	

}
