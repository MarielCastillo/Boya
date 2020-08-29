package ar.com.noaa.api.boyas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.noaa.api.boyas.entities.Boya;
import ar.com.noaa.api.boyas.repos.BoyaRepository;

@Service
public class BoyaService {
    @Autowired
    BoyaRepository repoBoya;

    public void crearBoya(Boya boya){
        repoBoya.save(boya);
    }

    public Boya crearBoya(double longitudInstalacion, double latitudInstalacion){
        Boya boya = new Boya();
        boya.setLongitudInstalacion(longitudInstalacion);
        boya.setLatitudInstalacion(latitudInstalacion);
        repoBoya.save(boya);
        return boya;
    }
}