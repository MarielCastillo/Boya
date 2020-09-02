package ar.com.noaa.api.boyas.controlles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
        mResponse.id = muestra.getBoya().getBoyaId();
        mResponse.color = muestra.getBoya().getColorLuz();
        return ResponseEntity.ok(mResponse);
    }
}