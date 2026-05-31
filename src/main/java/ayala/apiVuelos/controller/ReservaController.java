package ayala.apiVuelos.controller;

import ayala.apiVuelos.dto.ReservaRequest;
import ayala.apiVuelos.entities.Reserva;
import ayala.apiVuelos.entities.Tarjeta;
import ayala.apiVuelos.entities.Usuario;
import ayala.apiVuelos.entities.Vuelo;
import ayala.apiVuelos.services.ReservaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.ok(reservaService.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "Error, por favor intente mas tarde."));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(reservaService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "Error, por favor intente mas tarde."));
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody ReservaRequest request) {
        try {
            Reserva entity = new Reserva();
            entity.setNumeroReserva(request.numeroReserva());

            if (request.usuarioId() == null) {
                throw new Exception("El usuario es obligatorio para la reserva.");
            }
            if (request.vueloId() == null) {
                throw new Exception("El vuelo es obligatorio para la reserva.");
            }
            if (request.pagoId() == null) {
                throw new Exception("El pago es obligatorio para la reserva.");
            }

            Usuario usuario = new Usuario();
            usuario.setId(request.usuarioId());
            entity.setUsuario(usuario);

            Vuelo vuelo = new Vuelo();
            vuelo.setId(request.vueloId());
            entity.setVuelo(vuelo);

            Tarjeta pago = new Tarjeta();
            pago.setId(request.pagoId());
            entity.setPago(pago);

            return ResponseEntity.ok(reservaService.save(entity));
        } catch (Exception e) {
            e.printStackTrace();
            Throwable root = e;
            while (root.getCause() != null) {
                root = root.getCause();
            }
            String message = root.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", message != null && !message.isBlank()
                            ? message
                            : "Error al procesar la solicitud."));
        }
    }
}
