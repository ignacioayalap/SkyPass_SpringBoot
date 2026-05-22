package ayala.apiVuelos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Avion implements Especificacion {

    @Id
    private int numeroAvion;

    @OneToMany(mappedBy = "avion")
    private List<Asiento> asientos;

    public Avion() {
    }

    public Avion(int numeroAvion) {
        this.numeroAvion = numeroAvion;
    }

    public int getNumeroAvion() {
        return numeroAvion;
    }

    public void setNumeroAvion(int numeroAvion) {
        this.numeroAvion = numeroAvion;
    }

    public List<Asiento> getAsientos() {
        return asientos;
    }

    public void setAsientos(List<Asiento> asientos) {
        this.asientos = asientos;
    }

    public void addAsiento(Asiento asiento) {
        this.asientos.add(asiento);
        asiento.setAvion(this);
    }

    public boolean removeAsiento(Asiento asiento) {
        asiento.setAvion(null);
        return this.asientos.remove(asiento);
    }

    @Override
    public String tipoTurbina() {
        // Implementación requerida por la interfaz Especificacion
        return "Turbina estándar";
    }

    @Override
    public String tipoAvion() {
        // Implementación requerida por la interfaz Especificacion
        return "Comercial";
    }
}
