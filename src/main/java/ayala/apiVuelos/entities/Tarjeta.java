package ayala.apiVuelos.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tarjeta extends Pago {
    private String numeroTarjeta;
    
    @Enumerated(EnumType.STRING)
    private TipoTarjeta tipoTarjeta;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonIgnoreProperties({"consultas", "reservas", "tarjetas", "contraseñaUsuario", "persona"})
    private Usuario usuario;
}
