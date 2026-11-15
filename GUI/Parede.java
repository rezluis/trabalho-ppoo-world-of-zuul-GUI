/**
 * Representa uma parede do mapa, que bloqueia a passagem.
 * @author David J. Barnes and Michael Kolling and Luiz Merschmann
 */
public class Parede extends ItemMapa{

    /** Simbolo da parede, usado tambem no desenho da PlantaCasa. */
    public static final char SIMBOLO = '#';

    public Parede(Posicao posicao) {
        super(posicao);
    }

    @Override
    public boolean bloqueiaPassagem() {
        return true;
    }

    @Override
    public char getSimbolo() {
        return SIMBOLO;
    }

}
