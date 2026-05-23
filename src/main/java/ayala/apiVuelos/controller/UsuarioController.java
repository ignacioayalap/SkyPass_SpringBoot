package ayala.apiVuelos.controller;

import ayala.apiVuelos.entities.Usuario;
import ayala.apiVuelos.services.UsuarioService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/usuarios")
public class UsuarioController extends BaseControllerImpl<Usuario, Long> {

    public UsuarioController(UsuarioService usuarioService) {
        super(usuarioService);
    }
}
