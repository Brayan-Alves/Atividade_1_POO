package Transporte;

public class Pagamento {
    private boolean pago;
    private int preco;
    
    public Pagamento(boolean pago, int preco) {
        this.pago = pago;
        this.preco = preco;
    }
    
    public boolean isPago() {
        return pago;
    }
    public void setPago(boolean pago) {
        this.pago = pago;
    }
    public int getPreco() {
        return preco;
    }
    public void setPreco(int preco) {
        this.preco = preco;
    }
}
