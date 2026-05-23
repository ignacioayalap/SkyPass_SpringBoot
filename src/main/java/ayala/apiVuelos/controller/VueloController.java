package ayala.apiVuelos.controller;

import ayala.apiVuelos.entities.Vuelo;
import ayala.apiVuelos.services.VueloService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/vuelos")
public class VueloController extends BaseControllerImpl<Vuelo, Long> {

    public VueloController(VueloService vueloService) {
        super(vueloService);
    }
}
