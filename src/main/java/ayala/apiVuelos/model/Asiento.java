package ayala.apiVuelos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;

@Entity
public class Asiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int filaAsiento;
    private char letraAsiento;

    @Enumerated(EnumType.STRING)
    private Clase claseAsiento;

    @ManyToOne
    @JoinColumn(name = "avion_numero")
    private Avion avion;

    public Asiento() {
    }

    public Asiento(int filaAsiento, char letraAsiento, Clase claseAsiento) {
        this.filaAsiento = filaAsiento;
        this.letraAsiento = letraAsiento;
        this.claseAsiento = claseAsiento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getFilaAsiento() {
        return filaAsiento;
    }

    public void setFilaAsiento(int filaAsiento) {
        this.filaAsiento = filaAsiento;
    }

    public char getLetraAsiento() {
        return letraAsiento;
    }

    public void setLetraAsiento(char letraAsiento) {
        this.letraAsiento = letraAsiento;
    }

    public Clase getClaseAsiento() {
        return claseAsiento;
    }

    public void setClaseAsiento(Clase claseAsiento) {
        this.claseAsiento = claseAsiento;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }
}
