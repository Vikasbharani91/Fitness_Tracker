package com.smart_health.controller;

import com.smart_health.entity.AuthRequest;
import com.smart_health.util.JwtUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
@RequestMapping("fitworld")
public class FitWorld {
    File directory = new File("./src/main/resources");
    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("blog")
    public JsonNode blog() throws IOException {
        return objectMapper.readTree(Files.newInputStream(Paths.get(directory + "/blog.json")));
    }

    @GetMapping("consultants")
    public JsonNode consultants() throws IOException {
        return objectMapper.readTree(Files.newInputStream(Paths.get(directory + "/consultants.json")));
    }

    @GetMapping("consultant/{id}")
    public JsonNode ashokdinda(@PathVariable Integer id) throws IOException {
        return id == 1 ?
                objectMapper.readTree(Files.newInputStream(Paths.get(directory + "/ashokdinda.json"))) :
                objectMapper.createObjectNode().put("error", "id not found");
    }

    @GetMapping("blog/{id}")
    public JsonNode controlbloodsugar(@PathVariable Integer id) throws IOException {
        return id == 1 ?
                objectMapper.readTree(Files.newInputStream(Paths.get(directory + "/controlbloodsugar.json"))) :
                objectMapper.createObjectNode().put("error", "id not found");
    }

    @PostMapping("authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("invalid username/password");
        }
        return jwtUtil.generateToken(authRequest.getUserName());
    }


}
