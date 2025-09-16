package entities.pedido;

import interfaces.INotificador;

public class Notificador implements INotificador {

    @Override
    public boolean enviarNotificacao(Pedido pedido) {
        System.out.println("Notificação enviada!");
        return true;
    }

}
