package ayala.apiVuelos.controller;

import ayala.apiVuelos.entities.Aeropuerto;
import ayala.apiVuelos.services.AeropuertoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/aeropuertos")
public class AeropuertoController extends BaseControllerImpl<Aeropuerto, Long> {

    public AeropuertoController(AeropuertoService aeropuertoService) {
        super(aeropuertoService);
    }
}
