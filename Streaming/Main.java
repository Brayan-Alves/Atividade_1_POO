public class Main {
    public static void main(String[] args) {
        Usuario u = new Usuario("Brayan");

        Perfil p1 = new Perfil("perfilA");
        Perfil p2 = new Perfil("perfilB");

        u.adicionarPerfil(p1);
        u.adicionarPerfil(p2);

        Pessoa diretor = new Pessoa("Lucas");
        Pessoa ator1 = new Pessoa("Gabriel");

        Filme f = new Filme("Cidade de Deus", diretor);
        f.escalarAtor(ator1);

        p2.assistirConteudo(f);

        System.out.println("Perfis do usuário:");
        int cont = 1;
        for (Perfil p : u.getPerfis()) {
            System.out.printf("%d. %s\n",cont, p.getNome());
            cont++;
        }

        System.out.printf("\nConteúdos assistidos:");
        cont = 1;
        for (Conteudo c : u.getPerfis().get(1).getAssistidos()) {
            System.out.printf("\n%d. %s\n",cont, c.getTitulo());
        }

        System.out.printf("\nElenco do filme:");
        cont = 1;
        for (Pessoa p : f.getElenco()) {
            System.out.printf("\n%d. %s\n",cont, p.getNome());
        }
    }
}
