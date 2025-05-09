package com.example.APIClassRoom.repositories;

import com.example.APIClassRoom.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepositorio extends JpaRepository<Usuario, Integer> {
}
