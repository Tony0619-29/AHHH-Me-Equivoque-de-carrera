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
@Table(name="universidad")
@Entity

public class University {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idUniversidad;
    private String nombre;
    private String tipo;
    private String paginaWeb;

    @JsonManagedReference
    @OneToMany(mappedBy = "universidad",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Career> carreras;

    public University(String nombre, String tipo, String paginaWeb) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.paginaWeb = paginaWeb;
    }

    public University(String idUniversidad, String nombre, String tipo, String paginaWeb) {
        this.idUniversidad = idUniversidad;
        this.nombre = nombre;
        this.tipo = tipo;
        this.paginaWeb = paginaWeb;
    }
    
    public University(String nombre, String tipo, String paginaWeb, Set<Career> carreras) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.paginaWeb = paginaWeb;
        this.carreras = carreras;
    }

    public void setIdUniversidad(String idUniversidad) {
        this.idUniversidad = idUniversidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public void setCarreras(Set<Career> carreras) {
        this.carreras = carreras;
    }

    public String getIdUniversidad() {
        return idUniversidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public Set<Career> getCarreras() {
        return carreras;
    }

    public void addCareer(Career career) {
        this.carreras.add(career);
    }

    public void removeCareer(Career career) {
        this.carreras.remove(career);
    }

}
