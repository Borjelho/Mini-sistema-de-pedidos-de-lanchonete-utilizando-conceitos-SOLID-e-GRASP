package repo;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import entities.pedido.Pedido;
import interfaces.IPedidoRepositorio;

public class PedidoRepositorio implements IPedidoRepositorio {
    private final Map<UUID, Pedido> banco = new HashMap<>();

    @Override
    public void salvar(Pedido pedido) {
        banco.put(pedido.getUuid(), pedido);
    }

    @Override
    public Pedido porId(UUID id) {
        return banco.get(id);
    }

    public void listarIdPedidos() {
        for (Pedido pedidos : banco.values()) {
            pedidos.getUuid();
        }
    }
}
