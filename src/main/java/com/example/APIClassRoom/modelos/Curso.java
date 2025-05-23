package com.example.APIClassRoom.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private Integer idCurso;

    @Column(nullable = false, length = 100)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "fk_docente", referencedColumnName = "id_docente")
    @JsonBackReference
    private Docente docente;

    @OneToMany(mappedBy = "curso")

    @JsonManagedReference
    private List<Inscripcion> inscripcion;

    @OneToMany(mappedBy = "curso")
    @JsonManagedReference(value = "relacion1")
    private List<Asistencia> asistencia;

    public Curso() {
    }

    public Curso(Integer idCurso, String nombre, Docente docente) {
        this.idCurso = idCurso;
        this.nombre = nombre;
        this.docente = docente;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
