package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Answer;

public interface respuestaRepo extends JpaRepository<Answer, String> {
    
}