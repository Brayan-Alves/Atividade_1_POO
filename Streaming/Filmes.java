import java.util.LinkedList;

public class Filmes{
    private String nome;
    private int duracaoMin;
    private LinkedList<Ator> Elenco;

    public Filmes() {
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getDuracaoMin() {
        return duracaoMin;
    }
    public void setDuracaoMin(int duracaoMin) {
        this.duracaoMin = duracaoMin;
    }
    public LinkedList<Ator> getElenco() {
        return Elenco;
    }
    public void setElenco(LinkedList<Ator> elenco) {
        Elenco = elenco;
    }
}