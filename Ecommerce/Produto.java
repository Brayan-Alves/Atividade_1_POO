package Ecommerce;

public class Produto {
    private String nome;
    private Fornecedor fornecedor;
    
    public Produto(String nome, Fornecedor fornecedor) {
        this.nome = nome;
        this.fornecedor = fornecedor;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Fornecedor getFornecedor() {
        return fornecedor;
    }
    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
}
