package com.example.demo.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Result;

public interface resultadoRepo extends JpaRepository <Result,String>{
    
}
