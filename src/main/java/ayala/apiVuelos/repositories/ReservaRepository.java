package ayala.apiVuelos.repositories;

import ayala.apiVuelos.entities.Reserva;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepository extends BaseRepository<Reserva, Long> {

    @Query("""
            SELECT DISTINCT r FROM Reserva r
            LEFT JOIN FETCH r.usuario u
            LEFT JOIN FETCH u.persona
            LEFT JOIN FETCH r.vuelo v
            LEFT JOIN FETCH v.aeropuertos a
            LEFT JOIN FETCH a.ciudad
            LEFT JOIN FETCH r.pago
            """)
    List<Reserva> findAllWithDetails();
}
