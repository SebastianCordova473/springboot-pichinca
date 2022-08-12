package com.pichinca.ecu.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// @EnableJpaRepositories("com.pichinca.ecu.app.repository")
@ComponentScan(basePackages = { "com.pichinca.ecu.app.*" })
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

}
