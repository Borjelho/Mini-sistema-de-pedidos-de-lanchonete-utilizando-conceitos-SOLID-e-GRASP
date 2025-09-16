package app;

import java.util.UUID;

import controllers.PedidoController;
import entities.pagamento.PagamentoCartaoCredito;

public class Main {
    public static void main(String[] args) {
        PedidoController pedidoController = new PedidoController();
        UUID idPedido = pedidoController.criarPedido();
        pedidoController.adicionarItem(idPedido, "Rapadura", 10, 100);
        pedidoController.adicionarItem(idPedido, "Pedra", 5, 50);
        pedidoController.listarItens(idPedido);
        pedidoController.removerItem(idPedido, 2);

        PagamentoCartaoCredito pagamentoCartao = new PagamentoCartaoCredito();
        pedidoController.pagar(idPedido, pagamentoCartao);
        pedidoController.geraRecibo(idPedido);
    }
}
