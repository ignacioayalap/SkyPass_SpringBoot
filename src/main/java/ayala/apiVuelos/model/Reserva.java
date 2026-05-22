package ayala.apiVuelos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Reserva {

    @Id
    private int numeroReserva;

    @ManyToOne
    @JoinColumn(name = "usuario_dni")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "vuelo_numero")
    private Vuelo vuelo;

    @OneToOne
    @JoinColumn(name = "pago_numero")
    private Pago pago;

    public Reserva() {
    }

    public Reserva(int numeroReserva) {
        this.numeroReserva = numeroReserva;
    }

    public int getNumeroReserva() {
        return numeroReserva;
    }

    public void setNumeroReserva(int numeroReserva) {
        this.numeroReserva = numeroReserva;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }
}
