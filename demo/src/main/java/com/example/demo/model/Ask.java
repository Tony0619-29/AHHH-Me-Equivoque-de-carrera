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
@Table(name="pregunta")
@Entity
public class Ask {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String pregunta;
    private String tipo;

    @JsonManagedReference
    @OneToMany(mappedBy = "pregunta",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Answer> respuestas;

    public Ask(String pregunta, String tipo) {
        this.pregunta = pregunta;
        this.tipo = tipo;
    }

    public Ask(String id, String pregunta, String tipo) {
        this.id = id;
        this.pregunta = pregunta;
        this.tipo = tipo;
    }

    public Ask(String pregunta, String tipo, Set<Answer> respuestas) {
        this.pregunta = pregunta;
        this.tipo = tipo;
        this.respuestas = respuestas;
    }

    public String getId() {
        return id;
    }

    public String getPregunta() {
        return pregunta;
    }

    public String getTipo() {
        return tipo;
    }

    public Set<Answer> getRespuestas() {
        return respuestas;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setRespuestas(Set<Answer> respuestas) {
        this.respuestas = respuestas;
    }
}
