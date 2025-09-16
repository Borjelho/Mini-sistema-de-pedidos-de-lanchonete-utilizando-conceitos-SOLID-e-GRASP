package entities.pedido;

import java.util.ArrayList;
import java.util.List;
import enums.Status;
import interfaces.IGeradorRecibo;
import interfaces.INotificador;
import interfaces.IPagamento;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import entities.desconto.CalculadoraDesconto;

public class Pedido {
    private List<ItemPedido> itens;
    private UUID uuid;
    private Status status;
    private AtomicLong seqItem = new AtomicLong(1);
    private boolean desconto;
    private double totDesconto;
    private IPagamento formaPagamento;

    public Pedido(UUID uuid, Status status) {
        this.itens = new ArrayList<>();
        this.uuid = uuid;
        this.status = status;
    }

    public double subTotal() {
        double subTotal = 0;
        for (ItemPedido ItemPedido : itens) {
            subTotal += ItemPedido.getQuantidade() * ItemPedido.getPrecoUnit();
        }
        return subTotal;
    }

    public double calculaDesconto() {
        CalculadoraDesconto calculadora = new CalculadoraDesconto();
        double dis = calculadora.calcular(this);
        this.totDesconto = dis;
        return dis;
    }

    public double total() {
        return subTotal() - calculaDesconto();
    }

    public boolean elegivelDesconto() {
        if (subTotal() > 100) {
            this.desconto = true;
            return true;
        } else {
            return false;
        }
    }

    public static Pedido criarPedido() {
        Pedido pedido = new Pedido(UUID.randomUUID(), Status.ABERTO);
        return pedido;
    }

    public ItemPedido adicionarItem(String produto, double precoUnit, int quantidade) {
        long id = seqItem.getAndIncrement();
        ItemPedido item = new ItemPedido(produto, precoUnit, quantidade, id);
        itens.add(item);
        return item;
    }

    public boolean removerItemPorId(long id) {
        return itens.removeIf(item -> item.getId() == id);
    }

    public void listarItens() {
        for (ItemPedido itemPedido : itens) {
            System.out.println("Item: " + itemPedido.getProduto() + " ID: " + itemPedido.getId());
        }
    }

    public void geraRecibo() {
        IGeradorRecibo geradorRecibo = new GeradorReciboTexto();
        if (status != Status.FINALIZADO) {
            System.out.println("ERRO: Pedido Não Finalizado");
            return;
        }
        String recibo = geradorRecibo.gerarRecibo(this);
        System.out.println(recibo);
    }

    public UUID getUuid() {
        return uuid;
    }

    public void pagar(IPagamento formaPagamento) {
        formaPagamento.pagar(this);
        this.formaPagamento = formaPagamento;
        status = Status.FINALIZADO;
    }

    public void notificar() {
        INotificador notificador = new Notificador();
        notificador.enviarNotificacao(this);
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public Status getStatus() {
        return status;
    }

    public AtomicLong getSeqItem() {
        return seqItem;
    }

    public boolean hasDesconto() {
        return desconto;
    }

    public double getTotDesconto() {
        return totDesconto;
    }

    public IPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setDesconto(boolean desconto) {
        this.desconto = desconto;
    }

}
