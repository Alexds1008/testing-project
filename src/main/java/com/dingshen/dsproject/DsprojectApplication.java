package com.dingshen.dsproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.dingshen.dsproject.repository")
@EntityScan("com.dingshen.dsproject.model")
@SpringBootApplication
public class DsprojectApplication {


	public static void main(String[] args) {
		SpringApplication.run(DsprojectApplication.class, args);
	}

}
