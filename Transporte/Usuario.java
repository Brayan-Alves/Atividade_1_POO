package Transporte;

import java.util.LinkedList;
import java.util.List;

public class Usuario {
    private String nome;
    private List<Corrida> corridasFeitas;

    public Usuario(String nome) {
        this.nome = nome;
        this.corridasFeitas = new LinkedList<>();
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public List<Corrida> getCorridasFeitas() {
        return corridasFeitas;
    }
    public void setCorridasFeitas(List<Corrida> corridasFeitas) {
        this.corridasFeitas = corridasFeitas;
    }
    public void adicionarCorrida(Corrida c){
        this.corridasFeitas.add(c);
    }
}
