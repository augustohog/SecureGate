package com.augusto.securegate.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.augusto.securegate.domain.Pessoa;
import com.augusto.securegate.domain.Porteiro;
import com.augusto.securegate.domain.dtos.PorteiroDTO;
import com.augusto.securegate.repositories.PessoaRepository;
import com.augusto.securegate.repositories.PorteiroRepository;
import com.augusto.securegate.services.exceptions.DataIntegrityViolationException;
import com.augusto.securegate.services.exceptions.ObjectNotFoundException;

@Service
public class PorteiroService {
	
	@Autowired
	private PorteiroRepository repository;
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Porteiro findById(Integer id) {
		Optional<Porteiro> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException ("Objeto não encontrado! ID: " + id));
		
	}

	public List<Porteiro> findAll() {
		return repository.findAll();
	}

	public Porteiro create(PorteiroDTO objDTO) {
		objDTO.setId(null);
		validaPorCPFEEmail(objDTO);
		Porteiro newObj = new Porteiro(objDTO);
		return repository.save(newObj);
	}

	private void validaPorCPFEEmail(PorteiroDTO objDTO) {
		Optional<Pessoa> obj = pessoaRepository.findByCpf(objDTO.getCpf());
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("CPF já cadastrado no sistema!"); 
		}
		
		obj = pessoaRepository.findByEmail(objDTO.getEmail());
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("Email já cadastrado no sistema!"); 
		}
	}

}
