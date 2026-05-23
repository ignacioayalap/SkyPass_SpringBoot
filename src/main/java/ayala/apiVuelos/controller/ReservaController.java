package ayala.apiVuelos.controller;

import ayala.apiVuelos.entities.Reserva;
import ayala.apiVuelos.services.ReservaService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/reservas")
public class ReservaController extends BaseControllerImpl<Reserva, Long> {

    public ReservaController(ReservaService reservaService) {
        super(reservaService);
    }
}
