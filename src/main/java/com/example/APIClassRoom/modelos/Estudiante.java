package com.example.APIClassRoom.modelos;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.List;


@Entity
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiante")
    private Integer idEstudiante;
    @Column(nullable = false)
    private Integer grado;
    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;
    @Column(nullable = false, length = 255)
    private String direccion;

    @OneToOne
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id_usuario")
    @JsonManagedReference(value = "estudiante-usuario")
    private Usuario usuario;

    @OneToMany(mappedBy = "estudiante")
    @JsonManagedReference(value = "estudiante-calificaciones")
    private List<Calificacion> calificaciones;



    public Estudiante() {
    }

    public Estudiante(Integer idEstudiante, String direccion, Integer idUsuario, Integer grado, LocalDate fechaNacimiento) {
        this.idEstudiante = idEstudiante;
        this.direccion = direccion;
        this.grado = grado;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
    }



    public Integer getGrado() {
        return grado;
    }

    public void setGrado(Integer grado) {
        this.grado = grado;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
