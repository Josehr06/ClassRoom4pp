package com.example.APIClassRoom.repositories;

import com.example.APIClassRoom.modelos.Asistencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAsistenciaRepositorio extends JpaRepository<Asistencia, Integer> {
}
