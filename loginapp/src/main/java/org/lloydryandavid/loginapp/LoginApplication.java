package org.lloydryandavid.loginapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@SpringBootApplication
public class LoginApplication extends SpringBootServletInitializer{

    public static void main(String[] args) {
        SpringApplication.run(LoginApplication.class, args);
    }

}