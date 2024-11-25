package com.example.demo.controllers;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.University;
import com.example.demo.repo.universidadRepo;


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
public class Universidad {
@Autowired
universidadRepo repo;

@GetMapping("universidades")
  public List<University> findAllUniversidades() {
    return this.repo.findAll();
  }

@PostMapping("universidad")
    public University addUniversidad(@RequestBody University universidad) {
        return repo.save(universidad);
    }

@GetMapping("universidad/{id}")
public Optional<University> getById(@PathVariable String id) {
    return repo.findById(id);

}

@PutMapping("universidad/{id}")
public University putUniversidad(@PathVariable String id, @RequestBody University universidad) {
    universidad.setIdUniversidad(id);
    return repo.save(universidad);
}

@DeleteMapping("universidad/{id}")
public String deleteUniversidad(@PathVariable("id") String id) {
    repo.deleteById(id);
    return "{\"success\":true}";
}
}
