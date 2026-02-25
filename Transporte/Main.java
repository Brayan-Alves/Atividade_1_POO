package Transporte;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner LER = new Scanner(System.in);
    public static void main(String[] args) {
        
        List<Motorista> motoristas = new ArrayList<>();
        List<Passageiro> passageiros = new ArrayList<>();
        List<Corrida> todasCorridas = new ArrayList<>();

        motoristas.add(new Motorista("Roberto"));
        motoristas.add(new Motorista("Juliana"));
        passageiros.add(new Passageiro("Marcos"));
        passageiros.add(new Passageiro("Aline"));

        int opcao = 0;

        while (opcao != 6) {
            System.out.println("\n=== Sistema de Transporte Simplificado ===");
            System.out.println("1. Solicitar nova Corrida");
            System.out.println("2. Listar corridas de um motorista");
            System.out.println("3. Listar corridas de um passageiro");
            System.out.println("4. Mostrar pagamento de uma corrida");
            System.out.println("5. Realizar pagamento de uma corrida pendente");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            
            try {
                opcao = Integer.parseInt(LER.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida!");
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.println("Selecione o Passageiro:");
                    for (int i = 0; i < passageiros.size(); i++) {
                        System.out.println(i + " - " + passageiros.get(i).getNome());
                    }
                    Passageiro pSelecionado = passageiros.get(Integer.parseInt(LER.nextLine()));
                    System.out.println("Selecione o Motorista:");
                    for (int i = 0; i < motoristas.size(); i++) {
                        System.out.println(i + " - " + motoristas.get(i).getNome());
                    }
                    Motorista mSelecionado = motoristas.get(Integer.parseInt(LER.nextLine()));
                    System.out.print("Local de Origem: ");
                    String origem = LER.nextLine();
                    System.out.print("Local de Destino: ");
                    String destino = LER.nextLine();
                    System.out.print("Valor da Corrida: ");
                    int valor = Integer.parseInt(LER.nextLine());
                    Corrida novaCorrida = new Corrida(mSelecionado, pSelecionado, origem, destino, valor);
                    pSelecionado.adicionarCorrida(novaCorrida);
                    mSelecionado.adicionarCorrida(novaCorrida);
                    todasCorridas.add(novaCorrida);
                    System.out.println("Corrida registrada com sucesso!");
                    break;
                case 2:
                    System.out.println("Selecione o Motorista:");
                    for (int i = 0; i < motoristas.size(); i++) {
                        System.out.println(i + " - " + motoristas.get(i).getNome());
                    }
                    Motorista mList = motoristas.get(Integer.parseInt(LER.nextLine()));
                    System.out.println("\n--- Histórico do Motorista: " + mList.getNome() + " ---");
                    if (mList.getCorridasFeitas().isEmpty()) {
                        System.out.println("Nenhuma corrida realizada.");
                    } else {
                        for (int i = 0; i < mList.getCorridasFeitas().size(); i++) {
                            Corrida c = mList.getCorridasFeitas().get(i);
                            System.out.println("Corrida " + (i+1) + " | Passageiro: " + c.getPassageiro().getNome() + " | Trajeto: " + c.getOrigem() + " -> " + c.getDestino());
                        }
                    }
                    break;
                case 3:
                    System.out.println("Selecione o Passageiro:");
                    for (int i = 0; i < passageiros.size(); i++) {
                        System.out.println(i + " - " + passageiros.get(i).getNome());
                    }
                    Passageiro pList = passageiros.get(Integer.parseInt(LER.nextLine()));
                    System.out.println("\n--- Histórico do Passageiro: " + pList.getNome() + " ---");
                    if (pList.getCorridasFeitas().isEmpty()) {
                        System.out.println("Nenhuma corrida realizada.");
                    } else {
                        for (int i = 0; i < pList.getCorridasFeitas().size(); i++) {
                            Corrida c = pList.getCorridasFeitas().get(i);
                            System.out.println("Corrida " + (i+1) + " | Motorista: " + c.getMotorista().getNome() + " | Trajeto: " + c.getOrigem() + " -> " + c.getDestino());
                        }
                    }
                    break;
                case 4:
                    if (todasCorridas.isEmpty()) {
                        System.out.println("Não há corridas registradas no sistema.");
                        break;
                    }
                    System.out.println("Selecione a Corrida do sistema geral:");
                    for (int i = 0; i < todasCorridas.size(); i++) {
                        Corrida c = todasCorridas.get(i);
                        System.out.println(i + " - " + c.getOrigem() + " para " + c.getDestino() + " (" + c.getPassageiro().getNome() + ")");
                    }
                    Corrida cPag = todasCorridas.get(Integer.parseInt(LER.nextLine()));
                    Pagamento pag = cPag.getPagamento();
                    
                    System.out.println("\n--- Status do Pagamento ---");
                    System.out.println("Valor: R$ " + pag.getPreco());
                    System.out.println("Situação: " + (pag.isPago() ? "PAGO" : "PENDENTE"));
                    break;
                case 5:
                    if (todasCorridas.isEmpty()) {
                        System.out.println("Não há corridas registradas no sistema.");
                        break;
                    }
                    System.out.println("Selecione a Corrida para pagar:");
                    for (int i = 0; i < todasCorridas.size(); i++) {
                        System.out.println(i + " - De " + todasCorridas.get(i).getOrigem() + " para " + todasCorridas.get(i).getDestino());
                    }
                    Corrida cPagar = todasCorridas.get(Integer.parseInt(LER.nextLine()));      
                    if(cPagar.getPagamento().isPago()){
                        System.out.println("Esta corrida já foi paga!");
                    } else {
                        cPagar.getPassageiro().pagarCorrida(cPagar);
                        System.out.println("Pagamento realizado com sucesso pelo passageiro " + cPagar.getPassageiro().getNome());
                    }
                    break;
                case 6:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}