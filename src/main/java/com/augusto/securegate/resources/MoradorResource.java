package com.augusto.securegate.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.augusto.securegate.domain.Morador;
import com.augusto.securegate.domain.dtos.MoradorDTO;
import com.augusto.securegate.services.MoradorService;

@RestController
@RequestMapping(value = "/moradores")
public class MoradorResource {
	
	// localhost:8080/moradores/1
	
	@Autowired
	private MoradorService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<MoradorDTO> findByID(@PathVariable Integer id){
		Morador obj = this.service.findById(id);
		return ResponseEntity.ok().body(new MoradorDTO(obj));
		
	}
	
	@GetMapping
	public ResponseEntity<List<MoradorDTO>> findAll(){
		List<Morador> list = service.findAll();
		List<MoradorDTO> listDTO = list.stream().map(obj -> new MoradorDTO(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<MoradorDTO> create(@Valid @RequestBody MoradorDTO objDTO){
		Morador newObj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	@PutMapping(value = "/{id}")
	public ResponseEntity<MoradorDTO> update(@PathVariable Integer id, @Valid @RequestBody MoradorDTO objDTO){
		Morador obj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new MoradorDTO(obj));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<MoradorDTO> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
