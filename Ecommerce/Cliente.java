package Ecommerce;

import java.util.LinkedList;
import java.util.List;

public class Cliente {
    private String nome;
    private List<Pedido> pedidos;

    public Cliente(String nome) {
        this.pedidos = new LinkedList<Pedido>();
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public List<Pedido> getPedidos() {
        return pedidos;
    }
    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    public void adicionarPedido(Pedido p){
        this.pedidos.add(p);
    }
}
