package dev.rigolinux.commerce;


import dev.rigolinux.commerce.run.Location;
import dev.rigolinux.commerce.run.Run;
import dev.rigolinux.commerce.services.DatabaseConnectionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;


@SpringBootApplication
public class RunnerApp {

	private static final Logger log = LoggerFactory.getLogger(RunnerApp.class);

	@Autowired
	private DatabaseConnectionService databaseConnectionService;

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(RunnerApp.class, args);




		//log.info("App Should go");
		//WelcomeMessage welcomeMessage = (WelcomeMessage) context.getBean("WelcomeMessage");
		//System.out.println(welcomeMessage.getWelcomeMessage());
		//this is a comment
		//var message = new dev.rigolinux.commerce.WelcomeMessage();
		//System.out.println(message.getWelcomeMessage());
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			if (databaseConnectionService.isConnected()) {
				log.info("Conexión a PostgreSQL exitosa.");
			} else {
				log.error("Error en la conexión a PostgreSQL.");
			}
			Run run = new Run(1,"Morning Run", LocalDateTime.now(),LocalDateTime.now().plusHours(1), 5,Location.INDOOR);
			log.info("Run: "+ run);
		};
	}

}
