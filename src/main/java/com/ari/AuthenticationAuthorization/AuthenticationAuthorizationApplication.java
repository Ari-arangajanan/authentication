package com.ari.AuthenticationAuthorization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class AuthenticationAuthorizationApplication {

	public static void main(String[] args) {

		SpringApplication.run(AuthenticationAuthorizationApplication.class, args);
		System.out.println("AuthenticationAuthorizationApplication");
	}

}
