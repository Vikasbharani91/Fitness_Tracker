package com.example.health.Health_404BE;

import com.example.health.Health_404BE.entity.User;
import com.example.health.Health_404BE.repository.UserRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "fitworld", version = "1.0", description = "fitworld developed by team 404"))
public class SmartHealthApplication {

    @Autowired
    private UserRepository repository;

    @PostConstruct
    public void initUsers() {
        List<User> users = Stream.of(
                new User(101, "team404", "password", "team404@gmail.com")
        ).collect(Collectors.toList());
        repository.saveAll(users);
    }

    public static void main(String[] args) {
        SpringApplication.run(SmartHealthApplication.class, args);
    }

}
