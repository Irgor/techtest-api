package com.example.techtestapi;

import com.example.techtestapi.user.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@CrossOrigin(origins = "*")
public class TechtestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechtestApiApplication.class, args);
	}

}
