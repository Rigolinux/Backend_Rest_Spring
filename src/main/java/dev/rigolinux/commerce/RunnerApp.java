package dev.rigolinux.commerce;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;



@SpringBootApplication
public class RunnerApp {

	private static final Logger log = LoggerFactory.getLogger(RunnerApp.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(RunnerApp.class, args);
		log.info("App Should go");

		//WelcomeMessage welcomeMessage = (WelcomeMessage) context.getBean("WelcomeMessage");
		//System.out.println(welcomeMessage.getWelcomeMessage());
		//this is a comment
		//var message = new dev.rigolinux.commerce.WelcomeMessage();
		//System.out.println(message.getWelcomeMessage());
	}

}
