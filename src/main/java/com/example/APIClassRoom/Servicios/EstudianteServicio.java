package com.example.APIClassRoom.Servicios;

import com.example.APIClassRoom.ayudas.MensajesAPI;
import com.example.APIClassRoom.modelos.Estudiante;
import com.example.APIClassRoom.repositories.IEstudianteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteServicio {

    @Autowired
    IEstudianteRepositorio repositorio;

    // Guardar
    public Estudiante guardarEstudiante(Estudiante datosEstudiante) throws Exception {
        try {
            return this.repositorio.save(datosEstudiante);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Modificar
    public Estudiante modificarEstudiante(Integer id, Estudiante datosEstudiante) throws Exception {
        Optional<Estudiante> estudianteBuscado = this.repositorio.findById(id);
        try {
            if (estudianteBuscado.isPresent()) {
                estudianteBuscado.get().setIdEstudiante(datosEstudiante.getIdEstudiante());
                estudianteBuscado.get().setDireccion(datosEstudiante.getDireccion());
                estudianteBuscado.get().setGrado(datosEstudiante.getGrado());
                estudianteBuscado.get().setFechaNacimiento(datosEstudiante.getFechaNacimiento());
                return this.repositorio.save(estudianteBuscado.get());
            } else {
                throw new Exception(MensajesAPI.ESTUDIANTE_NO_ENCONTRADO.getTexto());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Buscar por ID
    public Estudiante buscarEstudiantePorId(Integer id) throws Exception {
        try {
            Optional<Estudiante> estudianteBuscado = this.repositorio.findById(id);
            if (estudianteBuscado.isPresent()) {
                return estudianteBuscado.get();
            } else {
                throw new Exception(MensajesAPI.ESTUDIANTE_NO_ENCONTRADO.getTexto());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Buscar todos
    public List<Estudiante> buscarTodos() throws Exception {
        try {
            return this.repositorio.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Eliminar
    public boolean eliminarEstudiante(Integer id) throws Exception {
        try {
            Optional<Estudiante> estudianteBuscado = this.repositorio.findById(id);
            if (estudianteBuscado.isPresent()) {
                this.repositorio.deleteById(id);
                return true;
            } else {
                throw new Exception(MensajesAPI.ESTUDIANTE_NO_ENCONTRADO.getTexto());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
