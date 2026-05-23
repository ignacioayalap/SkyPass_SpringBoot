package ayala.apiVuelos.controller;

import ayala.apiVuelos.entities.Aerolinea;
import ayala.apiVuelos.services.AerolineaService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/aerolineas")
public class AerolineaController extends BaseControllerImpl<Aerolinea, Long> {

    public AerolineaController(AerolineaService aerolineaService) {
        super(aerolineaService);
    }
}
