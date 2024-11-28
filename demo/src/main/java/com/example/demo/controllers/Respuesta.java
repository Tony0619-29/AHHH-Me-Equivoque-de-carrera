package com.example.demo.controllers;
import java.util.List;
import java.util.Optional;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Ask;
import com.example.demo.model.Answer;
import com.example.demo.model.Result;
import com.example.demo.repo.preguntaRepo;
import com.example.demo.repo.respuestaRepo;
import com.example.demo.repo.resultadoRepo;

@RestController
public class Respuesta {

@Autowired
respuestaRepo repo;
@Autowired
preguntaRepo repoPregunta;
@Autowired
resultadoRepo repoResultado;
    @GetMapping("respuestas")
     public List<Answer> findAllRespuestas() {
    return this.repo.findAll();
     }

    @PostMapping("respuesta")
    public Answer addRespuesta(@RequestBody Answer respuesta) {
    return repo.save(respuesta);
    }
    @PostMapping("respuesta/{preguntaId}/{resultadoId}")
    public Answer addRespuesta(@RequestBody Answer respuesta,@PathVariable String preguntaId,@PathVariable String resultadoId) {
        Optional<Ask> p = repoPregunta.findById(preguntaId);
        Optional<Result> r = repoResultado.findById(resultadoId);
        if(p.isPresent() && r.isPresent()){
        System.out.println(p.get().getPregunta());
        System.out.println(r.get().getResultado());
        respuesta.setPregunta(p.get());
        respuesta.setResultado(r.get());
        }
        return repo.save(respuesta);
    
    }
    @GetMapping("respuestas/{resultadoId}")
    public Set<Answer>  getRespuestasByResultado(@PathVariable String resultadoId) {
        Optional<Result> r = repoResultado.findById(resultadoId);
        if(r.isPresent()){
        return  r.get().getRespuestas();
        }
        return null;
    
    }
    @GetMapping("respuestas/{preguntaId}")
    public Set<Answer>  getRespuestasByPregunta(@PathVariable String preguntaId) {
        Optional<Ask> p = repoPregunta.findById(preguntaId);
        if(p.isPresent()){
        return  p.get().getRespuestas();
        }
        return null;
    
    }

    @GetMapping("respuesta/{id}")
    public Optional<Answer> getById(@PathVariable String id) {
    return
    repo.findById(id);
    
    }

    @PutMapping("respuesta/{id}")
    public Answer putRespuesta(@PathVariable String id, @RequestBody Answer respuesta) {
    respuesta.setRespuesta(id);
    return repo.save(respuesta);
    }

    @DeleteMapping("respuesta/{id}")
    public String deleteRespuesta(@PathVariable("id") String id) {
    repo.deleteById(id);
    return "{\"success\":true}";
    }
    
}
