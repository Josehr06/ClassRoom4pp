package com.example.APIClassRoom.Servicios;

import com.example.APIClassRoom.ayudas.MensajesAPI;
import com.example.APIClassRoom.modelos.Asistencia;
import com.example.APIClassRoom.repositories.IAsistenciaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsistenciaServicio {

    @Autowired
    IAsistenciaRepositorio repositorio;

    // Guardar
    public Asistencia guardarAsistencia(Asistencia datosAsistencia) throws Exception {
        try {
            return this.repositorio.save(datosAsistencia);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Modificar
    public Asistencia modificarAsistencia(Integer id, Asistencia datosAsistencia) throws Exception {
        Optional<Asistencia> asistenciaBuscada = this.repositorio.findById(id);
        try {
            if (asistenciaBuscada.isPresent()) {
                asistenciaBuscada.get().setFecha(datosAsistencia.getFecha());
                asistenciaBuscada.get().setEstado(datosAsistencia.getEstado());
                asistenciaBuscada.get().setIdAsistencia(datosAsistencia.getIdAsistencia());
                return this.repositorio.save(asistenciaBuscada.get());
            } else {
                throw new Exception(MensajesAPI.ASISTENCIA_NO_ENCONTRADA.getTexto());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Buscar por ID
    public Asistencia buscarAsistenciaPorId(Integer id) throws Exception {
        try {
            Optional<Asistencia> asistenciaQueBusco = this.repositorio.findById(id);
            if (asistenciaQueBusco.isPresent()) {
                return asistenciaQueBusco.get();
            } else {
                throw new Exception(MensajesAPI.ASISTENCIA_NO_ENCONTRADA.getTexto());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Buscar todas
    public List<Asistencia> buscarTodas() throws Exception {
        try {
            return this.repositorio.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Eliminar
    public boolean eliminarAsistencia(Integer id) throws Exception {
        try {
            Optional<Asistencia> asistenciaBuscada = this.repositorio.findById(id);
            if (asistenciaBuscada.isPresent()) {
                this.repositorio.deleteById(id);
                return true;
            } else {
                throw new Exception(MensajesAPI.ASISTENCIA_NO_ENCONTRADA.getTexto());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}

