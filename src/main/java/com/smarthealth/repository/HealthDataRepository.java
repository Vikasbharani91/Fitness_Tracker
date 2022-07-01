package com.smarthealth.repository;

import com.smarthealth.entity.HealthData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HealthDataRepository extends JpaRepository<HealthData,Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM (SELECT * FROM HEALTHHISTORY ORDER BY COUNT DESC LIMIT 7) t ORDER BY COUNT ASC")
    List<HealthData> latestHealthData();

}
