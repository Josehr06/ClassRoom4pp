package com.example.APIClassRoom.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @Column (length = 100, nullable = false)
    private String especialidad;

    @OneToMany(mappedBy = "docente")
    @JsonManagedReference(value = "docente-cursos")
    private List<Curso> cursos;

    @OneToOne
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id_usuario")
    @JsonManagedReference(value = "docente_usuario")
    private Usuario usuario;



    public Docente() {
    }

    public Docente(Integer idDocente, Integer idUsuario, String especialidad) {
        this.idDocente = idDocente;
        this.especialidad = especialidad;
    }

    public Integer getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(Integer idDocente) {
        this.idDocente = idDocente;
    }


    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
