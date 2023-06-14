package com.augusto.securegate.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.augusto.securegate.domain.Controle;
import com.augusto.securegate.repositories.ControleRepository;
import com.augusto.securegate.services.exceptions.ObjectNotFoundException;

@Service
public class ControleService {
	@Autowired
	private ControleRepository repository;
	
	public Controle findById(Integer id) {
		Optional<Controle> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id));
	}

	public List<Controle> findAll() {
		return repository.findAll();
	}

}
