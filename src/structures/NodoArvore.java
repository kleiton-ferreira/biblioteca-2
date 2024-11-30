package structures;

import entities.Livro;

public class NodoArvore {
    private Livro livro;
    private NodoArvore esquerdo;
    private NodoArvore direito;

    public NodoArvore(Livro livro) {
        this.livro = livro;
        this.esquerdo = null;
        this.direito = null;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public NodoArvore getEsquerdo() {
        return esquerdo;
    }

    public void setEsquerdo(NodoArvore esquerdo) {
        this.esquerdo = esquerdo;
    }

    public NodoArvore getDireito() {
        return direito;
    }

    public void setDireito(NodoArvore direito) {
        this.direito = direito;
    }
}
