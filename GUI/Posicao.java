import java.util.Objects;

/**
 * Representa uma localização no mapa
 * @author David J. Barnes and Michael Kolling and Luiz Merschmann
 */
public class Posicao {
    private int x;
    private int y;

    /**
     * Cria uma posicao no mapa.
     * @param x Coordenada x: deve ser maior ou igual a 0.
     * @param y Coordenada y: deve ser maior ou igual a 0.
     */
    public Posicao(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * Verificacao de igualdade de conteudo de objetos do tipo Posicao.
     * @return true: se a posicao é igual.
     *         false: caso contrario.
     */
    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }else if(!(obj instanceof Posicao)){
            return false;
        }else{
            Posicao outro = (Posicao) obj;
            return x == outro.x && y == outro.y;
        }
    }

    /**
     * Codigo hash coerente com o equals: posicoes iguais geram o mesmo valor.
     * Necessario para usar Posicao em HashSet e HashMap (ex.: HeuristicaAEstrela).
     * @return Codigo hash calculado a partir de x e y.
     */
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    /**
     * @return A representacao da posicao.
     */
    @Override
    public String toString()
    {
        return "(" + x + ", " + y + ")";
    }
    
    
}
