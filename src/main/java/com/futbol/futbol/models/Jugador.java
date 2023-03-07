package com.futbol.futbol.models;

import lombok.Data;
import lombok.NonNull;

@Data
public class Jugador {
    @NonNull
    private String nombre;
    private short numero;
    private int goles;
}
