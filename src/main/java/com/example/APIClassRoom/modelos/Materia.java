package com.example.APIClassRoom.modelos;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity

public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_materia")
    private Integer idMateria;
    @Column(length = 100, nullable = false)
    private String nombre;
    private Integer idCurso;

    @OneToMany
    @JsonManagedReference
    private List<Calificacion> calificacion;

    public Materia() {
    }

    public Materia(Integer idMateria, String nombre, Integer idCurso) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.idCurso = idCurso;
    }

    public Integer getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Integer idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }
}
