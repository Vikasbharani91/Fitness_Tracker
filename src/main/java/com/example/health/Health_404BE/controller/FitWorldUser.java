package com.example.health.Health_404BE.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
public class FitWorldUser {

    File directory = new File("./src/main/resources");
    ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/")
    public String welcome()  {
        return "welcome to fitWorld";
    }

    @GetMapping("record")
    public JsonNode record() throws IOException {
        return objectMapper.readTree(Files.newInputStream(Paths.get(directory + "/record.json")));
    }
}
