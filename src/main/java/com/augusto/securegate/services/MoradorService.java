package com.augusto.securegate.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.augusto.securegate.domain.Pessoa;
import com.augusto.securegate.domain.Morador;
import com.augusto.securegate.domain.dtos.MoradorDTO;
import com.augusto.securegate.repositories.PessoaRepository;
import com.augusto.securegate.repositories.MoradorRepository;
import com.augusto.securegate.services.exceptions.DataIntegrityViolationException;
import com.augusto.securegate.services.exceptions.ObjectNotFoundException;

@Service
public class MoradorService {
	
	@Autowired
	private MoradorRepository repository;
	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public Morador findById(Integer id) {
		Optional<Morador> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException ("Objeto não encontrado! ID: " + id));
		
	}

	public List<Morador> findAll() {
		return repository.findAll();
	}

	public Morador create(MoradorDTO objDTO) {
		objDTO.setId(null);
		objDTO.setSenha(encoder.encode(objDTO.getSenha()));
		validaPorCPFEEmail(objDTO);
		Morador newObj = new Morador(objDTO);
		return repository.save(newObj);
	}
	
	public Morador update(Integer id, @Valid MoradorDTO objDTO) {
		objDTO.setId(id);
		Morador oldObj = findById(id);
		validaPorCPFEEmail(objDTO);
		oldObj = new Morador(objDTO);
		return repository.save(oldObj);
	}
	
	public void delete(Integer id) {
		Morador obj = findById(id);
		if(obj.getControles().size() > 0) {
			throw new DataIntegrityViolationException("O morador possui controles de entrada e não pode ser deletado!!!");
		}
			repository.deleteById(id);
	}
	
	private void validaPorCPFEEmail(MoradorDTO objDTO) {
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
