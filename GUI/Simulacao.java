import java.util.List;
import java.util.Set;
/**
 * Responsavel pela simulacao.
 * @author David J. Barnes and Michael Kolling and Luiz Merschmann
 */
public class Simulacao {
    private Jogador jogador;
    private JanelaSimulacao janelaSimulacao;
    private PlantaCasa planta;
    private Mapa mapa;
    private HeuristicaAEstrela heuristica;

    public Simulacao(){
        planta = new PlantaCasa();
        mapa = new Mapa(planta);
        heuristica = new HeuristicaAEstrela(mapa);
        jogador = new Jogador();//Cria jogador
        janelaSimulacao = new JanelaSimulacao(mapa);
    }

    /**
     * @return nomes dos comodos que podem ser usados como origem e destino.
     */
    public Set<String> getNomesComodos() {
        return planta.getNomesComodos();
    }

    /**
     * Move o jogador entre dois comodos informados pelo nome.
     */
    public void executarSimulacao(String origem, String destino) {
        janelaSimulacao.mostrarMensagem(origem + " → " + destino);
        executarSimulacao(planta.getPosicaoComodo(origem), planta.getPosicaoComodo(destino));
    }

    public void executarSimulacao(Posicao origem, Posicao destino){
        jogador.moverPara(origem);//Coloca o jogador na origem
        mapa.adicionarJogador(jogador);//Inicializando o mapa com o jogador
        janelaSimulacao.atualizar();
        List<Posicao> caminho = heuristica.encontrarCaminho(origem, destino);
        if (caminho != null) {
            for (int i = 0; i < caminho.size(); i++) {
                executarUmPasso(caminho.get(i));
                esperar(100);
            }
            mapa.removerJogador();
            janelaSimulacao.mostrarMensagem("Movimentação concluída.");
        }else{
            janelaSimulacao.mostrarMensagem("Não foi possível encontrar um caminho para o destino.");
        }
    }

    private void executarUmPasso(Posicao proximaPosicao) {
        jogador.moverPara(proximaPosicao);
        janelaSimulacao.atualizar();
    }

    private void esperar(int milisegundos){
        try{
            Thread.sleep(milisegundos);
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

}
