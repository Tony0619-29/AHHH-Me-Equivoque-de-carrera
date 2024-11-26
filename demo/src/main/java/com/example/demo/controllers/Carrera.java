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


import com.example.demo.model.Career;
import com.example.demo.model.University;
import com.example.demo.model.Testeo;
import com.example.demo.repo.carreraRepo;
import com.example.demo.repo.universidadRepo;
import com.example.demo.repo.pruebaRepo;

@RestController
public class Carrera {

@Autowired
carreraRepo repo;
@Autowired
universidadRepo repoUniversidad;
@Autowired
pruebaRepo repoPrueba;
@GetMapping("carreras")
  public List<Career> findAllCarreras() {
    return this.repo.findAll();
  }

@PostMapping("carrera")
    public Career addCarrera(@RequestBody Career carrera) {
    
        return repo.save(carrera);
    }
    @PostMapping("carrera/{universityId}")
    public Career addCarrera(@RequestBody Career carrera,@PathVariable String universityId) {
        Optional<University> u = repoUniversidad.findById(universityId);
        if(u.isPresent()){
        System.out.println(u.get().getNombre());
        carrera.setUniversidad(u.get());
        }
        return repo.save(carrera);
    
    }
    @GetMapping("carreras/{universityId}")
    public Set<Career>  getCareersByUniversity(@PathVariable String universityId) {
        Optional<University> u = repoUniversidad.findById(universityId);
        if(u.isPresent()){
        return  u.get().getCarreras();
        }
        return null;
    
    }

@GetMapping("carrera/{id}")
public Optional<Career> getById(@PathVariable String id) {
    return repo.findById(id);
}

@PutMapping("carrera/{id}")
public Career putCarrera(@PathVariable String id, @RequestBody Career carrera) {
    carrera.setId(id);
    return repo.save(carrera);
}

@DeleteMapping("carrera/{id}")
public String deleteCarrera(@PathVariable("id") String id) {
    repo.deleteById(id);
    return "{\"success\":true}";
}

}


