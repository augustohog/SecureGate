package com.augusto.securegate.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.augusto.securegate.domain.Porteiro;
import com.augusto.securegate.domain.dtos.PorteiroDTO;
import com.augusto.securegate.services.PorteiroService;

@RestController
@RequestMapping(value = "/porteiros")
public class PorteiroResource {
	
	// localhost:8080/porteiros/1
	
	@Autowired
	private PorteiroService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PorteiroDTO> findByID(@PathVariable Integer id){
		Porteiro obj = this.service.findById(id);
		return ResponseEntity.ok().body(new PorteiroDTO(obj));
		
	}
	
	@GetMapping
	public ResponseEntity<List<PorteiroDTO>> findAll(){
		List<Porteiro> list = service.findAll();
		List<PorteiroDTO> listDTO = list.stream().map(obj -> new PorteiroDTO(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDTO);
	}

}
