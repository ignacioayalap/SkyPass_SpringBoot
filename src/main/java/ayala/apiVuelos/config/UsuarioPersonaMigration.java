package ayala.apiVuelos.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * Completa persona_id en registros creados con el modelo anterior (JOINED),
 * donde usuario.id coincidía con persona.id.
 */
@Component
@Order(2)
public class UsuarioPersonaMigration implements CommandLineRunner {

    private final JdbcTemplate jdbcTemplate;

    public UsuarioPersonaMigration(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run(String... args) {
        try {
            jdbcTemplate.update(
                    "UPDATE usuario SET persona_id = id WHERE persona_id IS NULL AND id IS NOT NULL"
            );
        } catch (Exception ignored) {
            // Si la columna aún no existe (primer arranque con ddl-auto), se ignora.
        }
    }
}
