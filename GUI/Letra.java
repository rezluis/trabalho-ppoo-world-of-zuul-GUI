/**
 * Representa uma letra dos letreiros dos comodos. Nao bloqueia a passagem.
 */
public class Letra extends ItemMapa{

    private final char letra;

    public Letra(Posicao posicao, char letra) {
        super(posicao);
        this.letra = letra;
    }

    @Override
    public boolean bloqueiaPassagem() {
        return false;
    }

    @Override
    public char getSimbolo() {
        return letra;
    }

}
