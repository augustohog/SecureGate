package com.augusto.securegate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.augusto.securegate.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
	

}
