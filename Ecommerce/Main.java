package Ecommerce;

public class Main {
    public static void main(String[] args) {
        
        Cliente c1 = new Cliente("Brayan");

        Fornecedor f1 = new Fornecedor("Sim");

        Produto pr1 = new Produto("CoisaA", f1);
        Produto pr2 = new Produto("CoisaB", f1);

        NotaFiscal nf = new NotaFiscal("0000001");
        Pedido pe1 = new Pedido(nf, c1);
        pe1.adicionarProdutos(pr1);
        pe1.adicionarProdutos(pr2);

        c1.adicionarPedido(pe1);

        System.out.println("Pedidos do cliente: ");
        int cont = 1;
        for (Pedido p : c1.getPedidos()) {
            System.out.printf("%d. Cliente: %s | Nota Fiscal: %s", cont, p.getCliente().getNome(),  p.getNotaFiscal().getId());
            cont++;
        }

        System.out.println("\n\nProdutos do Pedido: ");
        cont = 1;
        for (Produto p : pe1.getProdutos()) {
            System.out.printf("%d. Nome: %s | Fornecedor: %s", cont, p.getNome(), p.getFornecedor().getNome());
            cont++;
        }
    }
}
