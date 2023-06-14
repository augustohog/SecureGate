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
		Porteiro por1 = new Porteiro(null, "Augusto Henrique", "550.482.150-95", "augusto@mail.com", "123");
		por1.addPerfil(Perfil.PORTEIRO);
		Porteiro por2 = new Porteiro(null, "Luana Souza", "903.347.070-56", "luana@mail.com", "123");
		Porteiro por3 = new Porteiro(null, "Claude Elwood Shannon", "271.068.470-54", "shannon@mail.com", "123");
		Porteiro por4 = new Porteiro(null, "Tim Berners-Lee", "162.720.120-39", "lee@mail.com", "123");
		Porteiro por5 = new Porteiro(null, "Linus Torvalds", "778.556.170-27", "linus@mail.com", "123");
		
		Morador mor1 = new Morador(null, "Albert Einstein", "111.661.890-74", "einstein@mail.com", "123");
		Morador mor2 = new Morador(null, "Marie Curie", "322.429.140-06", "curie@mail.com","123");
		Morador mor3 = new Morador(null, "Charles Darwin", "792.043.830-62", "darwin@mail.com", "123");
		Morador mor4 = new Morador(null, "Stephen Hawking", "177.409.680-30", "hawking@mail.com", "123");
		Morador mor5 = new Morador(null, "Max Planck", "081.399.300-83", "planck@mail.com", "123");
 
		Controle c1 = new Controle(null, Status.ABERTO, "Controle 1", por1, mor1);
		Controle c2 = new Controle(null, Status.ABERTO, "Visitante morador2", por2, mor2);
		Controle c3 = new Controle(null, Status.ABERTO, "Visitante morador3", por3, mor3);
		Controle c4 = new Controle(null, Status.ABERTO, "Controle 1", por4, mor4);
		Controle c5 = new Controle(null, Status.ABERTO, "Controle 1", por5, mor5);
		

		porteiroRepository.saveAll(Arrays.asList(por1, por2, por3, por4, por5));
		moradorRepository.saveAll(Arrays.asList(mor1, mor2, mor3, mor4, mor5));
		controleRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5));
	}

}
