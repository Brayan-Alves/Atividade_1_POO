package Transporte;

public class Main {
    public static void main(String[] args) {
        
        Motorista m = new Motorista("Evandorvilson");
        Passageiro p = new Passageiro("Brayan");

        Corrida c1 = new Corrida(m, p, "Casa", "IF");
        Pagamento p1 = new Pagamento(false, 15);
        c1.setPagamento(p1);

        p.pagarCorrida(c1);

        m.adicionarCorrida(c1);
        p.adicionarCorrida(c1);

        System.out.printf("Corridas de Motorista: \n");
        int cont = 1;
        for (Corrida c : m.getCorridasFeitas()) {
            System.out.printf("%d. Passageiro: %s | Origem: %s | Destino: %s | Preço: %d\n", cont, c.getPassageiro().getNome(), c.getOrigem(), c.getDestino(), c.getPagamento().getPreco());
            cont++;
        }

        System.out.printf("\nCorridas de Passageiro: \n");
        cont = 1;
        for (Corrida c : m.getCorridasFeitas()) {
            System.out.printf("%d. Motorista: %s | Origem: %s | Destino: %s | Preço: %d\n", cont, c.getMotorista().getNome(), c.getOrigem(), c.getDestino(), c.getPagamento().getPreco());
            cont++;
        }

        System.out.printf("\nPagamento de Corrida: \n");
        System.out.printf("Preço: %d | Pagamento: %s", p1.getPreco(), (p1.isPago()) ? "confirmado" : "recusado");
    }
}
