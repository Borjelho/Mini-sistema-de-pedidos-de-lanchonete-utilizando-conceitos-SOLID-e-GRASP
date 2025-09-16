package interfaces;

import entities.pedido.Pedido;

public interface IPagamento {
    boolean pagar(Pedido pedido);

    String tipo();
}
