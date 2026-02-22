package Transporte;

public class Passageiro extends Usuario {

    public Passageiro(String nome) {
        super(nome);
        
    }

    public Corrida pagarCorrida(Corrida c){
        c.getPagamento().setPago(true);
        return c;
    }
    
}
