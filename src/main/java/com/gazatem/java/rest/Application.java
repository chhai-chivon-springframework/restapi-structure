package com.gazatem.java.rest;

import com.gazatem.java.rest.domain.User;
import com.gazatem.java.rest.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

/*
    @Bean
    CommandLineRunner init(final UserRepository userRepository) {

        return new CommandLineRunner() {

            @Override
            public void run(String... arg0) throws Exception {
                userRepository.save(new User("kemal", "password"));

            }

        };

    }*/
}