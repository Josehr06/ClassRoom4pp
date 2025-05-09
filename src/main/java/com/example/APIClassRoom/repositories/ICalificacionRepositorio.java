package com.example.APIClassRoom.repositories;

import com.example.APIClassRoom.modelos.Calificacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICalificacionRepositorio extends JpaRepository<Calificacion, Integer> {
}
