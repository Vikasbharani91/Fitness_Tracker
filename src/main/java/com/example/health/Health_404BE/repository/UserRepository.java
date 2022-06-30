package com.example.health.Health_404BE.repository;

import com.example.health.Health_404BE.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserName(String username);
}
