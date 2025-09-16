package interfaces;

import java.util.UUID;

import entities.pedido.Pedido;

public interface IPedidoRepositorio {
    void salvar(Pedido pedido);

    Pedido porId(UUID id);
}
