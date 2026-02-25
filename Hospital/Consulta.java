package Hospital;

public class Consulta {
    private Medico medicoResponsavel;
    private Prontuario prontuario;

    public Consulta(Medico medicoResponsavel, String descricaoProntuario) {
        this.medicoResponsavel = medicoResponsavel;
        this.prontuario = new Prontuario(descricaoProntuario);
    }
    
    public Medico getMedicoResponsavel() {
        return medicoResponsavel;
    }
    public void setMedicoResponsavel(Medico medicoResponsavel) {
        this.medicoResponsavel = medicoResponsavel;
    }
    public Prontuario getProntuario() {
        return prontuario;
    }
    public void setProntuario(Prontuario prontuario) {
        this.prontuario = prontuario;
    }
}
