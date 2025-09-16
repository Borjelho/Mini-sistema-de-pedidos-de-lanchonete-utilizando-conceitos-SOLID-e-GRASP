package entities.pagamento;

import java.util.ArrayList;
import java.util.List;

import interfaces.IPagamento;

public class Pagamento {
    private final List<IPagamento> formaPagamento;

    public Pagamento() {
        formaPagamento = new ArrayList<IPagamento>();
        formaPagamento.add(new PagamentoCartaoCredito());
        formaPagamento.add(new PagamentoPix());
    }

    
}
