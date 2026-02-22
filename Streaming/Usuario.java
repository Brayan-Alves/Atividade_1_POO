import java.util.LinkedList;
import java.util.List;

public class Usuario {
    private String nome;
    private List<Perfil> perfis;
    
    public Usuario(String nome) {
        this.nome = nome;
        this.perfis = new LinkedList<>();
    }

    public List<Perfil> getPerfis() {
        return perfis;
    }
    public void setPerfis(List<Perfil> perfis) {
        this.perfis = perfis;
    }
    public void ligarPerfil(Perfil perfil){
        this.perfis.add(perfil);
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void adicionarPerfil(Perfil p){
        this.perfis.add(p);
    }
}
