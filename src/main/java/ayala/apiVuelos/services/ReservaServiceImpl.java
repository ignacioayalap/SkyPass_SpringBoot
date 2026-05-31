package ayala.apiVuelos.services;

import ayala.apiVuelos.entities.Pago;
import ayala.apiVuelos.entities.Reserva;
import ayala.apiVuelos.entities.Tarjeta;
import ayala.apiVuelos.entities.Usuario;
import ayala.apiVuelos.entities.Vuelo;
import ayala.apiVuelos.repositories.PagoRepository;
import ayala.apiVuelos.repositories.ReservaRepository;
import ayala.apiVuelos.repositories.UsuarioRepository;
import ayala.apiVuelos.repositories.VueloRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReservaServiceImpl extends BaseServiceImpl<Reserva, Long> implements ReservaService {

    private final ReservaRepository reservaRepository;
    private final UsuarioRepository usuarioRepository;
    private final VueloRepository vueloRepository;
    private final PagoRepository pagoRepository;

    public ReservaServiceImpl(
            ReservaRepository reservaRepository,
            UsuarioRepository usuarioRepository,
            VueloRepository vueloRepository,
            PagoRepository pagoRepository) {
        super(reservaRepository);
        this.reservaRepository = reservaRepository;
        this.usuarioRepository = usuarioRepository;
        this.vueloRepository = vueloRepository;
        this.pagoRepository = pagoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Reserva> findAll() throws Exception {
        return reservaRepository.findAllWithDetails();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Reserva save(Reserva entity) throws Exception {
        if (entity.getUsuario() == null || entity.getUsuario().getId() == null) {
            throw new Exception("El usuario es obligatorio para la reserva.");
        }
        if (entity.getVuelo() == null || entity.getVuelo().getId() == null) {
            throw new Exception("El vuelo es obligatorio para la reserva.");
        }
        if (entity.getPago() == null || entity.getPago().getId() == null) {
            throw new Exception("El pago es obligatorio para la reserva.");
        }

        Usuario usuario = usuarioRepository.findById(entity.getUsuario().getId())
                .orElseThrow(() -> new Exception("Usuario no encontrado."));
        Vuelo vuelo = vueloRepository.findById(entity.getVuelo().getId())
                .orElseThrow(() -> new Exception("Vuelo no encontrado."));
        Pago pagoEntity = pagoRepository.findById(entity.getPago().getId())
                .orElseThrow(() -> new Exception("Pago no encontrado."));

        entity.setUsuario(usuario);
        entity.setVuelo(vuelo);
        entity.setPago((Tarjeta) pagoEntity);

        return reservaRepository.save(entity);
    }
}
