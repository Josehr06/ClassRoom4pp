package com.example.APIClassRoom.Servicios;

import com.example.APIClassRoom.ayudas.MensajesAPI;
import com.example.APIClassRoom.modelos.Calificacion;
import com.example.APIClassRoom.repositories.ICalificacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalificacionServicio {

    @Autowired
    ICalificacionRepositorio repositorio;

    // Guardar
    public Calificacion guardarCalificacion(Calificacion datosCalificacion) throws Exception {
        try {
            return this.repositorio.save(datosCalificacion);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Modificar
    public Calificacion modificarCalificacion(Integer id, Calificacion datosCalificacion) throws Exception {
        Optional<Calificacion> calificacionBuscada = this.repositorio.findById(id);
        try {
            if (calificacionBuscada.isPresent()) {
                calificacionBuscada.get().setNota(datosCalificacion.getNota());
                return this.repositorio.save(calificacionBuscada.get());
            } else {
                throw new Exception(MensajesAPI.CALIFICACION_NO_ENCONTRADA.getTexto());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Buscar por ID
    public Calificacion buscarCalificacionPorId(Integer id) throws Exception {
        try {
            Optional<Calificacion> calificacionQueBusco = this.repositorio.findById(id);
            if (calificacionQueBusco.isPresent()) {
                return calificacionQueBusco.get();
            } else {
                throw new Exception(MensajesAPI.CALIFICACION_NO_ENCONTRADA.getTexto());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Buscar todas
    public List<Calificacion> buscarTodas() throws Exception {
        try {
            return this.repositorio.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Eliminar
    public boolean eliminarCalificacion(Integer id) throws Exception {
        try {
            Optional<Calificacion> calificacionBuscada = this.repositorio.findById(id);
            if (calificacionBuscada.isPresent()) {
                this.repositorio.deleteById(id);
                return true;
            } else {
                throw new Exception(MensajesAPI.CALIFICACION_NO_ENCONTRADA.getTexto());
            }

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }

    }

}

