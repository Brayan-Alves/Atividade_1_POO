package Ecommerce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner LER = new Scanner(System.in);
    public static void main(String[] args) {

        List<Cliente> clientes = new ArrayList<>();
        List<Fornecedor> fornecedores = new ArrayList<>();
        List<Produto> produtos = new ArrayList<>();
        List<Pedido> pedidos = new ArrayList<>();

        Fornecedor f1 = new Fornecedor("Techinfo");
        fornecedores.add(f1);
        produtos.add(new Produto("Notebook", f1));
        produtos.add(new Produto("Mouse", f1));

        Cliente c1 = new Cliente("Brayan Alves");
        clientes.add(c1);

        int opcao = 0;

        while (opcao != 6) {
            System.out.println("\n=== Sistema de E-commerce ===");
            System.out.println("1. Realizar um novo Pedido");
            System.out.println("2. Exibir pedidos de um cliente");
            System.out.println("3. Exibir produtos de um pedido");
            System.out.println("4. Exibir fornecedor de um produto");
            System.out.println("5. Cadastrar novo Cliente (Atalho)");
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
                    if (clientes.isEmpty() || produtos.isEmpty()) {
                        System.out.println("Você precisa de clientes e produtos cadastrados primeiro.");
                        break;
                    }
                    System.out.println("Selecione o Cliente:");
                    for (int i = 0; i < clientes.size(); i++) {
                        System.out.println(i + " - " + clientes.get(i).getNome());
                    }
                    int cliIndex = Integer.parseInt(LER.nextLine());
                    Cliente cliSelecionado = clientes.get(cliIndex);
                    System.out.print("Digite o código da nova Nota Fiscal: ");
                    String idNf = LER.nextLine();
                    Pedido novoPedido = new Pedido(cliSelecionado, idNf);
                    boolean addMais = true;
                    while (addMais) {
                        System.out.println("Selecione um Produto para adicionar:");
                        for (int i = 0; i < produtos.size(); i++) {
                            System.out.println(i + " - " + produtos.get(i).getNome());
                        }
                        int prodIndex = Integer.parseInt(LER.nextLine());
                        novoPedido.adicionarProdutos(produtos.get(prodIndex));
                        System.out.print("Adicionar mais produtos? (s/n): ");
                        String resp = LER.nextLine();
                        if (resp.equalsIgnoreCase("n")) {
                            addMais = false;
                        }
                    }
                    pedidos.add(novoPedido);
                    cliSelecionado.adicionarPedido(novoPedido);
                    System.out.println("Pedido realizado com sucesso!");
                    break;
                case 2:
                    System.out.println("Selecione o Cliente para ver o histórico:");
                    for (int i = 0; i < clientes.size(); i++) {
                        System.out.println(i + " - " + clientes.get(i).getNome());
                    }
                    int cIndex = Integer.parseInt(LER.nextLine());
                    Cliente c = clientes.get(cIndex);
                    System.out.println("\n--- Histórico de " + c.getNome() + " ---");
                    if (c.getPedidos().isEmpty()) {
                        System.out.println("Nenhum pedido encontrado.");
                    } else {
                        for (Pedido p : c.getPedidos()) {
                            System.out.println("Pedido [NF: " + p.getNotaFiscal().getId() + "] - Total de Produtos: " + p.getProdutos().size());
                        }
                    }
                    break;
                case 3:
                    if (pedidos.isEmpty()) {
                        System.out.println("Nenhum pedido cadastrado no sistema.");
                        break;
                    }
                    System.out.println("Selecione o Pedido (por ID da NF):");
                    for (int i = 0; i < pedidos.size(); i++) {
                        System.out.println(i + " - Nota Fiscal: " + pedidos.get(i).getNotaFiscal().getId());
                    }
                    int pIndex = Integer.parseInt(LER.nextLine());
                    Pedido ped = pedidos.get(pIndex);
                    System.out.println("\n--- Produtos do Pedido [NF: " + ped.getNotaFiscal().getId() + "] ---");
                    for (Produto prod : ped.getProdutos()) {
                        System.out.println("- " + prod.getNome());
                    }
                    break;
                case 4:
                    System.out.println("Selecione o Produto para ver o fornecedor:");
                    for (int i = 0; i < produtos.size(); i++) {
                        System.out.println(i + " - " + produtos.get(i).getNome());
                    }
                    int prIndex = Integer.parseInt(LER.nextLine());
                    Produto produtoSelecionado = produtos.get(prIndex);
                    System.out.println("\nO fornecedor do produto '" + produtoSelecionado.getNome() +
                            "' é: " + produtoSelecionado.getFornecedor().getNome());
                    break;
                case 5:
                    System.out.print("Digite o nome do novo Cliente: ");
                    clientes.add(new Cliente(LER.nextLine()));
                    System.out.println("Cliente adicionado.");
                    break;
                case 6:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}