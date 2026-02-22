package Hospital;

public class Consulta {
    private Medico medicoResponsavel;
    private Prontuario prontuario;

    public Consulta(Medico medicoResponsavel) {
        this.medicoResponsavel = medicoResponsavel;
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
