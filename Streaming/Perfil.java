import java.util.LinkedList;
import java.util.List;

public class Perfil {
    private String nome;
    private List<Conteudo> assistidos;

    public Perfil(String nome) {
        this.nome = nome;
        this.assistidos = new LinkedList<Conteudo>();
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void assistirConteudo(Conteudo s){
        this.assistidos.add(s);
    }
    public List<Conteudo> getAssistidos() {
        return assistidos;
    }
    public void setAssistidos(List<Conteudo> assistidos) {
        this.assistidos = assistidos;
    }
}
