package ayala.apiVuelos.model;

import jakarta.persistence.Entity;

@Entity
public class Piloto extends Persona {

    private int numeroPiloto;

    public Piloto() {
    }

    public Piloto(int dniPersona, String nombrePersona, String apellidoPersona, int numeroPiloto) {
        super(dniPersona, nombrePersona, apellidoPersona);
        this.numeroPiloto = numeroPiloto;
    }

    public int getNumeroPiloto() {
        return numeroPiloto;
    }

    public void setNumeroPiloto(int numeroPiloto) {
        this.numeroPiloto = numeroPiloto;
    }
}
