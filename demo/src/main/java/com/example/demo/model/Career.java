package com.example.demo.model;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="carreras")
public class Career {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nombreCarrera;
    private String duracion;
    private String descripcion;
    
    @JsonBackReference
    @ManyToOne(fetch=FetchType.LAZY)
    private University universidad;

    @JsonBackReference
    @ManyToOne(fetch=FetchType.LAZY)
    private Testeo testeo;

    public Career(String nombreCarrera, String duracion, String descripcion, University universidad, Testeo testeo) {
        this.nombreCarrera = nombreCarrera;
        this.duracion = duracion;
        this.descripcion = descripcion;
        this.universidad = universidad;
        this.testeo = testeo;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }   

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public String getId() {
        return id;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public String getDuracion() {
        return duracion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public University getUniversidad() {
        return universidad;
    }

    public Testeo getTesteo() {
        return testeo;
    }

    public void setUniversidad(University universidad) {
        this.universidad = universidad;
    }

    public void setTesteo(Testeo testeo) {
        this.testeo = testeo;
    }


}
