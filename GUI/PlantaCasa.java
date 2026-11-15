import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Descreve a casa da simulacao: o desenho de paredes e letreiros e o
 * ponto de referencia de cada comodo. Para trocar de casa, muda-se a
 * planta; o Mapa nao precisa ser alterado.
 */
public class PlantaCasa {

    private static final char VAZIO = ' ';

    /** '#' = parede, espaco = vazio, qualquer outro caractere = letra do letreiro. */
    private static final String[] DESENHO = {
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
        "####################",  // y = 16
    };

    private final Map<String, Posicao> comodos = new LinkedHashMap<>();

    public PlantaCasa() {
        validarDesenho();
        adicionarComodo("Quarto 1", 4, 2);
        adicionarComodo("Quarto 2", 16, 2);
        adicionarComodo("WC 1", 4, 6);
        adicionarComodo("WC 2", 16, 6);
        adicionarComodo("Sala de Jantar", 4, 10);
        adicionarComodo("Cozinha", 16, 10);
        adicionarComodo("Sala de TV", 4, 14);
        adicionarComodo("Área de Serviço", 16, 14);
        adicionarComodo("Corredor", 9, 6);
    }

    public int getLargura() {
        return DESENHO[0].length();
    }

    public int getAltura() {
        return DESENHO.length;
    }

    /**
     * Cria o item correspondente a uma posicao do desenho.
     * @return uma Parede, uma Letra ou null se a posicao estiver vazia.
     */
    public ItemMapa criarItem(int x, int y) {
        char c = DESENHO[y].charAt(x);
        if (c == Parede.SIMBOLO) {
            return new Parede(new Posicao(x, y));
        } else if (c != VAZIO) {
            return new Letra(new Posicao(x, y), c);
        }
        return null;
    }

    /**
     * @return nomes dos comodos, na ordem em que foram cadastrados (somente leitura).
     */
    public Set<String> getNomesComodos() {
        return Collections.unmodifiableSet(comodos.keySet());
    }

    /**
     * @param nome nome do comodo.
     * @return posicao de referencia do comodo.
     */
    public Posicao getPosicaoComodo(String nome) {
        Posicao posicao = comodos.get(nome);
        if (posicao == null) {
            throw new IllegalArgumentException("Comodo desconhecido: " + nome);
        }
        return posicao;
    }

    /**
     * Todas as linhas precisam ter o mesmo tamanho; senao o mapa fica torto.
     */
    private void validarDesenho() {
        for (int y = 0; y < DESENHO.length; y++) {
            if (DESENHO[y].length() != getLargura()) {
                throw new IllegalStateException("A linha " + y + " da planta tem "
                    + DESENHO[y].length() + " caracteres; o esperado e " + getLargura() + ".");
            }
        }
    }

    /**
     * Registra um comodo, conferindo se o ponto de referencia esta dentro
     * da planta e nao cai numa parede. Se a planta mudar e uma referencia
     * ficar invalida, o erro aparece ao criar a planta.
     */
    private void adicionarComodo(String nome, int x, int y) {
        boolean dentro = x >= 0 && x < getLargura() && y >= 0 && y < getAltura();
        ItemMapa item = dentro ? criarItem(x, y) : null;
        if (!dentro || (item != null && item.bloqueiaPassagem())) {
            throw new IllegalStateException("O comodo \"" + nome + "\" aponta para (" + x + ", " + y
                + "), que esta fora da planta ou numa parede.");
        }
        comodos.put(nome, new Posicao(x, y));
    }
}
