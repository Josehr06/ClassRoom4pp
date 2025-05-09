package com.example.APIClassRoom.Servicios;

import com.example.APIClassRoom.ayudas.MensajesAPI;
import com.example.APIClassRoom.modelos.Curso;
import com.example.APIClassRoom.repositories.ICursoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CursoServicio {
    @Autowired
    ICursoRepositorio repositorio;

    //Guardar
    public Curso guardarCurso (Curso datosCursos) throws Exception{
        try{
            return this.repositorio.save(datosCursos);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }

    }
    //Modificar
    public Curso modificarCurso (Integer id, Curso datosCursos) throws Exception{
        Optional<Curso> cursoBuscado=this.repositorio.findById(id);
        try {
            if (cursoBuscado.isPresent()) {
                cursoBuscado.get().setNombre(datosCursos.getNombre());
                return this.repositorio.save(cursoBuscado.get());
            } else {
                throw new Exception(MensajesAPI.CURSO_NO_ENCONTRADO.getTexto());
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    //Buscar por id
    public Curso buscarCursoPorId(Integer id) throws Exception{
        try{
            Optional<Curso> cursoQueBusco = this.repositorio.findById(id);
            if (cursoQueBusco.isPresent()){
                return cursoQueBusco.get();
            }else {
                throw new Exception(MensajesAPI.CURSO_NO_ENCONTRADO.getTexto());
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Buscar todos
    public List<Curso> buscarTodos()throws Exception{
        try {
            return this.repositorio.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    //Eliminar
    public boolean eliminarCurso (Integer id) throws Exception{
        try {
            Optional<Curso> cursoBuscado=this.repositorio.findById(id);
            if (cursoBuscado.isPresent()){
                this.repositorio.deleteById(id);
                return true;
            }else {
                throw new Exception(MensajesAPI.CURSO_NO_ENCONTRADO.getTexto());
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

}
