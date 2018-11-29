package br.propina;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PropinaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PropinaApplication.class, args);
	}
}
