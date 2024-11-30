package application;

import entities.Livro;
import structures.ArvoreBinariaDeBusca;

import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        ArvoreBinariaDeBusca arvore = new ArvoreBinariaDeBusca();
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;  // Inicializando com valor inválido para entrar no loop

        do {
            // Menu do programa
            System.out.println(
                "\nACERVO DE LIVROS\n\n" +
                "1. Adicionar Livro\n" +
                "2. Listar Livros\n" +
                "3. Buscar Livro por Título\n" +
                "4. Buscar Livros por Autor\n" +
                "5. Buscar Livros por Tema\n" +
                "6. Ordenar Livros por Título\n" +
                "7. Remover Livro por Título\n" +
                "8. Sair\n"
            );

            System.out.print("Escolha uma opção: ");
            String entrada = scanner.nextLine(); // Lê a entrada como String

            // Verifica se a entrada é um número
            if (entrada.matches("\\d+")) { // Se contiver apenas dígitos
                opcao = Integer.parseInt(entrada); // Converte para inteiro
            } else {
                System.out.println("Opção inválida! Digite um número entre 1 e 8.");
                continue;  // Retorna ao menu, ignorando a opção inválida
            }

            switch (opcao) {
                case 1:
                    // Adicionar um livro
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("Ano de Publicação: ");
                    int ano = Integer.parseInt(scanner.nextLine());

                    Livro livro = new Livro(titulo, autor, ano);
                    arvore.adicionarLivro(livro);
                    System.out.println("Livro adicionado com sucesso!");
                    break;

                case 2:
                    // Listar todos os livros
                    System.out.println("\nLista de livros (em ordem alfabética):");
                    arvore.listarLivros();
                    break;

                case 3:
                    // Buscar um livro pelo título
                    System.out.print("Digite o título do livro: ");
                    String tituloBusca = scanner.nextLine();
                    Livro livroEncontrado = arvore.buscarPorTitulo(tituloBusca);
                    if (livroEncontrado != null) {
                        System.out.println("Livro encontrado: " + livroEncontrado);
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                    break;

                case 4:
                    // Buscar livros de um autor
                    System.out.print("Digite o nome do autor: ");
                    String autorBusca = scanner.nextLine();
                    List<Livro> livrosDoAutor = arvore.buscarPorAutor(autorBusca);
                    if (!livrosDoAutor.isEmpty()) {
                        System.out.println("\nLivros encontrados do autor " + autorBusca + ":");
                        for (Livro l : livrosDoAutor) {
                            System.out.println(l);
                        }
                    } else {
                        System.out.println("Nenhum livro encontrado para o autor " + autorBusca + ".");
                    }
                    break;

                case 5:
                    // Buscar livros por tema (tema interpretado como parte do título)
                    System.out.print("Digite o tema (palavra-chave no título): ");
                    String temaBusca = scanner.nextLine();
                    List<Livro> livrosPorTema = arvore.buscarPorTema(temaBusca);
                    if (!livrosPorTema.isEmpty()) {
                        System.out.println("\nLivros relacionados ao tema \"" + temaBusca + "\":");
                        for (Livro l : livrosPorTema) {
                            System.out.println(l);
                        }
                    } else {
                        System.out.println("Nenhum livro relacionado ao tema \"" + temaBusca + "\" foi encontrado.");
                    }
                    break;

                case 6:
                    // Listar livros já ordenados (a árvore mantém os livros em ordem)
                    System.out.println("\nLivros ordenados por título:");
                    arvore.listarLivros();
                    break;

                case 7:
                    // Remover um livro pelo título
                    System.out.print("Digite o título do livro a ser removido: ");
                    String tituloRemover = scanner.nextLine();
                    boolean removido = arvore.removerLivro(tituloRemover);
                    if (removido) {
                        System.out.println("Livro removido com sucesso!");
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                    break;

                case 8:
                    // Sair do programa
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 8);

        scanner.close();
    }
}
