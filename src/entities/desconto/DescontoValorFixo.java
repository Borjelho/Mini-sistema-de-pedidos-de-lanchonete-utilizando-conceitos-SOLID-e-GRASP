package entities.desconto;

import entities.pedido.Pedido;
import interfaces.ICalculadoraDesconto;

public class DescontoValorFixo implements ICalculadoraDesconto {

    @Override
    public double calculaDesconto(Pedido pedido) {
        pedido.setDesconto(true);
        return pedido.subTotal() - 4.0;
    }

    @Override
    public boolean aplicavel(Pedido pedido) {
        if (!pedido.elegivelDesconto()) {
            return true;
        } else {
            return false;
        }
    }

}
