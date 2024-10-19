package dev.rigolinux.commerce;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RunnerApp {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(RunnerApp.class, args);

		WelcomeMessage welcomeMessage = (WelcomeMessage) context.getBean("WelcomeMessage");
		System.out.println(welcomeMessage.getWelcomeMessage());
		//this is a comment
		//var message = new dev.rigolinux.commerce.WelcomeMessage();
		//System.out.println(message.getWelcomeMessage());
	}

}
