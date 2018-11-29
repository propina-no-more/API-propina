package br.propinanomore.propinanomore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class PropinanomoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(PropinanomoreApplication.class, args);
	}
}
