package Hospital;

import java.util.LinkedList;
import java.util.List;

public class Paciente{
    private String nome;
    private List<Consulta> consultas;

    
    public Paciente(String nome) {
        this.nome = nome;
        this.consultas = new LinkedList<Consulta>();
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public List<Consulta> getConsultas() {
        return consultas;
    }
    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }
    public void adicionarConsulta(Consulta c){
        this.consultas.add(c);
    }
}