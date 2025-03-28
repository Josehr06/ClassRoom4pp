package com.example.APIClassRoom.repositories;

import com.example.APIClassRoom.modelos.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICursoRepositorio extends JpaRepository<Docente, Integer> {

}
