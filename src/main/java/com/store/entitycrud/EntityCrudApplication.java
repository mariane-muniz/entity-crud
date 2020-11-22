package com.store.entitycrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories(basePackages = {"com.store.entitycrud.repositories"})
@EntityScan(basePackages = {"com.store.entitycrud.entities"})
@SpringBootApplication
public class EntityCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(EntityCrudApplication.class, args);
	}
}