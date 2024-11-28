package com.example.demo.model;
import java.time.LocalDate;
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
@Table(name="respuestas")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String respuesta;
    private LocalDate fechaRespuesta;

    @JsonBackReference
    @ManyToOne(fetch=FetchType.LAZY)
    private Ask pregunta;

    @JsonBackReference
    @ManyToOne(fetch=FetchType.LAZY)
    private Result resultado;

    public Answer(String respuesta, LocalDate fechaRespuesta, Ask pregunta, Result resultado) {
        this.respuesta = respuesta;
        this.fechaRespuesta = fechaRespuesta;
        this.pregunta = pregunta;
        this.resultado = resultado;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public void setFechaRespuesta(LocalDate fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }

    public void setPregunta(Ask pregunta) {
        this.pregunta = pregunta;
    }

    public void setResultado(Result resultado) {
        this.resultado = resultado;
    }

    public String getId() {
        return id;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public LocalDate getFechaRespuesta() {
        return fechaRespuesta;
    }

    public Ask getPregunta() {
        return pregunta;
    }

    public Result getResultado() {
        return resultado;
    }

    public Optional<Ask> getPreguntaOpt() {
        return Optional.ofNullable(pregunta);
    }

    public Optional<Result> getResultadoOpt() {
        return Optional.ofNullable(resultado);
    }
    
}
