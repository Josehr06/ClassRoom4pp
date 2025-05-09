package com.example.APIClassRoom.Servicios;

import com.example.APIClassRoom.ayudas.MensajesAPI;
import com.example.APIClassRoom.modelos.Docente;
import com.example.APIClassRoom.repositories.IDocenteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class    DocenteServicio {
    @Autowired //Inyeccion de dependencias
    IDocenteRepositorio repositorio;

    //En el servicio implementamos los metodos
    //que necesitamos segun los servicios a ofrecer

    //GUARDAR
    public Docente guardarDocente(Docente datosDocente)throws Exception{
        try{
            return this.repositorio.save(datosDocente);
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }


    //MODIFICAR
    public Docente modifcarDocente(Integer id,Docente datosDocente)throws Exception{
        try {
            //Para modificar primero debo buscar
            //JPA ME DEVUELVE UN DATO OPCIONAL (PUEDE ESTAR O NO)
            Optional<Docente>docenteBuscado=this.repositorio.findById(id);


            //Apenas lo busques pregunta si si estaba
            if(docenteBuscado.isPresent()){
                //Modifiquelo ps papa

                docenteBuscado.get().setEspecialidad(datosDocente.getEspecialidad());//Modificando un dato viejo
                return this.repositorio.save(docenteBuscado.get());

            }else{
                //No estaba el muñeco
                throw new Exception(MensajesAPI.DOCENTE_NO_ENCONTRADO.getTexto());
            }

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //BUSCAR POR ID
    public Docente buscarDocentePorId(Integer id) throws  Exception {
        try {
            Optional<Docente> docenteQueBusco = this.repositorio.findById(id);
            if (docenteQueBusco.isPresent()) {
                //Retorno el docente que busco
                return docenteQueBusco.get();
            } else {
                throw new Exception(MensajesAPI.DOCENTE_NO_ENCONTRADO.getTexto());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }


    }

    //BUSCAR TODOS
    public List<Docente> buscarTodosLosDocentes()throws Exception{
        try {
            return this.repositorio.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    //ELIMINAR
    public boolean eliminarDocente (Integer id) throws Exception{
        try{
            Optional<Docente> docenteBuscado=this.repositorio.findById(id);
            if(docenteBuscado.isPresent()){
                this.repositorio.deleteById(id);
                return true;
            }else {
                throw new Exception(MensajesAPI.DOCENTE_NO_ENCONTRADO.getTexto());
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
