package com.example.APIClassRoom.Servicios;

import com.example.APIClassRoom.ayudas.MensajesAPI;
import com.example.APIClassRoom.modelos.Inscripcion;
import com.example.APIClassRoom.repositories.IInscripcionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InscripcionServicio {

    @Autowired
    IInscripcionRepositorio repositorio;

    // Guardar
    public Inscripcion guardarInscripcion(Inscripcion datosInscripcion) throws Exception {
        try {
            return this.repositorio.save(datosInscripcion);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Modificar
    public Inscripcion modificarInscripcion(Integer id, Inscripcion datosInscripcion) throws Exception {
        Optional<Inscripcion> inscripcionBuscada = this.repositorio.findById(id);
        try {
            if (inscripcionBuscada.isPresent()) {
                inscripcionBuscada.get().setIdInscripcion(datosInscripcion.getIdInscripcion());
                inscripcionBuscada.get().setFechaInscripcion(datosInscripcion.getFechaInscripcion());
                inscripcionBuscada.get().setIdCurso(datosInscripcion.getIdCurso());
                return this.repositorio.save(inscripcionBuscada.get());
            } else {
                throw new Exception(MensajesAPI.INSCRIPCION_NO_ENCONTRADA.getTexto());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Buscar por ID
    public Inscripcion buscarInscripcionPorId(Integer id) throws Exception {
        try {
            Optional<Inscripcion> inscripcionBuscada = this.repositorio.findById(id);
            if (inscripcionBuscada.isPresent()) {
                return inscripcionBuscada.get();
            } else {
                throw new Exception(MensajesAPI.INSCRIPCION_NO_ENCONTRADA.getTexto());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Buscar todas
    public List<Inscripcion> buscarTodas() throws Exception {
        try {
            return this.repositorio.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Eliminar
    public boolean eliminarInscripcion(Integer id) throws Exception {
        try {
            Optional<Inscripcion> inscripcionBuscada = this.repositorio.findById(id);
            if (inscripcionBuscada.isPresent()) {
                this.repositorio.deleteById(id);
                return true;
            } else {
                throw new Exception(MensajesAPI.INSCRIPCION_NO_ENCONTRADA.getTexto());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}

