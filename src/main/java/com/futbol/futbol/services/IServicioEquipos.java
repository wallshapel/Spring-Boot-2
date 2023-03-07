package com.futbol.futbol.services;

import com.futbol.futbol.models.Equipo;
import com.futbol.futbol.models.Jugador;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

public interface IServicioEquipos {
    public ResponseEntity<List<Equipo>> listarEquipos();
    public ResponseEntity<Equipo> listarEquipoXPais(String pais);
    public ResponseEntity eliminarXPais(String pais);

    public ResponseEntity crearEquipo(Equipo equipo);

    public ResponseEntity actualizarEquipo(Equipo equipoModificado);
}
