import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Representa os veiculos da simulacao.
 * @author David J. Barnes and Michael Kolling and Luiz Merschmann
 */
public class Parede extends ItemMapa{

    public Parede(Posicao posicao) {
        super(posicao);
        imagem = new ImageIcon(getClass().getResource("/Imagens/tijolo.png")).getImage();
    }

    public Posicao getPosicaoOrigem() {
        return posicaoOrigem;
    }

    public Image getImagem(){
        return imagem;
    }

    @Override
    public boolean bloqueiaPassagem() {
        return true;
    }

}
