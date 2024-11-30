# biblioteca-2
Sistema de Gerenciamento de Biblioteca-Fase 2

# Sistema de Gerenciamento de Acervo de Biblioteca – Fase 2

## 1. Introdução
Este sistema de gerenciamento de acervo foi desenvolvido em **Java** para auxiliar no cadastro, consulta e manutenção de livros em uma biblioteca. Ele utiliza uma **Árvore Binária de Busca (ABB)** como estrutura de dados principal, permitindo operações eficientes como inserção, busca, remoção e ordenação de livros. 

Funcionalidades avançadas foram incluídas, como a recomendação de livros por autor ou tema.

---

## 2. Escolha da Estrutura de Dados
Optamos pela **Árvore Binária de Busca (ABB)** devido às seguintes vantagens:

- **Busca e Inserção Otimizadas**: Operações realizadas em média em **O(log n)**, reduzindo o tempo em relação à lista encadeada (**O(n)**).
- **Ordenação Automática**: Os livros são armazenados de forma que sua travessia *in-order* retorna uma lista naturalmente ordenada.
- **Flexibilidade para Expansões**: Permite a implementação eficiente de buscas e filtragens avançadas.

Essas características tornam a ABB ideal para sistemas onde as operações de busca e organização de dados são frequentes, como em um acervo de biblioteca.

---

## 3. Classes Principais

### 3.1. `Livro`
Representa os dados do livro com os seguintes atributos:
- `titulo`: Título do livro.
- `autor`: Autor do livro.
- `anoPublicacao`: Ano de publicação.

Além disso, possui métodos de acesso e um `toString` para exibição dos dados.

### 3.2. `NodoArvore`
Um nó da ABB que contém:
- `livro`: Objeto do tipo `Livro`.
- `esquerdo` e `direito`: Referências aos filhos esquerdo e direito da árvore.

### 3.3. `ArvoreBinariaDeBusca`
Gerencia a ABB com os principais métodos:
- `adicionarLivro(Livro livro)`: Insere um livro na árvore, mantendo-a balanceada.
- `listarLivros()`: Exibe todos os livros em ordem alfabética (travessia *in-order*).
- `buscarPorTitulo(String titulo)`: Retorna um livro com base no título.
- `buscarPorAutor(String autor)`: Lista todos os livros de um autor específico.
- `buscarPorTema(String tema)`: Retorna livros cujos títulos contêm um termo informado.
- `removerLivro(String titulo)`: Remove o livro correspondente, reorganizando a árvore.

### 3.4. `Program`
Classe principal com interface em linha de comando. Fornece as seguintes opções:

1. **Adicionar Livro**: Recebe informações do usuário e insere o livro na ABB.
2. **Listar Livros**: Exibe todos os livros em ordem alfabética.
3. **Buscar por Título**: Localiza um livro pelo título e exibe suas informações.
4. **Remover Livro por Título**: Remove o livro informado.
5. **Recomendações**:
   - **Por Autor**: Retorna livros de um autor específico.
   - **Por Tema**: Busca livros com uma palavra-chave no título.
6. **Sair**: Encerra o programa.

---

## 4. Fluxo de Execução

1. **Início**: O programa exibe o menu principal ao usuário.
2. **Escolha de Opções**:
   - Ao adicionar um livro, ele é inserido na ABB e posicionado conforme sua ordem alfabética.
   - A listagem realiza uma travessia *in-order* da ABB, exibindo os livros já ordenados.
   - A busca por título, autor ou tema percorre a árvore até localizar os livros correspondentes.
   - A remoção busca o nó correspondente e reorganiza a ABB para manter sua estrutura.
3. **Repetição ou Saída**: Após concluir uma operação, o menu é exibido novamente até que o usuário opte por sair.

---

## 5. Funcionalidades Avançadas

### 5.1. Recomendações
- **Por Autor**: Localiza e exibe todos os livros cadastrados de um autor específico.
- **Por Tema**: Busca livros cujos títulos contêm um termo indicado pelo usuário, permitindo a localização de obras relacionadas a um tema de interesse.

### 5.2. Ordenação Automática
Os livros são organizados automaticamente conforme são inseridos, sem a necessidade de métodos adicionais de ordenação, graças à estrutura da ABB.

---

## 6. Conclusão
O sistema utiliza a **Árvore Binária de Busca (ABB)** para oferecer um gerenciamento eficiente e escalável do acervo de uma biblioteca. Com inserção e busca otimizadas, funcionalidades avançadas como recomendação de livros e suporte a operações dinâmicas, ele atende às principais necessidades de sistemas de acervo.

Sua implementação modular facilita a manutenção e futuras expansões.

