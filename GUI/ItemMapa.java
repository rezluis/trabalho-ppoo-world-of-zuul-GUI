import java.awt.Image;

public abstract class ItemMapa {
    
    protected Posicao posicaoOrigem;
    protected Image imagem;

    public ItemMapa(Posicao posicaoOrigem) {
        this.posicaoOrigem = posicaoOrigem;
        
    }

    public Posicao getPosicaoOrigem() {
        return posicaoOrigem;
    }

    public Image getImagem() {
        return imagem;
    }

    public abstract boolean bloqueiaPassagem();

    
}
