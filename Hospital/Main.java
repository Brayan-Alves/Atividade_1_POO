package Hospital;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner LER = new Scanner(System.in);
    public static void main(String[] args) {
        
        List<Paciente> pacientes = new ArrayList<>();
        List<Medico> medicos = new ArrayList<>();

        medicos.add(new Medico("Dr. House"));
        medicos.add(new Medico("Dra. Grey"));
        pacientes.add(new Paciente("Brayan Alves"));

        int opcao = 0;

        while (opcao != 5) {
            System.out.println("\n=== Sistema de Hospital ===");
            System.out.println("1. Registrar nova Consulta (Gera Prontuário automaticamente)");
            System.out.println("2. Listar consultas de um paciente");
            System.out.println("3. Mostrar médico responsável de uma consulta");
            System.out.println("4. Mostrar histórico de prontuários de um paciente");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            
            try {
                opcao = Integer.parseInt(LER.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida!");
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.println("Selecione o Paciente:");
                    for (int i = 0; i < pacientes.size(); i++) {
                        System.out.println(i + " - " + pacientes.get(i).getNome());
                    }
                    int pIndex = Integer.parseInt(LER.nextLine());
                    Paciente pacienteSelecionado = pacientes.get(pIndex);
                    System.out.println("Selecione o Médico responsável:");
                    for (int i = 0; i < medicos.size(); i++) {
                        System.out.println(i + " - " + medicos.get(i).getNome());
                    }
                    int mIndex = Integer.parseInt(LER.nextLine());
                    Medico medicoSelecionado = medicos.get(mIndex);
                    System.out.print("Descreva o diagnóstico inicial para gerar o Prontuário: ");
                    String diag = LER.nextLine();
                    Consulta novaConsulta = new Consulta(medicoSelecionado, diag);
                    pacienteSelecionado.adicionarConsulta(novaConsulta);
                    System.out.println("Consulta registrada e Prontuário criado com sucesso!");
                    break;
                case 2:
                    System.out.println("Selecione o Paciente:");
                    for (int i = 0; i < pacientes.size(); i++) {
                        System.out.println(i + " - " + pacientes.get(i).getNome());
                    }
                    int pacIndex = Integer.parseInt(LER.nextLine());
                    Paciente p = pacientes.get(pacIndex);
                    System.out.println("\n--- Consultas de " + p.getNome() + " ---");
                    if (p.getConsultas().isEmpty()) {
                        System.out.println("Nenhuma consulta registrada.");
                    } else {
                        for (int i = 0; i < p.getConsultas().size(); i++) {
                            Consulta c = p.getConsultas().get(i);
                            System.out.println("Consulta " + (i + 1) + " | Médico: " + c.getMedicoResponsavel().getNome());
                        }
                    }
                    break;
                case 3:
                    System.out.println("Selecione o Paciente:");
                    for (int i = 0; i < pacientes.size(); i++) {
                        System.out.println(i + " - " + pacientes.get(i).getNome());
                    }
                    Paciente pct = pacientes.get(Integer.parseInt(LER.nextLine()));
                    if (pct.getConsultas().isEmpty()) {
                        System.out.println("Este paciente não tem consultas.");
                        break;
                    }
                    System.out.println("Selecione a Consulta:");
                    for (int i = 0; i < pct.getConsultas().size(); i++) {
                        System.out.println(i + " - Consulta " + (i + 1));
                    }
                    Consulta consultaSelecionada = pct.getConsultas().get(Integer.parseInt(LER.nextLine()));
                    System.out.println("\nO Médico responsável por esta consulta é: " + consultaSelecionada.getMedicoResponsavel().getNome());
                    break;
                case 4:
                    System.out.println("Selecione o Paciente para ver o histórico de Prontuários:");
                    for (int i = 0; i < pacientes.size(); i++) {
                        System.out.println(i + " - " + pacientes.get(i).getNome());
                    }
                    Paciente p2 = pacientes.get(Integer.parseInt(LER.nextLine()));
                    System.out.println("\n--- Histórico de Prontuários: " + p2.getNome() + " ---");
                    if (p2.getConsultas().isEmpty()) {
                        System.out.println("Nenhum prontuário encontrado.");
                    } else {
                        for (int i = 0; i < p2.getConsultas().size(); i++) {
                            Consulta c = p2.getConsultas().get(i);
                            System.out.println("Prontuário da Consulta " + (i + 1) + " (Dr. " + c.getMedicoResponsavel().getNome() + "):");
                            System.out.println("Diagnóstico: " + c.getProntuario().getDescricao() + "\n");
                        }
                    }
                    break;
                case 5:
                    System.out.println("Saindo do sistema do Hospital...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
        LER.close();
    }
}