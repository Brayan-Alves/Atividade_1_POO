import java.util.LinkedList;
import java.util.List;

public class Filme extends Conteudo{
    private Pessoa diretor;
    private List<Pessoa> elenco;

    public Filme(String titulo, Pessoa diretor) {
        super(titulo);
        this.diretor = diretor;
        this.elenco = new LinkedList<Pessoa>();
    }

    public Pessoa getDiretor() {
        return diretor;
    }
    public void setDiretor(Pessoa diretor) {
        this.diretor = diretor;
    }
    public List<Pessoa> getElenco() {
        return elenco;
    }
    public void setElenco(List<Pessoa> elenco) {
        this.elenco = elenco;
    }
    public void escalarAtor(Pessoa ator){
        this.elenco.add(ator);
    }
    
}