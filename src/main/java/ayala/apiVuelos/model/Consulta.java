package ayala.apiVuelos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
public class Consulta {

    @Id
    private int numeroConsulta;

    @ManyToOne
    @JoinColumn(name = "usuario_dni")
    private Usuario usuario;

    public Consulta() {
    }

    public Consulta(int numeroConsulta) {
        this.numeroConsulta = numeroConsulta;
    }

    public int getNumeroConsulta() {
        return numeroConsulta;
    }

    public void setNumeroConsulta(int numeroConsulta) {
        this.numeroConsulta = numeroConsulta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
