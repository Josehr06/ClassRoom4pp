package com.example.APIClassRoom.ayudas;

public enum MensajesAPI {
    DOCENTE_NO_ENCONTRADO("El docente que buscas no se encuentra en la BD"),
    CURSO_NO_ENCONTRADO("El curso que buscas no se encuentra en la BD"),
    MATERIA_NO_ENCONTRADA("La materia que buscas no se encuentra en la BD"),
    ASISTENCIA_NO_ENCONTRADA("La asistencia que buscas no se encuentra en la BD"),
    ESTUDIANTE_NO_ENCONTRADO("El estudiante que buscas no se encuentra en la BD"),
    INSCRIPCION_NO_ENCONTRADA("La inscripción que buscas no se encuentra en la BD"),
    USUARIO_NO_ENCONTRADO("El usuario que buscas no se encuentra en la BD"),
    CALIFICACION_NO_ENCONTRADA("la calificacion que buscas no se encuentra en la BD");


    private String texto;

    MensajesAPI(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }


}
