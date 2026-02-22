package Hospital;

public class Main {
    public static void main(String[] args) {
        Medico m = new Medico("Dr. Lucas");
        Paciente p = new Paciente("Brayan");

        Consulta c1 = new Consulta(m);
        Prontuario pront1 = new Prontuario("Dor de cabeça");
        c1.setProntuario(pront1);

        p.adicionarConsulta(c1);

        System.out.println("Consultas do Paciente: ");
        int cont = 1;
        for (Consulta c : p.getConsultas()) {
            System.out.printf("%d. Médico: %s | Prontuário: %s",cont , c.getMedicoResponsavel().getNome(), c.getProntuario().getDescricao());
            cont++;
        }
    }
}
