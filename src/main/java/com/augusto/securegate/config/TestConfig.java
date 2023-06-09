package com.augusto.securegate.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.augusto.securegate.services.DBService;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DBService dbservice;

    @Bean
    void instanciaDB() {
		this.dbservice.instanciaDB();
	}

}
