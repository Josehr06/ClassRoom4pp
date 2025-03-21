package com.example.APIClassRoom.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Curso
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private Integer idCurso;
    @Column(nullable = false, length = 100)
    private String nombre;

    private Integer idDocente;

    @ManyToOne
    @JoinColumn(name = "fk_docente", referencedColumnName = "id_docente")
    @JsonBackReference
    private Docente docente;
    @OneToMany(mappedBy = "curso")
    @JsonManagedReference
    private List<Inscripcion> inscripcion;
    @OneToMany(mappedBy = "asistencia")
    @JsonManagedReference
    private List<Asistencia> asistencia;


    public Curso() {
    }

    public Curso(Integer idCurso, String nombre, Integer idDocente) {
        this.idCurso = idCurso;
        this.nombre = nombre;
        this.idDocente = idDocente;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public Integer getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(Integer idDocente) {
        this.idDocente = idDocente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
