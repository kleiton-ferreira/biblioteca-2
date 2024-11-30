package entities;

// Representa um livro com título, autor e ano de publicação
public class Livro {
    private String titulo;
    private String autor;
    private int anoPublicacao;

    // Construtor para inicializar os atributos do livro
    public Livro(String titulo, String autor, int anoPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
    }

    // Métodos getters para acessar os atributos
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    // Sobrescreve o método toString para exibir as informações do livro de forma amigável
    @Override
    public String toString() {
        return "Livro [Título: " + titulo + ", Autor: " + autor + ", Ano: " + anoPublicacao + "]";
    }
}
