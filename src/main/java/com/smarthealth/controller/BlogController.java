package com.smarthealth.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
@CrossOrigin(origins = "*")
public class BlogController {
    File directory = new File("./src/main/resources");
    ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("blog")
    public JsonNode blog() throws IOException {
        return objectMapper.readTree(Files.newInputStream(Paths.get(directory + "/blog.json")));
    }

    @GetMapping("blogById/{id}")
    public JsonNode blogById(@PathVariable int id) throws IOException {
        ArrayNode arrayNode = (ArrayNode) objectMapper.readTree(Files.newInputStream(Paths.get(directory + "/blog.json")));
        if (arrayNode.isArray()) {
            for (JsonNode jsonNode : arrayNode) {
                if (jsonNode.path("blogId").intValue() == id)
                    return jsonNode;
            }
        }
        return objectMapper.createObjectNode().put("error", "blogId not found");
    }
}
