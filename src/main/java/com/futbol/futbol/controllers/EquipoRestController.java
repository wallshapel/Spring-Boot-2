package com.futbol.futbol.controllers;

import com.futbol.futbol.models.Equipo;
import com.futbol.futbol.models.Jugador;
import com.futbol.futbol.services.ServicioEquipos;
import com.futbol.futbol.services.ServicioJugadores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipos")  // Esto funciona como prefijo para cada uno de los end points contenidos en esta clase
public class EquipoRestController {
    @Autowired  // Evita tener que crear un método constructor para instanciar este servicio.
    private ServicioEquipos servicioEquipos;
    @Autowired  // Evita tener que crear un método constructor para instanciar este servicio.
    private ServicioJugadores servicioJugadores; // Lo mismo acá;
    @GetMapping // LISTAR TODOS
    public ResponseEntity<List<Equipo>> equipos() {
        return this.servicioEquipos.listarEquipos();
    }
    @GetMapping("/{pais}")  // LISTAR POR PAÍS
    public ResponseEntity<Equipo> equiposXPais(@PathVariable String pais) {  // ResponseEntity nos permite trabajar con códigos de estado HTTP.
        return this.servicioEquipos.listarEquipoXPais(pais);
    }
    @DeleteMapping("/{pais}") // ELIMINAR POR PAÍS
    public ResponseEntity eliminar(@PathVariable String pais) {
        return this.servicioEquipos.eliminarXPais(pais);
    }
    @PostMapping  // CREAR EQUIPO
    public ResponseEntity crear(@RequestBody Equipo equipo) {  // En este end point se capturan los datos vía JSON por el body.
        return this.servicioEquipos.crearEquipo(equipo);
    }
    @PutMapping  // ACTUALIZAR EQUIPO
    public ResponseEntity actualizar(@RequestBody Equipo equipoModificado) {  // En este end point se capturan los datos vía JSON por el body.
        return this.servicioEquipos.actualizarEquipo(equipoModificado);
    }
    @GetMapping("/{pais}/jugadores")  // Importante tener cuidado con el orden de las rutas y parámetros
    public ResponseEntity<List<Jugador>> jugadores(@PathVariable String pais) {
        return this.servicioJugadores.listarJugadoresXEquipo(pais);
    }
}
