package ar.com.noaa.api.boyas.controlles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.noaa.api.boyas.entities.Boya;
import ar.com.noaa.api.boyas.models.response.GenericResponse;
import ar.com.noaa.api.boyas.services.BoyaService;

@RestController
public class BoyaController {
    @Autowired
    BoyaService boyaService;

    public ResponseEntity<GenericResponse> crearBoya(@RequestBody Boya boya){
        boyaService.crearBoya(boya);

        GenericResponse r = new GenericResponse();
        r.isOk = true;
        r.message = "Boya creada con exito";
        r.id = boya.getBoyaId();
        return ResponseEntity.ok(r);
    }
}