package ayala.apiVuelos.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Reserva extends Base {
    private int numeroReserva;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonIgnoreProperties({"consultas", "reservas", "tarjetas", "contraseñaUsuario", "persona"})
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "vuelo_id")
    @JsonIgnoreProperties({"reservas", "tarifas", "piloto", "avion"})
    private Vuelo vuelo;

    @OneToOne
    @JoinColumn(name = "pago_id")
    @JsonIgnoreProperties({"usuario", "hibernateLazyInitializer", "handler"})
    private Tarjeta pago;
}
