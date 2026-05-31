package ayala.apiVuelos.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Usuario extends Base {

    @ManyToOne(optional = false, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "persona_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Persona persona;

    private Integer numeroUsuario;
    private String contraseñaUsuario;
    private String correoElectronicoUsuario;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<Consulta> consultas;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<Reserva> reservas;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<Tarjeta> tarjetas;

    @JsonProperty("personaId")
    public Long getPersonaId() {
        return persona != null ? persona.getId() : null;
    }

    public int getDniPersona() {
        return persona != null ? persona.getDniPersona() : 0;
    }

    public void setDniPersona(int dniPersona) {
        ensurePersona().setDniPersona(dniPersona);
    }

    public String getNombrePersona() {
        return persona != null ? persona.getNombrePersona() : null;
    }

    public void setNombrePersona(String nombrePersona) {
        ensurePersona().setNombrePersona(nombrePersona);
    }

    public String getApellidoPersona() {
        return persona != null ? persona.getApellidoPersona() : null;
    }

    public void setApellidoPersona(String apellidoPersona) {
        ensurePersona().setApellidoPersona(apellidoPersona);
    }

    private Persona ensurePersona() {
        if (persona == null) {
            persona = new Persona();
        }
        return persona;
    }
}
