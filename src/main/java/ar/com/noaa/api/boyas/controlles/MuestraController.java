package ar.com.noaa.api.boyas.controlles;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.noaa.api.boyas.entities.Muestra;
import ar.com.noaa.api.boyas.models.request.MuestraRequest;
import ar.com.noaa.api.boyas.models.response.MuestraResponse;
import ar.com.noaa.api.boyas.services.MuestraService;

@RestController
public class MuestraController {
    @Autowired
    MuestraService muestraService;

    @PostMapping("/muestras")
    public ResponseEntity<MuestraResponse> crearBoya(@RequestBody MuestraRequest mR) {
        Muestra muestra = muestraService.regristroMuestra(mR.boyaId, mR.horario, mR.matricula, mR.latitud, mR.longitud,
                mR.nivelMar);

        MuestraResponse mResponse = new MuestraResponse();
        mResponse.id = muestra.getMuestraId();
        mResponse.color = muestra.getBoya().getColorLuz();
        return ResponseEntity.ok(mResponse);
    }

    @GetMapping("muestras/boyas/{idBoya}")
    public ResponseEntity<List<Muestra>> listarMuestrasBoya(@PathVariable Integer idBoya) {
        List<Muestra> muestras = new ArrayList<>();

        for (Muestra m : muestraService.obtenerMuestras()) {
            if (m.getBoya().getBoyaId().equals(idBoya)) {
                muestras.add(m);
            }
        }

        return ResponseEntity.ok(muestras);
    }
}