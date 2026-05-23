package ayala.apiVuelos.controller;

import ayala.apiVuelos.entities.Avion;
import ayala.apiVuelos.services.AvionService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/aviones")
public class AvionController extends BaseControllerImpl<Avion, Long> {

    public AvionController(AvionService avionService) {
        super(avionService);
    }
}
