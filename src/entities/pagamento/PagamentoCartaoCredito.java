package entities.pagamento;

import entities.pedido.Pedido;
import interfaces.IPagamento;

public class PagamentoCartaoCredito implements IPagamento {
    @Override
    public boolean pagar(Pedido pedido) {
        System.out.println("Pagamento aprovado no Cartão de Crédito no valor de " + pedido.total());
        return true;
    }

    public String tipo() {
        return "Cartão de Crédito";
    }
}
