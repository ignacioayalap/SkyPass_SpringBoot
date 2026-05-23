package ayala.apiVuelos.controller;

import ayala.apiVuelos.entities.Ciudad;
import ayala.apiVuelos.services.CiudadService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/ciudades")
public class CiudadController extends BaseControllerImpl<Ciudad, Long> {

    public CiudadController(CiudadService ciudadService) {
        super(ciudadService);
    }
}
