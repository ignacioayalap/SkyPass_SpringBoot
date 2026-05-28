package ayala.apiVuelos.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vuelo extends Base {
    private int numeroVuelo;
    private LocalDateTime salida;
    private LocalDateTime destino;

    @ManyToOne
    @JoinColumn(name = "aerolinea_id")
    @JsonIgnoreProperties({"vuelos"})
    private Aerolinea aerolinea;

    @ManyToOne
    @JoinColumn(name = "avion_id")
    @JsonIgnoreProperties({"asientos"})
    private Avion avion;

    @ManyToOne
    @JoinColumn(name = "piloto_id")
    private Piloto piloto;

    @ManyToMany
    @JoinTable(
        name = "vuelo_aeropuerto",
        joinColumns = @JoinColumn(name = "vuelo_id"),
        inverseJoinColumns = @JoinColumn(name = "aeropuerto_id")
    )
    @JsonIgnoreProperties({"vuelos"})
    private List<Aeropuerto> aeropuertos;

    @OneToMany(mappedBy = "vuelo")
    @JsonIgnoreProperties({"vuelo"})
    private List<Tarifa> tarifas;

    @OneToMany(mappedBy = "vuelo")
    @JsonIgnore
    private List<Reserva> reservas;

    public void addAeropuerto(Aeropuerto aeropuerto) {
        this.aeropuertos.add(aeropuerto);
        aeropuerto.getVuelos().add(this);
    }

    public boolean removeAeropuerto(Aeropuerto aeropuerto) {
        aeropuerto.getVuelos().remove(this);
        return this.aeropuertos.remove(aeropuerto);
    }
}
