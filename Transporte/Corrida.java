package Transporte;

public class Corrida {
    private Motorista motorista;
    private Passageiro passageiro;
    private String origem;
    private String destino;
    private Pagamento pagamento;
    
    public Corrida(Motorista motorista, Passageiro passageiro, String origem, String destino, int preco) {
        this.motorista = motorista;
        this.passageiro = passageiro;
        this.origem = origem;
        this.destino = destino;
        this.pagamento = new Pagamento(false, preco);
    }
    public Motorista getMotorista() {
        return motorista;
    }
    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }
    public Passageiro getPassageiro() {
        return passageiro;
    }
    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }
    public String getOrigem() {
        return origem;
    }
    public void setOrigem(String origem) {
        this.origem = origem;
    }
    public String getDestino() {
        return destino;
    }
    public void setDestino(String destino) {
        this.destino = destino;
    }
    public Pagamento getPagamento() {
        return pagamento;
    }
    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }
}
