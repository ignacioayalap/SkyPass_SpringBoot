package ayala.apiVuelos.services;

import ayala.apiVuelos.entities.Usuario;
import ayala.apiVuelos.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario, Long> implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        super(usuarioRepository);
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    @Transactional
    public Usuario save(Usuario entity) throws Exception {
        if (entity.getPersona() == null) {
            throw new Exception("La persona asociada al usuario es obligatoria.");
        }

        if (entity.getNumeroUsuario() == null || entity.getNumeroUsuario() <= 0) {
            Integer maxNumeroUsuario = usuarioRepository.findMaxNumeroUsuario();
            entity.setNumeroUsuario((maxNumeroUsuario == null ? 999 : maxNumeroUsuario) + 1);
        }
        return super.save(entity);
    }
}
