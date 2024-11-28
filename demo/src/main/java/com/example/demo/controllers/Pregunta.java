package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Ask;
import com.example.demo.repo.preguntaRepo;

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
public class Pregunta {
    
    @Autowired
    preguntaRepo repo;

    @GetMapping("preguntas")
    public List<Ask> findAllPreguntas() {
        return this.repo.findAll();
    }

    @PostMapping("pregunta")
    public Ask addPregunta(@RequestBody Ask pregunta) {
        return repo.save(pregunta);
    }

    @GetMapping("pregunta/{id}")
    public Optional<Ask> getById(@PathVariable String id) {
        return repo.findById(id);
    }

    @PutMapping("pregunta/{id}")
    public Ask putPregunta(@PathVariable String id, @RequestBody Ask pregunta) {
        pregunta.setPregunta(id);
        return repo.save(pregunta);
    }

    @DeleteMapping("pregunta/{id}")
    public String deletePregunta(@PathVariable("id") String id) {
        repo.deleteById(id);
        return "{\"success\":true}";
    }

}
