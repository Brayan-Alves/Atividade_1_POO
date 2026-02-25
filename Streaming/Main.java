import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner LER = new Scanner(System.in);
    public static void main(String[] args) {

        List<Usuario> usuarios = new ArrayList<>();
        List<Perfil> todosPerfis = new ArrayList<>();
        List<Filme> catalogoFilmes = new ArrayList<>();
        List<Conteudo> catalogoGeral = new ArrayList<>();

        Usuario u1 = new Usuario("Ana Costa");
        usuarios.add(u1);

        Perfil p1 = new Perfil("Ana - Principal");
        Perfil p2 = new Perfil("Ana - Kids");
        u1.adicionarPerfil(p1);
        u1.adicionarPerfil(p2);
        todosPerfis.add(p1);
        todosPerfis.add(p2);

        Pessoa diretor1 = new Pessoa("Christopher Nolan");
        Filme f1 = new Filme("Interestelar", diretor1);
        f1.escalarAtor(new Pessoa("Matthew McConaughey"));
        f1.escalarAtor(new Pessoa("Anne Hathaway"));
        catalogoFilmes.add(f1);
        catalogoGeral.add(f1);

        Serie s1 = new Serie("Stranger Things");
        catalogoGeral.add(s1);

        p1.assistirConteudo(f1);
        p1.assistirConteudo(s1);

        int opcao = 0;

        while (opcao != 5) {
            System.out.println("\n=== Plataforma de Streaming ===");
            System.out.println("1. Mostrar perfis de um usuário");
            System.out.println("2. Mostrar conteúdos assistidos por um perfil");
            System.out.println("3. Mostrar elenco de um filme");
            System.out.println("4. Simular perfil assistindo a um conteúdo");
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
                    System.out.println("Selecione o Usuário:");
                    for (int i = 0; i < usuarios.size(); i++) {
                        System.out.println(i + " - " + usuarios.get(i).getNome());
                    }
                    int uIndex = Integer.parseInt(LER.nextLine());
                    Usuario u = usuarios.get(uIndex);
                    System.out.println("\n--- Perfis da conta de " + u.getNome() + " ---");
                    if (u.getPerfis().isEmpty()) {
                        System.out.println("Nenhum perfil cadastrado.");
                    } else {
                        for (Perfil perfil : u.getPerfis()) {
                            System.out.println("- " + perfil.getNome());
                        }
                    }
                    break;
                case 2:
                    System.out.println("Selecione o Perfil:");
                    for (int i = 0; i < todosPerfis.size(); i++) {
                        System.out.println(i + " - " + todosPerfis.get(i).getNome());
                    }
                    int pIndex = Integer.parseInt(LER.nextLine());
                    Perfil perfilSelecionado = todosPerfis.get(pIndex);
                    System.out.println("\n--- Histórico de " + perfilSelecionado.getNome() + " ---");
                    if (perfilSelecionado.getAssistidos().isEmpty()) {
                        System.out.println("Este perfil ainda não assistiu a nenhum conteúdo.");
                    } else {
                        for (Conteudo c : perfilSelecionado.getAssistidos()) {
                            String tipo = (c instanceof Filme) ? "[Filme]" : "[Série]";
                            System.out.println(tipo + " " + c.getTitulo());
                        }
                    }
                    break;
                case 3:
                    if (catalogoFilmes.isEmpty()) {
                        System.out.println("Nenhum filme cadastrado.");
                        break;
                    }
                    System.out.println("Selecione o Filme:");
                    for (int i = 0; i < catalogoFilmes.size(); i++) {
                        System.out.println(i + " - " + catalogoFilmes.get(i).getTitulo());
                    }
                    int fIndex = Integer.parseInt(LER.nextLine());
                    Filme filmeSelecionado = catalogoFilmes.get(fIndex);
                    System.out.println("\n--- Ficha Técnica: " + filmeSelecionado.getTitulo() + " ---");
                    System.out.println("Diretor: " + filmeSelecionado.getDiretor().getNome());
                    System.out.println("Elenco:");
                    if (filmeSelecionado.getElenco().isEmpty()) {
                        System.out.println("  (Nenhum ator cadastrado)");
                    } else {
                        for (Pessoa ator : filmeSelecionado.getElenco()) {
                            System.out.println("  - " + ator.getNome());
                        }
                    }
                    break;
                case 4:
                    System.out.println("Quem está assistindo? (Selecione o Perfil):");
                    for (int i = 0; i < todosPerfis.size(); i++) {
                        System.out.println(i + " - " + todosPerfis.get(i).getNome());
                    }
                    Perfil pAssistindo = todosPerfis.get(Integer.parseInt(LER.nextLine()));
                    System.out.println("O que deseja assistir?");
                    for (int i = 0; i < catalogoGeral.size(); i++) {
                        System.out.println(i + " - " + catalogoGeral.get(i).getTitulo());
                    }
                    Conteudo cAssistido = catalogoGeral.get(Integer.parseInt(LER.nextLine()));
                    pAssistindo.assistirConteudo(cAssistido);
                    System.out.println(pAssistindo.getNome() + " acabou de assistir " + cAssistido.getTitulo() + "!");
                    break;
                case 5:
                    System.out.println("Encerrando a plataforma...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}