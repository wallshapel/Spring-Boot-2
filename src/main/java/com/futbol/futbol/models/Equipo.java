package com.futbol.futbol.models;

import lombok.Data;
import lombok.NonNull;

@Data
public class Equipo {
    @NonNull
    private String pais;
    @NonNull
    private String conf;
    private int Ranking;
}
