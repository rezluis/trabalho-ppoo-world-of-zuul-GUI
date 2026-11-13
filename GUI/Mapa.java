import java.util.List;

/**
 * Representa um mapa com todos os itens que participam da simulacao
 * @author David J. Barnes and Michael Kolling and Luiz Merschmann
 */
public class Mapa {
    private ItemMapa[][] cenario;
    private Jogador jogador;
    private int largura;
    private int altura;

    private static final String[] PLANTA = {
        "####################",  // y = 0
        "#      #    #      #",  // y = 1
        "#QUARTO1 C  QUARTO2#",  // y = 2
        "#      # O  #      #",  // y = 3
        "######## R  ########",  // y = 4
        "#      # R  #      #",  // y = 5
        "# WC1    E    WC2  #",  // y = 6
        "#      # D  #      #",  // y = 7
        "######## O  ########",  // y = 8
        "# SALA # R  #      #",  // y = 9
        "#JANTAR     COZINHA#",  // y = 10
        "#      #    #      #",  // y = 11
        "##     ######     ##",  // y = 12
        "#        #    AREA #",  // y = 13
        "#SALA TV #  SERVIÇO#",  // y = 14
        "#        #         #",  // y = 15
        "####################",   // y = 16
    };
    
    /**
     * Cria mapa para alocar itens da simulacao.
     * @param largura: largura da área de simulacao.
     * @param altura: altura da área de simulação.
     */
    public Mapa() {
        largura = PLANTA[0].length(); 
        altura = PLANTA.length;
        cenario = new ItemMapa[largura][altura];
        carregarPlanta();
    }

    private void carregarPlanta() {
        for (int y = 0; y < PLANTA.length; y++) {
            for (int x = 0; x < PLANTA[y].length(); x++) {
                char c = PLANTA[y].charAt(x);
                if (c == '#') {
                    cenario[x][y] = new Parede(new Posicao(x, y));
                } else if ( c != ' ') {
                    cenario[x][y] = new Letra(new Posicao(x, y), c);
                }
            }
        }
    }

    /**
     * Cria mapa com tamanho padrao.
     */
    
    public void adicionarJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public void removerJogador() {
        this.jogador = null;
    }

    public Jogador getJogador() {
        return jogador;
    }
    
    public ItemMapa getCenario(int x, int y){
        return cenario[x][y];
    }

    public int getLargura() {
        return largura;
    }

    public int getAltura() {
        return altura;
    }

    public boolean podePassar(int x, int y) {
        return estaDentro(x, y) && !temParede(x, y);
    }

    private boolean temParede(int x, int y) {
        ItemMapa itemMapa = cenario[x][y];
        return itemMapa != null && itemMapa.bloqueiaPassagem();
    }
    public boolean estaDentro(int x, int y) {
        return x >= 0 && x < largura
            && y >= 0 && y < altura;
    }

    public List<Posicao> encontrarCaminho(
            Posicao origem,
            Posicao destino) {

        HeuristicaAEstrela heuristica =
            new HeuristicaAEstrela(this);

        return heuristica.encontrarCaminho(
            origem,
            destino
        );
    }
    
}
