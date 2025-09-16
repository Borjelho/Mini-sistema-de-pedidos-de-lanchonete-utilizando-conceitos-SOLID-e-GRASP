package entities.desconto;

import entities.pedido.Pedido;
import interfaces.ICalculadoraDesconto;

public class DescontoPercentual implements ICalculadoraDesconto {

    @Override
    public double calculaDesconto(Pedido pedido) {
        pedido.setDesconto(true);
        return pedido.subTotal() * 0.10;
    }

    @Override
    public boolean aplicavel(Pedido pedido) {
        return pedido.elegivelDesconto();
    }

}
