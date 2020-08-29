package ar.com.noaa.api.boyas.entities;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="muestra")
public class Muestra {
    @Id
    @Column(name="muestra_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer muestraId;
    @ManyToOne
    @JoinColumn(name = "boya_id", referencedColumnName = "boya_id")
    private Boya boya;
    @Column(name="horario_muestra")
    private Date horarioMuestra;
    @Column(name="matricula_embarcacion")
    private String matriculaEmbarcacion;
    private double longitud;
    private double latitud;
    @Column(name="nivel_mar")
    private double nivelMar;
    // Altura al nivel del mar: double, número que especifica a qué nivel del mar está la boya en
    // METROS. Ej 0 = significa que está a 0 metros del nivel del mar. -10 metros significa que esta
    // “hundida” -10 metros y un valor de 20ms es que esta 20 metros arriba del nivel del mar.

    // public void infoColor(double metros){
    //     if(this.nivelMar > metros &&  this.nivelMar < metros){

    //     }
    // }

    public Integer getMuestraId() {
        return muestraId;
    }

    public void setMuestraId(Integer muestraId) {
        this.muestraId = muestraId;
    }

    public Boya getBoya() {
        return boya;
    }

    public void setBoya(Boya boya) {
        this.boya = boya;
    }

    public Date getHorarioMuestra() {
        return horarioMuestra;
    }

    public void setHorarioMuestra(Date horarioMuestra) {
        this.horarioMuestra = horarioMuestra;
    }

    public String getMatriculaEmbarcacion() {
        return matriculaEmbarcacion;
    }

    public void setMatriculaEmbarcacion(String matriculaEmbarcacion) {
        this.matriculaEmbarcacion = matriculaEmbarcacion;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getNivelMar() {
        return nivelMar;
    }

    public void setNivelMar(double nivelMar) {
        this.nivelMar = nivelMar;
    }
}