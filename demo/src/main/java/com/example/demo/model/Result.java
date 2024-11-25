package com.example.demo.model;

import java.time.LocalDate;
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

public class Result {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private Number puntuaje;
    private LocalDate fechaDeAplicacion;
    private String resultado;
    private String area;
    private String descripcion;

    @JsonManagedReference
    @OneToMany(mappedBy = "resultado",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Answer> respuestas;

    public Result(String id, Number puntuaje, LocalDate fechaDeAplicacion, String resultado, String area, String descripcion) {
        this.id = id;
        this.puntuaje = puntuaje;
        this.fechaDeAplicacion = fechaDeAplicacion;
        this.resultado = resultado;
        this.area = area;
        this.descripcion = descripcion;
    }

    public Result(Number puntuaje, LocalDate fechaDeAplicacion, String resultado, String area, String descripcion, Set<Answer> respuestas) {
        this.puntuaje = puntuaje;
        this.fechaDeAplicacion = fechaDeAplicacion;
        this.resultado = resultado;
        this.area = area;
        this.descripcion = descripcion;
        this.respuestas = respuestas;
    }

    public Result(Number puntuaje, LocalDate fechaDeAplicacion, String resultado, String area, String descripcion) {
        this.puntuaje = puntuaje;
        this.fechaDeAplicacion = fechaDeAplicacion;
        this.resultado = resultado;
        this.area = area;
        this.descripcion = descripcion;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPuntuaje(Number puntuaje) {
        this.puntuaje = puntuaje;
    }

    public void setFechaDeAplicacion(LocalDate fechaDeAplicacion) {
        this.fechaDeAplicacion = fechaDeAplicacion;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setRespuestas(Set<Answer> respuestas) {
        this.respuestas = respuestas;
    }

    public String getId() {
        return id;
    }

    public Number getPuntuaje() {
        return puntuaje;
    }

    public LocalDate getFechaDeAplicacion() {
        return fechaDeAplicacion;
    }

    public String getResultado() {
        return resultado;
    }

    public String getArea() {
        return area;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Set<Answer> getRespuestas() {
        return respuestas;
    }

    public void addRespuesta(Answer respuesta) {
        this.respuestas.add(respuesta);
    }

    public void removeRespuesta(Answer respuesta) {
        this.respuestas.remove(respuesta);
    }

}
