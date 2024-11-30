package structures;

import entities.Livro;

import java.util.ArrayList;
import java.util.List;

public class ArvoreBinariaDeBusca {
    private NodoArvore raiz;

    // Adiciona um livro à árvore
    public void adicionarLivro(Livro livro) {
        raiz = adicionarRecursivo(raiz, livro);
    }

    private NodoArvore adicionarRecursivo(NodoArvore atual, Livro livro) {
        if (atual == null) {
            return new NodoArvore(livro);
        }

        if (livro.getTitulo().compareToIgnoreCase(atual.getLivro().getTitulo()) < 0) {
            atual.setEsquerdo(adicionarRecursivo(atual.getEsquerdo(), livro));
        } else if (livro.getTitulo().compareToIgnoreCase(atual.getLivro().getTitulo()) > 0) {
            atual.setDireito(adicionarRecursivo(atual.getDireito(), livro));
        }
        return atual;
    }

    // Lista todos os livros em ordem alfabética
    public void listarLivros() {
        listarRecursivo(raiz);
    }

    private void listarRecursivo(NodoArvore atual) {
        if (atual != null) {
            listarRecursivo(atual.getEsquerdo());
            System.out.println(atual.getLivro());
            listarRecursivo(atual.getDireito());
        }
    }

    // Busca um livro pelo título
    public Livro buscarPorTitulo(String titulo) {
        return buscarPorTituloRecursivo(raiz, titulo);
    }

    private Livro buscarPorTituloRecursivo(NodoArvore atual, String titulo) {
        if (atual == null) {
            return null;
        }

        if (titulo.equalsIgnoreCase(atual.getLivro().getTitulo())) {
            return atual.getLivro();
        }

        if (titulo.compareToIgnoreCase(atual.getLivro().getTitulo()) < 0) {
            return buscarPorTituloRecursivo(atual.getEsquerdo(), titulo);
        } else {
            return buscarPorTituloRecursivo(atual.getDireito(), titulo);
        }
    }

    // Busca livros de um autor
    public List<Livro> buscarPorAutor(String autor) {
        List<Livro> resultado = new ArrayList<>();
        buscarPorAutorRecursivo(raiz, autor, resultado);
        return resultado;
    }

    private void buscarPorAutorRecursivo(NodoArvore atual, String autor, List<Livro> resultado) {
        if (atual != null) {
            buscarPorAutorRecursivo(atual.getEsquerdo(), autor, resultado);
            if (atual.getLivro().getAutor().equalsIgnoreCase(autor)) {
                resultado.add(atual.getLivro());
            }
            buscarPorAutorRecursivo(atual.getDireito(), autor, resultado);
        }
    }

    // Busca livros por tema (palavra-chave no título)
    public List<Livro> buscarPorTema(String tema) {
        List<Livro> resultado = new ArrayList<>();
        buscarPorTemaRecursivo(raiz, tema, resultado);
        return resultado;
    }

    private void buscarPorTemaRecursivo(NodoArvore atual, String tema, List<Livro> resultado) {
        if (atual != null) {
            buscarPorTemaRecursivo(atual.getEsquerdo(), tema, resultado);
            if (atual.getLivro().getTitulo().toLowerCase().contains(tema.toLowerCase())) {
                resultado.add(atual.getLivro());
            }
            buscarPorTemaRecursivo(atual.getDireito(), tema, resultado);
        }
    }

    // Remove um livro pelo título
    public boolean removerLivro(String titulo) {
        if (buscarPorTitulo(titulo) == null) {
            return false;
        }
        raiz = removerRecursivo(raiz, titulo);
        return true;
    }

    private NodoArvore removerRecursivo(NodoArvore atual, String titulo) {
        if (atual == null) {
            return null;
        }

        if (titulo.equalsIgnoreCase(atual.getLivro().getTitulo())) {
            // Caso 1: Nodo folha
            if (atual.getEsquerdo() == null && atual.getDireito() == null) {
                return null;
            }
            // Caso 2: Apenas um filho
            if (atual.getEsquerdo() == null) {
                return atual.getDireito();
            }
            if (atual.getDireito() == null) {
                return atual.getEsquerdo();
            }
            // Caso 3: Dois filhos
            Livro menorLivro = encontrarMenor(atual.getDireito());
            atual.setLivro(menorLivro);
            atual.setDireito(removerRecursivo(atual.getDireito(), menorLivro.getTitulo()));
            return atual;
        }

        if (titulo.compareToIgnoreCase(atual.getLivro().getTitulo()) < 0) {
            atual.setEsquerdo(removerRecursivo(atual.getEsquerdo(), titulo));
        } else {
            atual.setDireito(removerRecursivo(atual.getDireito(), titulo));
        }
        return atual;
    }

    private Livro encontrarMenor(NodoArvore atual) {
        while (atual.getEsquerdo() != null) {
            atual = atual.getEsquerdo();
        }
        return atual.getLivro();
    }
}
