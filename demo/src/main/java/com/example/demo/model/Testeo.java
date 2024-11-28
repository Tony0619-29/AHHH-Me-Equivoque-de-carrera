package com.example.demo.model;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
@Entity
@Table(name="tests")
public class Testeo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nombreTests;
    private String descripcion;
    private LocalDate fechaCreacion;

    @JsonBackReference
    @ManyToOne(fetch=FetchType.LAZY)
    private User usuario;

    @JsonBackReference
    @OneToMany(mappedBy = "testeo",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Career> carreras;

    public Testeo(String nombreTests, String descripcion, LocalDate fechaCreacion, User usuario, Set<Career> carreras) {
        this.nombreTests = nombreTests;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.usuario = usuario;
        this.carreras = carreras;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombreTests(String nombreTests) {
        this.nombreTests = nombreTests;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public void setCarreras(Set<Career> carreras) {
        this.carreras = carreras;
    }

    public String getId() {
        return id;
    }

    public String getNombreTests() {
        return nombreTests;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public User getUsuario() {
        return usuario;
    }

    public Set<Career> getCarreras() {
        return carreras;
    }

    public Optional<Career> getCareerById(String id) {
        return carreras.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    public void addCareer(Career career) {
        carreras.add(career);
    }

    public void removeCareer(Career career) {
        carreras.remove(career);
    }

    public void updateCareer(Career career) {
        carreras.removeIf(c -> c.getId().equals(career.getId()));
        carreras.add(career);
    }

    public void updateCareer(String id, Career career) {
        carreras.removeIf(c -> c.getId().equals(id));
        carreras.add(career);
    }

    public void deleteCareer(String id) {
        carreras.removeIf(c -> c.getId().equals(id));
    }

}
