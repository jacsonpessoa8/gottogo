package com.gottogo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class GottogoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GottogoApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("ppatrik"));
	}
}
