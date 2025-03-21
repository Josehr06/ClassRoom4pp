package com.example.APIClassRoom.modelos;

import com.example.APIClassRoom.ayudas.Estado;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Asistencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asistencia")
    private Integer idAsistencia;
    private Integer idEstudiante;
    private Integer idCurso;
    @Column(nullable = false)
    private Date fecha;
    @Column(nullable = false)
    private Estado estado;
    @ManyToOne
    @JoinColumn(name = "fk_curso", referencedColumnName = "id_curso")
    @JsonBackReference
    private Curso curso;

    public Asistencia() {
    }

    public Asistencia(Integer idAsistencia, Integer idEstudiante, Date fecha, Integer idCurso, Estado estado) {
        this.idAsistencia = idAsistencia;
        this.idEstudiante = idEstudiante;
        this.fecha = fecha;
        this.idCurso = idCurso;
        this.estado = estado;
    }

    public Integer getIdAsistencia() {
        return idAsistencia;
    }

    public void setIdAsistencia(Integer idAsistencia) {
        this.idAsistencia = idAsistencia;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
