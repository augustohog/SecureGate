package com.augusto.securegate.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.augusto.securegate.domain.Controle;
import com.augusto.securegate.domain.Morador;
import com.augusto.securegate.domain.Porteiro;
import com.augusto.securegate.domain.enums.Perfil;
import com.augusto.securegate.domain.enums.Status;
import com.augusto.securegate.repositories.ControleRepository;
import com.augusto.securegate.repositories.MoradorRepository;
import com.augusto.securegate.repositories.PorteiroRepository;

@Service
public class DBService {
	
	@Autowired
	private PorteiroRepository porteiroRepository;
	@Autowired
	private MoradorRepository moradorRepository;
	@Autowired
	private ControleRepository controleRepository;
	
	public void instanciaDB() {
		Porteiro por1 = new Porteiro(null, "Augusto", "47748428425", "augusto@mail.com", "123");
		por1.addPerfil(Perfil.PORTEIRO);
		
		Morador mor1 = new Morador(null, "Luana", "52056337789", "luana@mail.com", "123");
		mor1.addPerfil(Perfil.MORADOR);
		
		Controle c1 = new Controle(null, Status.RESIDENTE, "Primeiro Controle", por1, mor1);
		
		porteiroRepository.saveAll(Arrays.asList(por1));
		moradorRepository.saveAll(Arrays.asList(mor1));
		controleRepository.saveAll(Arrays.asList(c1));
	}

}
