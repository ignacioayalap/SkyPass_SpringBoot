package ayala.apiVuelos.controller;

import ayala.apiVuelos.entities.Piloto;
import ayala.apiVuelos.services.PilotoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/pilotos")
public class PilotoController extends BaseControllerImpl<Piloto, Long> {

    public PilotoController(PilotoService pilotoService) {
        super(pilotoService);
    }
}
