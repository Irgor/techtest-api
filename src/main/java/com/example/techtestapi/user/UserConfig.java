package com.example.techtestapi.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository) {
        return  args -> {
            User igor = new User(
                    100,
                    "Igor",
                    "PF",
                    "CPF",
                    "RG",
                    LocalDate.of(2002, Month.MARCH, 10),
                    "11946679461",
                    true
            );

            User mariam = new User(
                    101,
                    "Mariam",
                    "PF",
                    "CPF",
                    "RG",
                    LocalDate.of(2002, Month.MARCH, 10),
                    "11946679461",
                    true
            );

            repository.saveAll(List.of(igor, mariam));
        };
    }
}
