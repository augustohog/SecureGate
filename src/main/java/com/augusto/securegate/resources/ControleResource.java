package com.augusto.securegate.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.augusto.securegate.domain.Controle;
import com.augusto.securegate.domain.dtos.ControleDTO;
import com.augusto.securegate.services.ControleService;

@RestController
@RequestMapping(value = "/controles")
public class ControleResource {
	
	@Autowired
	private ControleService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ControleDTO> findById(@PathVariable Integer id){
		Controle obj = service.findById(id);
		return ResponseEntity.ok().body(new ControleDTO(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<ControleDTO>> findAll(){
		List<Controle> list = service.findAll();
		List<ControleDTO> listDTO = list.stream().map(obj -> new ControleDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

}
