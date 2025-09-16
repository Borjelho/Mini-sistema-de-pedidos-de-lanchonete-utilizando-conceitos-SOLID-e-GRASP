package entities.pedido;

import interfaces.IGeradorRecibo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GeradorReciboTexto implements IGeradorRecibo {

    @Override
    public String gerarRecibo(Pedido pedido) {
        StringBuilder sb = new StringBuilder();
        sb.append("===== RECIBO =====\n");
        pedido.getItens().forEach(item -> {
            sb.append(item.getProduto())
                    .append(" x").append(item.getQuantidade())
                    .append(" - R$ ").append(item.totalItem())
                    .append("\n");
        });
        sb.append("Subtotal: R$ ").append(pedido.subTotal()).append("\n");
        sb.append("Desconto: R$").append(pedido.calculaDesconto()).append("\n");
        sb.append("Total com desconto: R$ ").append(pedido.total()).append("\n");
        sb.append("Forma de pagamento: ").append(pedido.getFormaPagamento().tipo()).append("\n");
        sb.append("Status: ").append(pedido.getStatus()).append("\n");
        sb.append("Data/Hora: ").append(LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))).append("\n");
        sb.append("==================\n");
        return sb.toString();
    }
}
