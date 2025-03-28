package com.example.APIClassRoom.Servicios;

import com.example.APIClassRoom.modelos.Docente;
import com.example.APIClassRoom.repositories.IDocenteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocenteServicio {
    @Autowired //inventor de dependencias
    IDocenteRepositorio repositorio;

    // En el servicio implementamos los metodos que necesitemos
    //que necesitemos segun los servicios a ofrecer

    //GUARDAR
    /*public Docente guardarDocente(Docente datosDocente) throws Exception {
        try{
            return  this.repositorio.save(datosDocente);
        }catch (Exception error) {
            throw  new Exception(error.getMessage());
        }
        */
    //BUSCAR POR ID

    //ELIMINAR

}
