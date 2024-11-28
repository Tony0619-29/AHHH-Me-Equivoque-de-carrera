package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.model.Ask;

public interface preguntaRepo extends JpaRepository <Ask,String>{
    
}