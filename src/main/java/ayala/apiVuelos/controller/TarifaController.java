package ayala.apiVuelos.controller;

import ayala.apiVuelos.entities.Tarifa;
import ayala.apiVuelos.services.TarifaService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/tarifas")
public class TarifaController extends BaseControllerImpl<Tarifa, Long> {

    public TarifaController(TarifaService tarifaService) {
        super(tarifaService);
    }
}
