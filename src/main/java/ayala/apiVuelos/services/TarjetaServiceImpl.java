package ayala.apiVuelos.services;

import ayala.apiVuelos.entities.Tarjeta;
import ayala.apiVuelos.entities.Usuario;
import ayala.apiVuelos.repositories.TarjetaRepository;
import ayala.apiVuelos.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TarjetaServiceImpl extends BaseServiceImpl<Tarjeta, Long> implements TarjetaService {

    private final TarjetaRepository tarjetaRepository;
    private final UsuarioRepository usuarioRepository;

    public TarjetaServiceImpl(TarjetaRepository tarjetaRepository, UsuarioRepository usuarioRepository) {
        super(tarjetaRepository);
        this.tarjetaRepository = tarjetaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Tarjeta save(Tarjeta entity) throws Exception {
        if (entity.getUsuario() == null || entity.getUsuario().getId() == null) {
            throw new Exception("El usuario es obligatorio para registrar el pago.");
        }

        Usuario usuario = usuarioRepository.findById(entity.getUsuario().getId())
                .orElseThrow(() -> new Exception("Usuario no encontrado."));

        entity.setUsuario(usuario);
        return tarjetaRepository.save(entity);
    }
}
