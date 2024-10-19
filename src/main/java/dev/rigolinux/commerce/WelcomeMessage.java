package dev.rigolinux.commerce;

import org.springframework.stereotype.Component;

@Component("WelcomeMessage")
public class WelcomeMessage {
    public String getWelcomeMessage(){
        return "Welcome To My Spring Application";
    }


}
