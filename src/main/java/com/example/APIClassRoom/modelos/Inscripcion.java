package com.example.APIClassRoom.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
public class Inscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inscripcion")
    private Integer idInscripcion;

    private Integer idEstudiante;
    private Integer idCurso;
    @Column(name = "fecha_inscripcion")
    private LocalDate fechaInscripcion;

    @ManyToOne
    @JoinColumn(name = "fk_curso", referencedColumnName = "id_curso")
    @JsonBackReference
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "fk_estudiante", referencedColumnName = "id_estudiante")
    @JsonBackReference
    private Estudiante estudiante;

    public Inscripcion() {
    }

    public Inscripcion(Integer idInscripcion, Integer idEstudiante, Integer idCurso, LocalDate fechaInscripcion, Inscripcion inscripcion) {
        this.idInscripcion = idInscripcion;
        this.idEstudiante = idEstudiante;
        this.idCurso = idCurso;
        this.fechaInscripcion = fechaInscripcion;
    }

    public Integer getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(Integer idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public Integer getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }


}
