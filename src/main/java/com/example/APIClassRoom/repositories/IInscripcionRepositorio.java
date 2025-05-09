package com.example.APIClassRoom.repositories;

import com.example.APIClassRoom.modelos.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInscripcionRepositorio extends JpaRepository<Inscripcion, Integer> {
}
