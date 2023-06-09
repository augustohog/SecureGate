package com.augusto.securegate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.augusto.securegate.domain.Controle;

public interface ControleRepository extends JpaRepository<Controle, Integer> {
	

}
