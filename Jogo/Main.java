package Jogo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner LER = new Scanner(System.in);
    public static void main(String[] args) {
        
        List<Personagem> todosPersonagens = new ArrayList<>();
        List<Guilda> guildas = new ArrayList<>();

        Jogador j1 = new Jogador("Brayan");
        Personagem p1 = new Personagem("Ledbye");
        j1.adicionarPersonagem(p1);
        todosPersonagens.add(p1);

        Personagem p2 = new Personagem("LedEight");
        todosPersonagens.add(p2);

        p1.adicionarItem(new Item("Espada", true));
        p1.adicionarItem(new Item("Escudo", false));
        p1.adicionarItem(new Item("Poção", true));
        
        p2.adicionarItem(new Item("Cajado", true));

        Guilda g1 = new Guilda("Guilda A");
        g1.adicionarMembro(p1);
        g1.adicionarMembro(p2);
        guildas.add(g1);

        int opcao = 0;

        while (opcao != 5) {
            System.out.println("\n=== Sistema de Jogo Multiplayer ===");
            System.out.println("1. Mostrar inventário do personagem");
            System.out.println("2. Mostrar itens equipados do personagem");
            System.out.println("3. Mostrar membros da guilda");
            System.out.println("4. Equipar um item no personagem");
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
                    System.out.println("Selecione o Personagem:");
                    for (int i = 0; i < todosPersonagens.size(); i++) {
                        System.out.println(i + " - " + todosPersonagens.get(i).getNick());
                    }
                    int pIndex = Integer.parseInt(LER.nextLine());
                    Personagem p = todosPersonagens.get(pIndex);
                    System.out.println("\n--- Inventário de " + p.getNick() + " ---");
                    if (p.getInventario().isEmpty()) {
                        System.out.println("Inventário vazio.");
                    } else {
                        for (Item item : p.getInventario()) {
                            String status = item.isSeEquipado() ? "[Equipado]" : "[Na Mochila]";
                            System.out.println("- " + item.getNome() + " " + status);
                        }
                    }
                    break;
                case 2:
                    System.out.println("Selecione o Personagem:");
                    for (int i = 0; i < todosPersonagens.size(); i++) {
                        System.out.println(i + " - " + todosPersonagens.get(i).getNick());
                    }
                    int pEqIndex = Integer.parseInt(LER.nextLine());
                    Personagem pEquip = todosPersonagens.get(pEqIndex);                 
                    System.out.println("\n--- Itens Equipados de " + pEquip.getNick() + " ---");
                    boolean temEquipado = false;
                    for (Item item : pEquip.getInventario()) {
                        if (item.isSeEquipado()) {
                            System.out.println("- " + item.getNome());
                            temEquipado = true;
                        }
                    }
                    if (!temEquipado) {
                        System.out.println("O personagem não tem nenhum item equipado.");
                    }
                    break;
                case 3:
                    System.out.println("Selecione a Guilda:");
                    for (int i = 0; i < guildas.size(); i++) {
                        System.out.println(i + " - " + guildas.get(i).getNome());
                    }
                    int gIndex = Integer.parseInt(LER.nextLine());
                    Guilda g = guildas.get(gIndex);
                    System.out.println("\n--- Membros da Guilda '" + g.getNome() + "' ---");
                    if (g.getMembros().isEmpty()) {
                        System.out.println("Esta guilda não possui membros.");
                    } else {
                        for (Personagem membro : g.getMembros()) {
                            System.out.println("- " + membro.getNick());
                        }
                    }
                    break;
                
                case 4:
                    System.out.println("Selecione o Personagem:");
                    for (int i = 0; i < todosPersonagens.size(); i++) {
                        System.out.println(i + " - " + todosPersonagens.get(i).getNick());
                    }
                    Personagem pAcao = todosPersonagens.get(Integer.parseInt(LER.nextLine()));
                    System.out.print("Digite o nome exato do item para equipar (ex: Poção de Vida): ");
                    String nomeItem = LER.nextLine();
                    pAcao.equiparItem(nomeItem);
                    System.out.println("Ação concluída. Verifique o inventário para confirmar o status!");
                    break;
                case 5:
                    System.out.println("Saindo do Jogo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}