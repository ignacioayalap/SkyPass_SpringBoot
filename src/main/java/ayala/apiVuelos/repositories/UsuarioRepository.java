package ayala.apiVuelos.repositories;

import ayala.apiVuelos.entities.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends BaseRepository<Usuario, Long> {

    @Query("SELECT MAX(u.numeroUsuario) FROM Usuario u")
    Integer findMaxNumeroUsuario();
}
