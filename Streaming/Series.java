import java.util.List;
import java.util.LinkedList;


public class Series{
    private String nome;
    private List<Episodio> episodios;
    private List<Ator> elenco;

    public Series() {
        this.episodios = new LinkedList<Episodio>();
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public List<Episodio> getEpisodios() {
        return episodios;
    }
    public void setEpisodios(List<Episodio> episodios) {
        this.episodios = episodios;
    }
    public void escalarAtor(Ator ator){
        this.elenco.add(ator);
    }
    public List<Ator> getElenco() {
        return elenco;
    }
    public void setElenco(List<Ator> elenco) {
        this.elenco = elenco;
    }
    
}