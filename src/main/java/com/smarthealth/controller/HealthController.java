package com.smarthealth.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smarthealth.entity.HealthData;
import com.smarthealth.service.CustomHealthDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.List;

@RestController
@RequestMapping("health")
@CrossOrigin(origins = "*")
public class HealthController {

    @Autowired
    CustomHealthDataService customHealthDataService;
    File directory = new File("./src/main/resources");
    ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping("addHealthdata")
    public void addHealthdata(@RequestBody HealthData healthData) {
        customHealthDataService.createHealthData(healthData);
    }

    @GetMapping("history")
    public List<HealthData> history() {
        List<HealthData> healthData=customHealthDataService.fetchAllHealthData();
        if(healthData.size()<=7)
            return healthData;
        else
            return customHealthDataService.latestRecords();
    }
}
