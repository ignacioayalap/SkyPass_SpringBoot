package ayala.apiVuelos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;

@Entity
public class Tarifa {

    @Id
    private int numeroTarifa;

    private int impuestoTarifa;
    private int precioTarifa;

    @Enumerated(EnumType.STRING)
    private Clase claseTarifa;

    @ManyToOne
    @JoinColumn(name = "vuelo_numero")
    private Vuelo vuelo;

    public Tarifa() {
    }

    public Tarifa(int numeroTarifa, int impuestoTarifa, int precioTarifa, Clase claseTarifa) {
        this.numeroTarifa = numeroTarifa;
        this.impuestoTarifa = impuestoTarifa;
        this.precioTarifa = precioTarifa;
        this.claseTarifa = claseTarifa;
    }

    public int getNumeroTarifa() {
        return numeroTarifa;
    }

    public void setNumeroTarifa(int numeroTarifa) {
        this.numeroTarifa = numeroTarifa;
    }

    public int getImpuestoTarifa() {
        return impuestoTarifa;
    }

    public void setImpuestoTarifa(int impuestoTarifa) {
        this.impuestoTarifa = impuestoTarifa;
    }

    public int getPrecioTarifa() {
        return precioTarifa;
    }

    public void setPrecioTarifa(int precioTarifa) {
        this.precioTarifa = precioTarifa;
    }

    public Clase getClaseTarifa() {
        return claseTarifa;
    }

    public void setClaseTarifa(Clase claseTarifa) {
        this.claseTarifa = claseTarifa;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }
}
