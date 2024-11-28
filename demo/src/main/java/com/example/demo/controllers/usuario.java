package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repo.usuarioRepo;

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
public class usuario {
@Autowired
usuarioRepo repo;
@GetMapping("usuarios")
  public List<User> findAllUsuarios() {
    return this.repo.findAll();
  }

@PostMapping("usuario")
    public User addUsuario(@RequestBody User usuario) {
        return repo.save(usuario);
    }

@GetMapping("usuario/{id}")
public Optional<User> getById(@PathVariable String id) {
    return repo.findById(id);

}
@PutMapping("usuario/{id}")
public User putUser(@PathVariable String id, @RequestBody User user) {
    user.setIdUsuario(id);
    return repo.save(user);
}

@DeleteMapping("usuario/{id}")
public String deleteUser(@PathVariable("id") String id) {
    repo.deleteById(id);
    return "{\"success\":true}";
}

}
