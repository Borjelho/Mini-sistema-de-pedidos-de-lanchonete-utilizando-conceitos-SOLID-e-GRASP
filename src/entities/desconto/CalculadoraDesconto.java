package entities.desconto;

import java.util.ArrayList;
import java.util.List;

import entities.pedido.Pedido;
import interfaces.ICalculadoraDesconto;

public class CalculadoraDesconto {
    private final List<ICalculadoraDesconto> regras = new ArrayList<>();

    public CalculadoraDesconto() {
        DescontoPercentual descontoPercentual = new DescontoPercentual();
        DescontoValorFixo descontoValorFixo = new DescontoValorFixo();
        regras.add(descontoValorFixo);
        regras.add(descontoPercentual);
    }

    public double calcular(Pedido pedido) {
        for (ICalculadoraDesconto r : regras) {
            if (r.aplicavel(pedido)) {
                return r.calculaDesconto(pedido);
            }
        }
        return 0.0;
    }
}
