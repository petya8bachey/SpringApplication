package org.petya8bachey.application;

import org.petya8bachey.controller.MyController;
import org.petya8bachey.domain.MyData;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("org.petya8bachey.repository")
@EntityScan("org.petya8bachey.domain")
@ComponentScan("org.petya8bachey")
@EnableAutoConfiguration
public class Main implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args){
        System.out.println("Hello");
        MyData myData = new MyData();
        myData.data = "123";
        // System.exit(0);
    }
}