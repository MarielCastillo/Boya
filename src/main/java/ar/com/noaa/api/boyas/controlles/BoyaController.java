package ar.com.noaa.api.boyas.controlles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ar.com.noaa.api.boyas.entities.Boya;
import ar.com.noaa.api.boyas.models.response.BoyaResponse;
import ar.com.noaa.api.boyas.models.response.GenericResponse;
import ar.com.noaa.api.boyas.services.BoyaService;

@RestController
public class BoyaController {
    @Autowired
    BoyaService boyaService;

    @PostMapping("/boyas")
    public ResponseEntity<GenericResponse> crearBoya(@RequestBody Boya boya) {
        boyaService.crearBoya(boya);

        GenericResponse r = new GenericResponse();
        r.isOk = true;
        r.message = "Boya creada con exito";
        r.id = boya.getBoyaId();
        return ResponseEntity.ok(r);
    }

    @GetMapping("/boyas")
    public ResponseEntity<List<Boya>> listarCategoria() {
        return ResponseEntity.ok(boyaService.obtenerBoyas());
    }

    @GetMapping("/boyas/{id}")
    ResponseEntity<BoyaResponse> buscarPorIdBoya(@PathVariable Integer id) {
        Boya boya = boyaService.buscarPorId(id);

        BoyaResponse bGR = new BoyaResponse();
        bGR.id = boya.getBoyaId();
        bGR.colorLuz = boya.getColorLuz();
        bGR.latitudInstalacion = boya.getLatitudInstalacion();
        bGR.longitudInstalacion = boya.getLongitudInstalacion();

        return ResponseEntity.ok(bGR);
    }

}