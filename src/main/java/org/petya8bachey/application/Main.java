package org.petya8bachey.application;

import org.petya8bachey.controller.MyController;
import org.petya8bachey.controller.UserService;
import org.petya8bachey.domain.MyData;
import org.petya8bachey.domain.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableJpaRepositories("org.petya8bachey.repository")
@EntityScan("org.petya8bachey.domain")
@ComponentScan("org.petya8bachey")
@EnableAutoConfiguration
public class Main implements CommandLineRunner {
    @Autowired
    MyController controller;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args){
        System.out.println("Hello");
        // System.exit(0);
    }
}