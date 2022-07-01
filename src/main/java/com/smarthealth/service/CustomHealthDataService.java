package com.smarthealth.service;

import com.smarthealth.entity.HealthData;
import com.smarthealth.repository.HealthDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomHealthDataService {

    @Autowired
    HealthDataRepository healthDataRepository;

    public void createHealthData(HealthData healthData) {
        healthDataRepository.save(healthData);
    }

    public List<HealthData> fetchAllHealthData() {
        return healthDataRepository.findAll();
    }

    public List<HealthData> latestRecords() {
        return healthDataRepository.latestHealthData();
    }
}
