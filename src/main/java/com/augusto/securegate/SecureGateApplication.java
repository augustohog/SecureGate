package com.augusto.securegate;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.augusto.securegate.domain.Controle;
import com.augusto.securegate.domain.Morador;
import com.augusto.securegate.domain.Porteiro;
import com.augusto.securegate.domain.enums.Perfil;
import com.augusto.securegate.repositories.ControleRepository;
import com.augusto.securegate.repositories.MoradorRepository;
import com.augusto.securegate.repositories.PorteiroRepository;

@SpringBootApplication
public class SecureGateApplication implements CommandLineRunner {

	@Autowired
	private PorteiroRepository porteiroRepository;
	@Autowired
	private MoradorRepository moradorRepository;
	@Autowired
	private ControleRepository controleRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SecureGateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Porteiro por1 = new Porteiro(null, "Augusto", "47748428425");
		por1.addPerfil(Perfil.PORTEIRO);
		
		Morador mor1 = new Morador(null, "Luana", "52056337789");
		mor1.addPerfil(Perfil.MORADOR);
		
		Controle c1 = new Controle(null, "Primeiro Controle", por1, mor1);
		
		porteiroRepository.saveAll(Arrays.asList(por1));
		moradorRepository.saveAll(Arrays.asList(mor1));
		controleRepository.saveAll(Arrays.asList(c1));
		
	}

}
