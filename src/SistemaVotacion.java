import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaVotacion {
    private List<String> listaCandidatos;
    private List<String> votantesRegistrados;
    private Map<String, String> votos;

    public SistemaVotacion(List<String> listaCandidatos, List<String> votantesRegistrados) {
        this.listaCandidatos = new ArrayList<>(listaCandidatos);
        this.votantesRegistrados = new ArrayList<>(votantesRegistrados);
        this.votos = new HashMap<>();

        for (String candidato : listaCandidatos) {
            this.votos.put(candidato, null);
        }
    }

    public void registrarVotantes(String nombre, String clave){
        if (autenticarVotador(nombre, clave)){
            votantesRegistrados.add(nombre);
            System.out.println("Registrado " + nombre);
        } else {
            System.out.println("Error de autenticación");
        }
    }
    public void agregarCandidato(String nombre){
        listaCandidatos.add(nombre);
        System.out.println("Candidato Agregado " + nombre);
    }

    public void realizarVoto(String votante, String candidato) {
        if (votantesRegistrados.contains(votante) && listaCandidatos.contains(candidato) && !haVotado(votante)){
            votos.put(votante, candidato);
            System.out.println("El voto se registro: " + votante + " por: " + candidato);
            System.out.println("¡Gracias por votar, " + votante + "!");
        } else if (haVotado(votante)) {
            System.out.println(votante + ", No puedes votar nuevamente");
        } else {
            System.out.println("No se pudo realizar el voto, verifica tus datos");
        }
    }

    public void contarVotos() {
        Map<String, Integer> conteoVotos = new HashMap<>();

        for (String candidato: listaCandidatos){
            conteoVotos.put(candidato, 0);
        }

        for (String voto: votos.values()){
            if (voto != null) {
                conteoVotos.put(voto, conteoVotos.get(voto) + 1);
            }
        }

        System.out.println("Los resultados son los siguientes: ");
        for (String candidato: listaCandidatos){
            System.out.println(candidato + ": " + conteoVotos.get(candidato) + " Votos");
        }
    }

    public boolean autenticarVotador(String nombre, String claveAutenticacion) {
        return claveAutenticacion.equals("123456");
    }

    public boolean haVotado(String votador) {
        return votos.containsKey(votador) && votos.get(votador) != null;
    }
}
