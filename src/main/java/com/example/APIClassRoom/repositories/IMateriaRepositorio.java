package com.example.APIClassRoom.repositories;

import com.example.APIClassRoom.modelos.Materia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMateriaRepositorio extends JpaRepository<Materia, Integer> {
}
