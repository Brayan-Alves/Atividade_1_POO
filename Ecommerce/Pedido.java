package Ecommerce;

import java.util.LinkedList;
import java.util.List;

public class Pedido {
    private List<Produto> produtos;
    private NotaFiscal notaFiscal;
    private Cliente cliente;
    
    public Pedido(NotaFiscal notaFiscal, Cliente cliente) {
        this.produtos = new LinkedList<Produto>();
        this.notaFiscal = notaFiscal;
        this.cliente = cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
    public void setProdutos(List<Produto> produto) {
        this.produtos = produto;
    }
    public NotaFiscal getNotaFiscal() {
        return notaFiscal;
    }
    public void setNotaFiscal(NotaFiscal notaFiscal) {
        this.notaFiscal = notaFiscal;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public void adicionarProdutos(Produto p){
        this.produtos.add(p);
    }
}
