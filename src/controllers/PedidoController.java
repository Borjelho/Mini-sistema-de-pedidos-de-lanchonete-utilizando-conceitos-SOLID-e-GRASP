package controllers;

import java.util.UUID;

import entities.pedido.ItemPedido;
import entities.pedido.Pedido;
import interfaces.IPagamento;
import repo.PedidoRepositorio;

public class PedidoController {
    private final PedidoRepositorio repositorio;

    public PedidoController() {
        this.repositorio = new PedidoRepositorio();
    }

    public UUID criarPedido() {
        Pedido pedido = Pedido.criarPedido();
        repositorio.salvar(pedido);
        return pedido.getUuid();
    }

    public long adicionarItem(UUID pedidoId, String produto, double precoUnit, int quantidade) {
        Pedido pedido = repositorio.porId(pedidoId);
        ItemPedido item = pedido.adicionarItem(produto, precoUnit, quantidade);
        repositorio.salvar(pedido);
        return item.getId();
    }

    public boolean removerItem(UUID pedidoID, long itemId) {
        Pedido pedido = repositorio.porId(pedidoID);
        boolean removido = pedido.removerItemPorId(itemId);
        if (!removido)
            return false;
        repositorio.salvar(pedido);
        return true;
    }

    public void pagar(UUID pedidoID, IPagamento formaPagamento) {
        Pedido pedido = repositorio.porId(pedidoID);
        pedido.pagar(formaPagamento);
        pedido.notificar();
    }

    public void listarItens(UUID pedidoID) {
        Pedido pedido = repositorio.porId(pedidoID);
        pedido.listarItens();
    }

    public void geraRecibo(UUID pedidoID) {
        Pedido pedido = repositorio.porId(pedidoID);
        pedido.geraRecibo();
    }

}