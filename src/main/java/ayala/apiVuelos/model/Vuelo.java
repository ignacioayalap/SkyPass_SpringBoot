package ayala.apiVuelos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Vuelo {

    @Id
    private int numeroVuelo;

    private LocalDateTime salida;
    private LocalDateTime destino;

    @ManyToOne
    @JoinColumn(name = "aerolinea_id")
    private Aerolinea aerolinea;

    @ManyToOne
    @JoinColumn(name = "avion_numero")
    private Avion avion;

    @ManyToOne
    @JoinColumn(name = "piloto_dni")
    private Piloto piloto;

    @ManyToMany
    @JoinTable(
        name = "vuelo_aeropuerto",
        joinColumns = @JoinColumn(name = "vuelo_numero"),
        inverseJoinColumns = @JoinColumn(name = "aeropuerto_id")
    )
    private List<Aeropuerto> aeropuertos;

    @OneToMany(mappedBy = "vuelo")
    private List<Tarifa> tarifas;

    @OneToMany(mappedBy = "vuelo")
    private List<Reserva> reservas;

    public Vuelo() {
    }

    public Vuelo(int numeroVuelo, LocalDateTime salida, LocalDateTime destino) {
        this.numeroVuelo = numeroVuelo;
        this.salida = salida;
        this.destino = destino;
    }

    public int getNumeroVuelo() {
        return numeroVuelo;
    }

    public void setNumeroVuelo(int numeroVuelo) {
        this.numeroVuelo = numeroVuelo;
    }

    public LocalDateTime getSalida() {
        return salida;
    }

    public void setSalida(LocalDateTime salida) {
        this.salida = salida;
    }

    public LocalDateTime getDestino() {
        return destino;
    }

    public void setDestino(LocalDateTime destino) {
        this.destino = destino;
    }

    public Aerolinea getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(Aerolinea aerolinea) {
        this.aerolinea = aerolinea;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public List<Aeropuerto> getAeropuertos() {
        return aeropuertos;
    }

    public void setAeropuertos(List<Aeropuerto> aeropuertos) {
        this.aeropuertos = aeropuertos;
    }

    public void addAeropuerto(Aeropuerto aeropuerto) {
        this.aeropuertos.add(aeropuerto);
        aeropuerto.getVuelos().add(this);
    }

    public boolean removeAeropuerto(Aeropuerto aeropuerto) {
        aeropuerto.getVuelos().remove(this);
        return this.aeropuertos.remove(aeropuerto);
    }

    public List<Tarifa> getTarifas() {
        return tarifas;
    }

    public void setTarifas(List<Tarifa> tarifas) {
        this.tarifas = tarifas;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}
