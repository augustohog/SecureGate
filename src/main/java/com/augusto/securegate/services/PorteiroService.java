package com.augusto.securegate.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.augusto.securegate.domain.Porteiro;
import com.augusto.securegate.repositories.PorteiroRepository;

@Service
public class PorteiroService {
	
	@Autowired
	private PorteiroRepository repository;
	
	public Porteiro findById(Integer id) {
		Optional<Porteiro> obj = repository.findById(id);
		return obj.orElse(null);
		
	}

}
