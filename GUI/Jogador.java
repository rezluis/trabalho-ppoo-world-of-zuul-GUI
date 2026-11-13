import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Representa o jogador
 * @author David J. Barnes and Michael Kolling and Luiz Merschmann
 */
public class Jogador extends ItemMapa{

    private Posicao posicaoDestino;

    public Jogador(){
        super(null);
        posicaoDestino = null;
        imagem = new ImageIcon(getClass().getResource("/Imagens/pessoa.png")).getImage();
    }
    
    public Jogador(Posicao localizacao) {
        super(localizacao);
        posicaoDestino = null;
        imagem = new ImageIcon(getClass().getResource("/Imagens/pessoa.png")).getImage();
    }

    public Posicao getPosicaoOrigem() {
        return posicaoOrigem;
    }

    public Posicao getPosicaoDestino() {
        return posicaoDestino;
    }
    
    public Image getImagem(){
        return imagem;
    }

    public void setPosicaoOrigem(Posicao localizacaoAtual) {
        this.posicaoOrigem = localizacaoAtual;
    }

    public void setPosicaoDestino(Posicao localizacaoDestino) {
        this.posicaoDestino = localizacaoDestino;
    }
    
    public void executarAcao(Posicao proximaLocalizacao) {
        Posicao destino = getPosicaoDestino();
        if(destino != null){
            setPosicaoOrigem(proximaLocalizacao);
        }
    }

    @Override
    public boolean bloqueiaPassagem() {
        return false;
    } 
}
