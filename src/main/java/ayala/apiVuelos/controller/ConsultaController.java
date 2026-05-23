package ayala.apiVuelos.controller;

import ayala.apiVuelos.entities.Consulta;
import ayala.apiVuelos.services.ConsultaService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/consultas")
public class ConsultaController extends BaseControllerImpl<Consulta, Long> {

    public ConsultaController(ConsultaService consultaService) {
        super(consultaService);
    }
}
