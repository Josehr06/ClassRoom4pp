package com.example.APIClassRoom.modelos;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Docente
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_docente")
    private Integer idDocente;

    private Integer idUsuario;
    @Column (length = 100, nullable = false)
    private String especialidad;

    @OneToMany(mappedBy = "docente")
    @JsonManagedReference
    private List<Curso> cursos;



    public Docente() {
    }

    public Docente(Integer idDocente, Integer idUsuario, String especialidad) {
        this.idDocente = idDocente;
        this.idUsuario = idUsuario;
        this.especialidad = especialidad;
    }

    public Integer getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(Integer idDocente) {
        this.idDocente = idDocente;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
