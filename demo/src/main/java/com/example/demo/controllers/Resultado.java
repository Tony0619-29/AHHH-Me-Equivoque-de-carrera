package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Result;
import com.example.demo.repo.resultadoRepo;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class Resultado {
@Autowired
resultadoRepo repo;

@GetMapping("resultados")
  public List<Result> findAllResultados() {
    return this.repo.findAll();
  }
  
    @PostMapping("resultado")
    public Result addResultado(@RequestBody Result resultado) {
    
        return repo.save(resultado);
    }
    @GetMapping("resultado/{id}")
    public Optional<Result> getById(@PathVariable String id) {
        return repo.findById(id);
    }

    @PutMapping("resultado/{id}")
    public Result putResultado(@PathVariable String id, @RequestBody Result resultado) {
        resultado.setResultado(id);
        return repo.save(resultado);
    }

    @DeleteMapping("resultado/{id}")
    public String deleteResultado(@PathVariable("id") String id) {
        repo.deleteById(id);
        return "{\"success\":true}";
    }


}
