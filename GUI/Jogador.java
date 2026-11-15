/**
 * Representa o jogador
 * @author David J. Barnes and Michael Kolling and Luiz Merschmann
 */
public class Jogador extends ItemMapa{

    public static final char SIMBOLO = '@';

    /**
     * Cria o jogador ainda fora do mapa; a posicao e definida por moverPara.
     */
    public Jogador(){
        super(null);
    }

    /**
     * Coloca o jogador na posicao informada: a origem do trajeto
     * ou o proximo passo do caminho.
     * @param novaPosicao posicao para onde o jogador vai.
     */
    public void moverPara(Posicao novaPosicao) {
        setPosicao(novaPosicao);
    }

    @Override
    public boolean bloqueiaPassagem() {
        return false;
    }

    @Override
    public char getSimbolo() {
        return SIMBOLO;
    }
}
