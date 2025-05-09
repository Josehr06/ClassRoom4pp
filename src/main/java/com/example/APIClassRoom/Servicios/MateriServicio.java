package com.example.APIClassRoom.Servicios;

import com.example.APIClassRoom.ayudas.MensajesAPI;
import com.example.APIClassRoom.modelos.Materia;
import com.example.APIClassRoom.repositories.IMateriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MateriServicio {

    @Autowired
    IMateriaRepositorio repositorio;

    // Guardar
    public Materia guardarMateria(Materia datosMateria) throws Exception {
        try {
            return this.repositorio.save(datosMateria);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Modificar
    public Materia modificarMateria(Integer id, Materia datosMateria) throws Exception {
        Optional<Materia> materiaBuscada = this.repositorio.findById(id);
        try {
            if (materiaBuscada.isPresent()) {
                materiaBuscada.get().setNombre(datosMateria.getNombre());
                materiaBuscada.get().setIdMateria(datosMateria.getIdMateria());
                materiaBuscada.get().setIdCurso(datosMateria.getIdCurso());
                return this.repositorio.save(materiaBuscada.get());
            } else {
                throw new Exception(MensajesAPI.MATERIA_NO_ENCONTRADA.getTexto());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Buscar por ID
    public Materia buscarMateriaPorId(Integer id) throws Exception {
        try {
            Optional<Materia> materiaBuscada = this.repositorio.findById(id);
            if (materiaBuscada.isPresent()) {
                return materiaBuscada.get();
            } else {
                throw new Exception(MensajesAPI.MATERIA_NO_ENCONTRADA.getTexto());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Buscar todas
    public List<Materia> buscarTodas() throws Exception {
        try {
            return this.repositorio.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Eliminar
    public boolean eliminarMateria(Integer id) throws Exception {
        try {
            Optional<Materia> materiaBuscada = this.repositorio.findById(id);
            if (materiaBuscada.isPresent()) {
                this.repositorio.deleteById(id);
                return true;
            } else {
                throw new Exception(MensajesAPI.MATERIA_NO_ENCONTRADA.getTexto());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}

