package com.augusto.securegate.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.augusto.securegate.domain.Controle;
import com.augusto.securegate.domain.Morador;
import com.augusto.securegate.domain.Porteiro;
import com.augusto.securegate.domain.dtos.ControleDTO;
import com.augusto.securegate.domain.enums.Status;
import com.augusto.securegate.repositories.ControleRepository;
import com.augusto.securegate.services.exceptions.ObjectNotFoundException;

@Service
public class ControleService {
	@Autowired
	private ControleRepository repository;
	@Autowired
	private PorteiroService porteiroService;
	@Autowired
	private MoradorService moradorService;
	
	public Controle findById(Integer id) {
		Optional<Controle> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id));
	}

	public List<Controle> findAll() {
		return repository.findAll();
	}

	public Controle create(@Valid ControleDTO objDTO) {
		return repository.save(newControle(objDTO));
	}
	
	private Controle newControle(ControleDTO obj) {
		Porteiro porteiro = porteiroService.findById(obj.getPorteiro());
		Morador morador = moradorService.findById(obj.getMorador());
		
		Controle controle = new Controle();
		if(obj.getId() != null) {
			controle.setId(obj.getId());
		}
		
		controle.setPorteiro(porteiro);
		controle.setMorador(morador);
		controle.setStatus(Status.toEnum(obj.getStatus()));
		controle.setObservações(obj.getObservações());
		return controle;
		
	}

}
