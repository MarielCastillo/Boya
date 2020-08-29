package ar.com.noaa.api.boyas.entities;

import java.util.*;
import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "boya")
public class Boya {
    @Id
    @Column(name = "boya_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer boyaId;
    @Column(name = "color_luz")
    private ColorLuzEnum colorLuz;
    @Column(name = "latitud_instalacion")
    private double latitudInstalacion;
    @Column(name = "longitud_instalacion")
    private double longitudInstalacion;
    @OneToMany(mappedBy = "boya", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Muestra> muestras = new ArrayList<>();

    public enum ColorLuzEnum {
        ROJO(1), AMARILLO(2), VERDE(3), AZUL(4);

        private final Integer value;

        // NOTE: Enum constructor tiene que estar en privado
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

    public ColorLuzEnum getColorLuz() {
        return colorLuz;
    }

    public void setColorLuz(ColorLuzEnum colorLuz) {
        this.colorLuz = colorLuz;
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