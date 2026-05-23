package ayala.apiVuelos.controller;

import ayala.apiVuelos.entities.Tarjeta;
import ayala.apiVuelos.services.TarjetaService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/tarjetas")
public class TarjetaController extends BaseControllerImpl<Tarjeta, Long> {

    public TarjetaController(TarjetaService tarjetaService) {
        super(tarjetaService);
    }
}
