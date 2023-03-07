package com.futbol.futbol.services;

import com.futbol.futbol.models.Jugador;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IServicioJugadores {
    public ResponseEntity<List<Jugador>> listarJugadoresXEquipo(String pais);
}
