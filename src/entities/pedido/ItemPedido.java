package entities.pedido;

public class ItemPedido {
    private String produto;
    private double precoUnit;
    private int quantidade;
    private long id;

    public ItemPedido(String produto, double precoUnit, int quantidade, long id) {
        this.produto = produto;
        this.precoUnit = precoUnit;
        this.quantidade = quantidade;
        this.id = id;
    }

    public double totalItem() {
        return quantidade * precoUnit;
    }

    public String getProduto() {
        return produto;
    }

    public double getPrecoUnit() {
        return precoUnit;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public long getId() {
        return id;
    }

}
