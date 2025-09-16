package entities.pagamento;

import entities.pedido.Pedido;
import interfaces.IPagamento;

public class PagamentoPix implements IPagamento {

    @Override
    public boolean pagar(Pedido pedido) {
        System.out.println("Pagamento aprovado no Pix no valor de " + pedido.total());
        return true;
    }

    public String tipo() {
        return "Pix";
    }

}
