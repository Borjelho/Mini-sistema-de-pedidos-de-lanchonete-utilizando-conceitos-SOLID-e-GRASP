package interfaces;

import entities.pedido.Pedido;

public interface INotificador {

    boolean enviarNotificacao(Pedido pedido);
}
