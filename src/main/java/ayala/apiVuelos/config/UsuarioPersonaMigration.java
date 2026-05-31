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
                    "UPDATE usuario SET persona_id = id WHERE persona_id IS NULL OR persona_id = 0"
            );
        } catch (Exception ignored) {
            // Si la columna aún no existe (primer arranque con ddl-auto), se ignora.
        }

        try {
            jdbcTemplate.execute(
                    "ALTER TABLE tarjeta MODIFY COLUMN tipo_tarjeta VARCHAR(20)"
            );
        } catch (Exception ignored) {
            // La columna puede no existir aún o ya estar en VARCHAR.
        }

        dropLegacyUsuarioPersonaIdConstraint();
        enableUsuarioAutoIncrement();
    }

    /**
     * Elimina la FK heredada del modelo JOINED (usuario.id -> persona.id).
     * Con @ManyToOne persona_id, usuario y persona tienen IDs independientes.
     */
    private void dropLegacyUsuarioPersonaIdConstraint() {
        try {
            jdbcTemplate.execute(
                    "ALTER TABLE usuario DROP FOREIGN KEY FK3dwml4n2qu5ywbqvivg5xkdtc"
            );
        } catch (Exception ignored) {
            // Ya eliminada o nombre distinto según entorno.
        }
    }

    private void enableUsuarioAutoIncrement() {
        try {
            Long maxId = jdbcTemplate.queryForObject(
                    "SELECT COALESCE(MAX(id), 0) FROM usuario",
                    Long.class
            );
            jdbcTemplate.execute(
                    "ALTER TABLE usuario MODIFY id BIGINT NOT NULL AUTO_INCREMENT"
            );
            jdbcTemplate.execute(
                    "ALTER TABLE usuario AUTO_INCREMENT = " + (maxId + 1)
            );
        } catch (Exception ignored) {
            // Si la tabla aún no existe, se ignora.
        }
    }
}
