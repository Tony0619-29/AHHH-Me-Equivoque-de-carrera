package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Career;

public interface carreraRepo extends JpaRepository<Career, String> {

}