package com.example.APIClassRoom.modelos;

import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;


@Entity
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiante")
    private Integer idEstudiante;

    private Integer idUsuario;
    @Column(nullable = false)
    private Integer grado;
    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;
    @Column(nullable = false, length = 255)
    private String direccion;

    public Estudiante() {
    }

    public Estudiante(Integer idEstudiante, String direccion, Integer idUsuario, Integer grado, LocalDate fechaNacimiento) {
        this.idEstudiante = idEstudiante;
        this.direccion = direccion;
        this.idUsuario = idUsuario;
        this.grado = grado;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
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
