import java.util.List;

public class Main {
    public static void main(String[] args) {
        SistemaVotacion sistemaVotacion = new SistemaVotacion(
                List.of("Cantidato 1", "Candidato 2", "Candidato 3"),
                List.of("Votador 1", "Votador 2", "Votador 3"));

        sistemaVotacion.registrarVotantes("Votador 4", "123456");
        sistemaVotacion.registrarVotantes("Votador 5", "123456");
        sistemaVotacion.registrarVotantes("Votador 6", "123456");

        sistemaVotacion.agregarCandidato("Candidato 4");

        sistemaVotacion.realizarVoto("Votador 4", "Candidato 3");
        sistemaVotacion.realizarVoto("Votador 2", "Candidato 2");
        sistemaVotacion.realizarVoto("Votador 3", "Candidato 4");

       
        sistemaVotacion.realizarVoto("Votador 3", "Candidato 4");
        sistemaVotacion.contarVotos();
    }
}
