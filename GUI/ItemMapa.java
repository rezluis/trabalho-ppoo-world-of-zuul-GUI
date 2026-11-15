/**
 * Representa um elemento que ocupa uma posicao no mapa.
 * Nao conhece imagens: a interface grafica decide como desenha-lo
 * a partir do simbolo informado por getSimbolo().
 */
public abstract class ItemMapa {

    private Posicao posicao;

    /**
     * @param posicao posicao do item no mapa.
     */
    protected ItemMapa(Posicao posicao) {
        this.posicao = posicao;
    }

    public Posicao getPosicao() {
        return posicao;
    }

    /**
     * Altera a posicao do item. Restrito as subclasses que se movem (ex.: Jogador).
     */
    protected void setPosicao(Posicao posicao) {
        this.posicao = posicao;
    }

    public abstract boolean bloqueiaPassagem();

    /**
     * Caractere que identifica o item. Obrigatorio em toda subclasse,
     * para que nenhum item fique sem representacao na tela.
     * @return simbolo do item.
     */
    public abstract char getSimbolo();

}
