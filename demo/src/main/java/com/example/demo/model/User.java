package com.example.demo.model;


import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="usuario")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idUsuario;

    private String nombre;
    private String paterno;
    private String materno;
    private String correo;
    
    @JsonManagedReference
    @OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Testeo> pruebas;

    public User(String nombre, String paterno, String materno, String correo) {
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.correo = correo;
    }
    public User(String nombre, String paterno, String materno, String correo, Set<Testeo> pruebasList) {
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.correo = correo;
        this.pruebas = pruebasList; 
    }

    public User(String idUsuario, String nombre, String paterno, String materno, String correo) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.correo = correo;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Set<Testeo> getPruebas() {
        return pruebas;
    }

    public void setPruebas(Set<Testeo> pruebas) {
        this.pruebas = pruebas;
    }


}
