package com.smarthealth.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="HEALTHHISTORY")
public class HealthData {
    @Id
    @Column(name="COUNT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int healthDataCount;
    int height;
    int steps;
    int bpm;
    int bloodGluscose;
    int weight;
    String bp;
    int bmi;
}
