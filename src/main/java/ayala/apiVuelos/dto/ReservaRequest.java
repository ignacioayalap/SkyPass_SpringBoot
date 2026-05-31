package ayala.apiVuelos.dto;

public record ReservaRequest(
        int numeroReserva,
        EntityRef usuario,
        EntityRef vuelo,
        EntityRef pago
) {
    public record EntityRef(Long id) {}

    public Long usuarioId() {
        return usuario != null ? usuario.id() : null;
    }

    public Long vueloId() {
        return vuelo != null ? vuelo.id() : null;
    }

    public Long pagoId() {
        return pago != null ? pago.id() : null;
    }
}
