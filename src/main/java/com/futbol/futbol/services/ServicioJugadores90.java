package com.futbol.futbol.services;

import com.futbol.futbol.models.Jugador;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary // Se le indica a esta clase que si la interface IServicioJugadores tienes más implementaciones, entonces que se inicia con esta
public class ServicioJugadores90 implements IServicioJugadores {
    @Override
    public ResponseEntity<List<Jugador>> listarJugadoresXEquipo(String pais) {
        // Base de datos ficitica. Solo por fines pedagógicos
        List<Jugador> jugadores = null;
        if (pais.equals("Brasil")) {  // Hay que usar equals en vez de == para comparar dos cadenas. El == sirve para comparar tipos primitivos como int, char
            jugadores = List.of(
                    new Jugador("Ronaldo"),
                    new Jugador("Cafu"),
                    new Jugador("Roberto"),
                    new Jugador("Romario")
            );
        }
        if (pais.equals("Argentina")) {
            jugadores = List.of(
                    new Jugador("Maradonna"),
                    new Jugador("Cannigia"),
                    new Jugador("Ortega"),
                    new Jugador("Ruggeri")
            );
        }
        if (pais.equals("Colombia")) {
            jugadores = List.of(
                    new Jugador("Faustino"),
                    new Jugador("Escobar"),
                    new Jugador("Álvarez"),
                    new Jugador("Valderrama")
            );
        }
        if (pais.equals("Francia")) {
            jugadores = List.of(
                    new Jugador("Zidanne"),
                    new Jugador("Petti"),
                    new Jugador("Ribéry"),
                    new Jugador("Henry")
            );
        }
        return ResponseEntity.ok(jugadores);
    }
}
