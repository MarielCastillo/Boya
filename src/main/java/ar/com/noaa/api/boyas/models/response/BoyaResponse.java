package ar.com.noaa.api.boyas.models.response;

import ar.com.noaa.api.boyas.entities.Boya.ColorLuzEnum;

public class BoyaResponse {
    public Integer id;
    public ColorLuzEnum colorLuz;
    public double latitudInstalacion;
    public double longitudInstalacion;
}