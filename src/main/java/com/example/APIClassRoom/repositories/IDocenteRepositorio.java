package com.example.APIClassRoom.repositories;

import com.example.APIClassRoom.modelos.Docente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDocenteRepositorio extends JpaRepository<Docente, Integer> {
}
