package com.futbol.futbol.services;

import com.futbol.futbol.models.Equipo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Service  // Evita tener que crear un método constructor en las clases que quieran instanciar a esta clase
public class ServicioEquipos implements IServicioEquipos {
    // Base de datos ficitica. Solo por fines pedagógicos
    private ArrayList<Equipo> equipos = new ArrayList<>(
            List.of(new Equipo("Argentina", "Conmebol"),
                    new Equipo("Alemania", "UEFA"),
                    new Equipo("España", "UEFA"),
                    new Equipo("Colombia", "Conmebol"))
    );

    public ResponseEntity<List<Equipo>> listarEquipos() {
        return ResponseEntity.ok(this.equipos);
    }
    public ResponseEntity<Equipo> listarEquipoXPais(String pais) {
        for (Equipo equipo: this.equipos) {
            if (equipo.getPais().equals(pais))
                return ResponseEntity.ok(equipo);
        }
        return ResponseEntity.notFound().build();
    }
    public ResponseEntity crearEquipo(Equipo equipo) {
        this.equipos.add(equipo);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{pais}")
                .buildAndExpand(equipo.getPais())
                .toUri();
        return ResponseEntity.created(location).build(); // 200 y devuelve por el HEADER en el parámetro 'location', la url donde se puede consultar el recurso creado.
    }
    public ResponseEntity actualizarEquipo(Equipo equipoModificado) {  // En este end point se capturan los datos vía JSON por el body.
        for (Equipo equipo: this.equipos) {
            if (equipo.getPais().equals(equipoModificado.getPais())) {  // Como equipoViejo es del tipo Equipo, podemos emplear la función getPais en él.
                equipo.setConf(equipoModificado.getConf());
                equipo.setRanking(equipoModificado.getRanking());
                return ResponseEntity.ok(equipoModificado); // 200
            }
        }
        return ResponseEntity.notFound().build(); // 404
    }
    public ResponseEntity eliminarXPais(String pais) {
        for (Equipo equipo: this.equipos) {
            if (equipo.getPais().equals(pais)) {
                this.equipos.remove(equipo);
                return ResponseEntity.noContent().build(); // 204
            }
        }
        return ResponseEntity.notFound().build(); // 404
    }
}