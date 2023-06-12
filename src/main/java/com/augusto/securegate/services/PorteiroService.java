package com.augusto.securegate.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.augusto.securegate.domain.Porteiro;
import com.augusto.securegate.domain.dtos.PorteiroDTO;
import com.augusto.securegate.repositories.PorteiroRepository;
import com.augusto.securegate.services.exceptions.ObjectNotFoundException;

@Service
public class PorteiroService {
	
	@Autowired
	private PorteiroRepository repository;
	
	public Porteiro findById(Integer id) {
		Optional<Porteiro> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException ("Objeto não encontrado! ID: " + id));
		
	}

	public List<Porteiro> findAll() {
		return repository.findAll();
	}

	public Porteiro create(PorteiroDTO objDTO) {
		objDTO.setId(null);
		Porteiro newObj = new Porteiro(objDTO);
		return repository.save(newObj);
	}

}
