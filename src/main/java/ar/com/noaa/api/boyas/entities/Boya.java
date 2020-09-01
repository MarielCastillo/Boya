package ar.com.noaa.api.boyas.entities;

import java.util.*;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "boya")
public class Boya {
    @Id
    @Column(name = "boya_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer boyaId;
    @Column(name = "color_luz_id")
    private ColorLuzEnum colorLuzId;
    @Column(name = "latitud_instalacion")
    private double latitudInstalacion;
    @Column(name = "longitud_instalacion")
    private double longitudInstalacion;
    @OneToMany(mappedBy = "boya", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    private List<Muestra> muestras = new ArrayList<>();

    // public ColorLuzEnum obtenerColor(double nivelMar) {
    // colorLuz = ColorLuzEnum.AZUL;
    // if (Math.abs(nivelMar) >= 100 || Math.abs(nivelMar) <= -100) {
    // return colorLuz = ColorLuzEnum.ROJO;
    // } else if (Math.abs(nivelMar) >= 50 || Math.abs(nivelMar) <= -50) {
    // return colorLuz = ColorLuzEnum.AMARILLO;
    // }
    // return colorLuz;
    // }

    public enum ColorLuzEnum {
        ROJO(1), AMARILLO(2), VERDE(3), AZUL(4);

        private final Integer value;

        private ColorLuzEnum(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }

        public static ColorLuzEnum parse(Integer id) {
            ColorLuzEnum status = null; // Default
            for (ColorLuzEnum item : ColorLuzEnum.values()) {
                if (item.getValue().equals(id)) {
                    status = item;
                    break;
                }
            }
            return status;
        }
    }

    public Integer getBoyaId() {
        return boyaId;
    }

    public void setBoyaId(Integer boyaId) {
        this.boyaId = boyaId;
    }

    public ColorLuzEnum getColorLuzId() {
        return colorLuzId;
    }

    public void setColorLuzId(ColorLuzEnum colorLuzId) {
        this.colorLuzId = colorLuzId;
    }

    public double getLatitudInstalacion() {
        return latitudInstalacion;
    }

    public void setLatitudInstalacion(double latitudInstalacion) {
        this.latitudInstalacion = latitudInstalacion;
    }

    public double getLongitudInstalacion() {
        return longitudInstalacion;
    }

    public void setLongitudInstalacion(double longitudInstalacion) {
        this.longitudInstalacion = longitudInstalacion;
    }

    public List<Muestra> getMuestras() {
        return muestras;
    }

    public void setMuestras(List<Muestra> muestras) {
        this.muestras = muestras;
    }
}