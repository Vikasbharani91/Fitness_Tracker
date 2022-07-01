package com.smarthealth.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "https://main.d3mrx3tpmlgw1i.amplifyapp.com/"})
public class Welcome {
    @GetMapping("/")
    public String welcome() {
        return "welcome to fitWorld";
    }
}
