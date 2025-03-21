package com.example.APIClassRoom.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Calificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_calificacion")
    private Integer idCalificacion;
    private Integer idEstudiante;
    private Integer idMateria;
    @Column(nullable = false)
    private  Float nota;
    @Column(nullable = false)
    private Date fechaEvaluacion;

    @ManyToOne
    @JoinColumn(name = "fk_materia", referencedColumnName = "id_materia")
    @JsonBackReference
    private Materia materia;

    public Calificacion() {
    }

    public Calificacion(Integer idCalificacion, Integer idEstudiante, Integer idMateria, Float nota, Date fechaEvaluacion) {
        this.idCalificacion = idCalificacion;
        this.idEstudiante = idEstudiante;
        this.idMateria = idMateria;
        this.nota = nota;
        this.fechaEvaluacion = fechaEvaluacion;
    }

    public Integer getIdCalificacion() {
        return idCalificacion;
    }

    public void setIdCalificacion(Integer idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    public Date getFechaEvaluacion() {
        return fechaEvaluacion;
    }

    public void setFechaEvaluacion(Date fechaEvaluacion) {
        this.fechaEvaluacion = fechaEvaluacion;
    }

    public Integer getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Integer getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Integer idMateria) {
        this.idMateria = idMateria;
    }

    public Float getNota() {
        return nota;
    }

    public void setNota(Float nota) {
        this.nota = nota;
    }
}
