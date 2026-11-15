/**
 *
 * @author Luiz Merschmann
 */
public class Principal {

    public static void main(String[] args) {
        Simulacao sim = new Simulacao();

        for(String origem: sim.getNomesComodos()){
            for(String destino: sim.getNomesComodos()){
                if(!origem.equals(destino)){
                    System.out.println("Origem: " + origem + "\tDestino: " + destino);
                    System.out.println("Procurando o caminho ...");
                    sim.executarSimulacao(origem, destino);
                }
            }
        }
        System.out.println("Simulação concluída.");

    }
}
