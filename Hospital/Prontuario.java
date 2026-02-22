package Hospital;

public class Prontuario {
    private String descricao;

    public Prontuario(String diagnostico) {
        this.descricao = diagnostico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String diagnostico) {
        this.descricao = diagnostico;
    }
}
