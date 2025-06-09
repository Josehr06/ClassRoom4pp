package com.example.APIClassRoom.controladores;

import com.example.APIClassRoom.modelos.Materia;
import com.example.APIClassRoom.Servicios.MateriServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/materias")
public class MateriaControlador {

    @Autowired
    MateriServicio servicio;

    // Controlador para guardar
    @PostMapping()
    public ResponseEntity<?> guardar(@RequestBody Materia datosEnviadosPorElCliente) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.servicio.guardarMateria(datosEnviadosPorElCliente));
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }

    // Controlador para modificar
    @PutMapping("/{id}")
    public ResponseEntity<?> modificar(@PathVariable Integer id, @RequestBody Materia datos) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.modificarMateria(id, datos));
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }

    // Controlador para buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.buscarMateriaPorId(id));
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }

    // Controlador para buscarlas todas
    @GetMapping
    public ResponseEntity<?> buscarTodas() {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.buscarTodas());
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }

    // Controlador para eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.eliminarMateria(id));
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }
}
