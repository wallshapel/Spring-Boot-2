package com.futbol.futbol.services;

import com.futbol.futbol.models.Jugador;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service  // Evita tener que crear un método constructor en las clases que quieran instanciar a esta clase
public class ServicioJugadores implements IServicioJugadores {  // IServicioJugadores es una interface cuyos métodos públicos deben ser consumidos obligatoriamente aquí.
    public ResponseEntity<List<Jugador>> listarJugadoresXEquipo(String pais) {
        // Base de datos ficitica. Solo por fines pedagógicos
        List<Jugador> jugadores = null;
        if (pais.equals("España")) {
            jugadores = List.of(
                    new Jugador("Morata"),
                    new Jugador("Ramos"),
                    new Jugador("Xavi"),
                    new Jugador("Iniesta")
            );
        }
        if (pais.equals("Argentina")) {
            jugadores = List.of(
                    new Jugador("Dibu"),
                    new Jugador("Di María"),
                    new Jugador("Messi"),
                    new Jugador("Paulo Dybala")
            );
        }
        if (pais.equals("Colombia")) {
            jugadores = List.of(
                    new Jugador("Falcao"),
                    new Jugador("Cuadrado"),
                    new Jugador("James"),
                    new Jugador("Ospina")
            );
        }
        if (pais.equals("Alemania")) {
            jugadores = List.of(
                    new Jugador("Müller"),
                    new Jugador("Neuer"),
                    new Jugador("Gnabry"),
                    new Jugador("Füllkrug")
            );
        }
        return ResponseEntity.ok(jugadores);
    }
}