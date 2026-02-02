package com.aluracursos.registroanimales;

import com.aluracursos.registroanimales.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RegistroanimalesApplication  implements CommandLineRunner {

	private final Principal principal;

    public RegistroanimalesApplication(Principal principal) {
        this.principal = principal;
    }

    public static void main(String[] args) {
		SpringApplication.run(RegistroanimalesApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		principal.muestraElMenu();
	}
}
