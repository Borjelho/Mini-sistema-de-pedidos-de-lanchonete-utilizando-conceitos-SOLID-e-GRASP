package interfaces;

import entities.pedido.Pedido;

public interface ICalculadoraDesconto {
    boolean aplicavel(Pedido pedido);

    double calculaDesconto(Pedido pedido);
}
