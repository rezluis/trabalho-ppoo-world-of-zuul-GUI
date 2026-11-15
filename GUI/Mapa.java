/**
 * Representa um mapa com todos os itens que participam da simulacao
 * @author David J. Barnes and Michael Kolling and Luiz Merschmann
 */
public class Mapa {
    private ItemMapa[][] cenario;
    private Jogador jogador;
    private int largura;
    private int altura;

    /**
     * Cria o mapa a partir de uma planta: o tamanho e os itens vem dela.
     * @param planta descricao da casa a ser carregada.
     */
    public Mapa(PlantaCasa planta) {
        largura = planta.getLargura();
        altura = planta.getAltura();
        cenario = new ItemMapa[largura][altura];
        for (int x = 0; x < largura; x++) {
            for (int y = 0; y < altura; y++) {
                cenario[x][y] = planta.criarItem(x, y);
            }
        }
    }

    public void adicionarJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public void removerJogador() {
        this.jogador = null;
    }

    public Jogador getJogador() {
        return jogador;
    }

    /**
     * @return o item do cenario na posicao (x, y), ou null se ela estiver vazia.
     */
    public ItemMapa getItem(int x, int y){
        return cenario[x][y];
    }

    public int getLargura() {
        return largura;
    }

    public int getAltura() {
        return altura;
    }

    public boolean podePassar(int x, int y) {
        return estaDentro(x, y) && !temObstaculo(x, y);
    }

    private boolean temObstaculo(int x, int y) {
        ItemMapa itemMapa = cenario[x][y];
        return itemMapa != null && itemMapa.bloqueiaPassagem();
    }
    public boolean estaDentro(int x, int y) {
        return x >= 0 && x < largura
            && y >= 0 && y < altura;
    }

}
