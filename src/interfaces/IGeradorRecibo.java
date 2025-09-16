package interfaces;

import entities.pedido.Pedido;

public interface IGeradorRecibo {
    String gerarRecibo(Pedido pedido);
}
