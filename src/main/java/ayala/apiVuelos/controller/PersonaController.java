package ayala.apiVuelos.controller;

import ayala.apiVuelos.entities.Persona;
import ayala.apiVuelos.services.PersonaService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/personas")
public class PersonaController extends BaseControllerImpl<Persona, Long> {

    public PersonaController(PersonaService personaService) {
        super(personaService);
    }
}
