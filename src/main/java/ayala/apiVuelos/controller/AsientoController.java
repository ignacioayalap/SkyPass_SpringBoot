package ayala.apiVuelos.controller;

import ayala.apiVuelos.entities.Asiento;
import ayala.apiVuelos.services.AsientoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/asientos")
public class AsientoController extends BaseControllerImpl<Asiento, Long> {

    public AsientoController(AsientoService asientoService) {
        super(asientoService);
    }
}
