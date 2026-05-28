package ayala.apiVuelos.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Aeropuerto extends Base {
    private String nombreAeropuerto;

    @ManyToOne
    @JoinColumn(name = "ciudad_id")
    @JsonIgnoreProperties({"aeropuertos"})
    private Ciudad ciudad;

    @ManyToMany(mappedBy = "aeropuertos")
    @JsonIgnore
    private List<Vuelo> vuelos;
}
