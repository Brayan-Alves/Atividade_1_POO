package Jogo;

import java.util.LinkedList;
import java.util.List;

public class Guilda {
    private String nome;
    private List<Personagem> membros;

    public Guilda(String nome) {
        this.nome = nome;
        this.membros = new LinkedList<Personagem>();
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public List<Personagem> getMembros() {
        return membros;
    }
    public void setMembros(List<Personagem> membros) {
        this.membros = membros;
    }
    public void adicionarMembro(Personagem p){
        this.membros.add(p);
    }
}
