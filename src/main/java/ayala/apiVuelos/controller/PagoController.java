package ayala.apiVuelos.controller;

import ayala.apiVuelos.entities.Pago;
import ayala.apiVuelos.services.PagoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/pagos")
public class PagoController extends BaseControllerImpl<Pago, Long> {

    public PagoController(PagoService pagoService) {
        super(pagoService);
    }
}
