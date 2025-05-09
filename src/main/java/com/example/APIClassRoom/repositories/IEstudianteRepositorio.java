package com.example.APIClassRoom.repositories;

import com.example.APIClassRoom.modelos.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEstudianteRepositorio extends JpaRepository<Estudiante, Integer> {
}
