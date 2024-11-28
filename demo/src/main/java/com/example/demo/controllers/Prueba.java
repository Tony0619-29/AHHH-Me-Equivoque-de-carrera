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

import com.example.demo.model.Testeo;
import com.example.demo.model.User;
import com.example.demo.repo.pruebaRepo;
import com.example.demo.repo.usuarioRepo;

@RestController
public class Prueba {
 
@Autowired
pruebaRepo repo;
@Autowired
usuarioRepo repoUsuario;
@GetMapping("pruebas")
  public List<Testeo> findAllpruebas() {
    return this.repo.findAll();
  }
  
@PostMapping("prueba")
    public Testeo addprueba(@RequestBody Testeo prueba) {
    
        return repo.save(prueba);
    }
    @PostMapping("prueba/{userId}")
    public Testeo addprueba(@RequestBody Testeo prueba,@PathVariable String userId) {
        Optional<User> u = repoUsuario.findById(userId);
        if(u.isPresent()){
        System.out.println(u.get().getNombre());
        prueba.setUsuario(u.get());
        }
        return repo.save(prueba);
    
    }
    @GetMapping("pruebas/{userId}")
    public Set<Testeo>  getTestsByUser(@PathVariable String userId) {
        Optional<User> u = repoUsuario.findById(userId);
        if(u.isPresent()){
        return  u.get().getPruebas();
        }
        return null;
    
    }

@GetMapping("prueba/{id}")
public Optional<Testeo> getById(@PathVariable String id) {
    return repo.findById(id);
}

@PutMapping("prueba/{id}")
public Testeo putusuari(@PathVariable String id, @RequestBody Testeo prueba) {
    prueba.setId(id);
    return repo.save(prueba);
}

@DeleteMapping("prueba/{id}")
public String deletePrueba(@PathVariable("id") String id) {
    repo.deleteById(id);
    return "{\"success\":true}";

}
}