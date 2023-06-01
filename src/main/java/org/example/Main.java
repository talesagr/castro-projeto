import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Categoria> categorias = new ArrayList<>();
        List<Produto> produtos = new ArrayList<>();
        List<Genero> generos = criarGenerosFixos();

        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    cadastrarCategoria(scanner, categorias, generos);
                    break;
                case 2:
                    cadastrarProduto(scanner, categorias, produtos);
                    break;
                case 3:
                    exibirCategorias(categorias);
                    break;
                case 4:
                    exibirProdutos(produtos);
                    break;
                case 5:
                    organizarEstoque(categorias, generos);
                    exibirArmazem(categorias, produtos);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Digite novamente.");
                    break;
            }
        } while (opcao != 0);
    }

    private static void exibirMenu() {
        System.out.println("***     MENU     ***");
        System.out.println("1- Cadastrar categoria");
        System.out.println("2- Cadastrar produto");
        System.out.println("3- Exibir categorias");
        System.out.println("4- Exibir produtos");
        System.out.println("5- Organizar estoque");
        System.out.println("0- Sair");
        System.out.println("*******************");
        System.out.println("Digite a opção desejada:");
    }

    private static List<Genero> criarGenerosFixos() {
        List<Genero> generos = new ArrayList<>();

        // Gêneros que podem ser agrupados juntos
        List<String> alimentos = Arrays.asList("Alimentos", "Bebidas");
        List<String> automoveis = Arrays.asList("Automóveis");
        List<String> beleza = Arrays.asList("Beleza", "Saúde");
        List<String> calcados = Arrays.asList("Calçados");
        // ...

        generos.add(new Genero("Alimentos", alimentos));
        generos.add(new Genero("Automóveis", automoveis));
        generos.add(new Genero("Beleza", beleza));
        generos.add(new Genero("Calçados", calcados));
        // ...

        return generos;
    }

    private static void exibirProdutos(List<Produto> produtos) {
        System.out.println("***        PRODUTOS        ***");
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            for (Produto produto : produtos) {
                System.out.println("PRODUTO: " + produto.getNome() + " | CATEGORIA: " + produto.getCategoria().getNome());
            }
        }
        System.out.println("*****************************");
    }

    private static void exibirCategorias(List<Categoria> categorias) {
        System.out.println("***      CATEGORIAS      ***");
        if (categorias.isEmpty()) {
            System.out.println("Nenhuma categoria cadastrada.");
        } else {
            for (int i = 0; i < categorias.size(); i++) {
                Categoria categoria = categorias.get(i);
                System.out.println((i + 1) + "- CATEGORIA: " + categoria.getNome() + " | GÊNERO: " + categoria.getGenero().getNome());
            }
        }
        System.out.println("***************************");
    }

    private static void cadastrarCategoria(Scanner scanner, List<Categoria> categorias, List<Genero> generos) {
        System.out.println("Digite o nome da categoria:");
        String nomeCategoria = scanner.nextLine();

        System.out.println("Escolha o gênero da categoria:");
        exibirGeneros(generos);

        int opcaoGenero = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        if (opcaoGenero < 1 || opcaoGenero > generos.size()) {
            System.out.println("Opção inválida. Categoria não cadastrada.");
        } else {
            Genero generoSelecionado = generos.get(opcaoGenero - 1);
            Categoria novaCategoria = new Categoria(nomeCategoria, generoSelecionado);
            categorias.add(novaCategoria);
            System.out.println("Categoria cadastrada com sucesso.");
        }
    }

    private static void exibirGeneros(List<Genero> generos) {
        System.out.println("Escolha o gênero:");
        for (int i = 0; i < generos.size(); i++) {
            System.out.println((i + 1) + "- " + generos.get(i).getNome());
        }
    }

    private static void cadastrarProduto(Scanner scanner, List<Categoria> categorias, List<Produto> produtos) {
        if (categorias.isEmpty()) {
            System.out.println("Não há categorias cadastradas. Cadastre uma categoria antes de adicionar um produto.");
            return;
        }

        System.out.println("Digite o nome do produto:");
        String nomeProduto = scanner.nextLine();

        System.out.println("Escolha a categoria do produto:");
        exibirCategorias(categorias);

        int opcaoCategoria = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        if (opcaoCategoria < 1 || opcaoCategoria > categorias.size()) {
            System.out.println("Opção inválida. Produto não cadastrado.");
        } else {
            Categoria categoriaSelecionada = categorias.get(opcaoCategoria - 1);
            Produto novoProduto = new Produto(nomeProduto, categoriaSelecionada);
            produtos.add(novoProduto);
            System.out.println("Produto cadastrado com sucesso.");
        }
    }

    private static void organizarEstoque(List<Categoria> categorias, List<Genero> generos) {
        int numCategorias = categorias.size();
        boolean[][] grafo = new boolean[numCategorias][numCategorias];

        // Cria uma matriz de adjacência com base nas restrições de gênero
        for (int i = 0; i < numCategorias; i++) {
            Categoria categoriaI = categorias.get(i);
            for (int j = i + 1; j < numCategorias; j++) {
                Categoria categoriaJ = categorias.get(j);
                if (categoriaI.getGenero().equals(categoriaJ.getGenero())) {
                    grafo[i][j] = true;
                    grafo[j][i] = true;
                }
            }
        }

        int[] cores = new int[numCategorias];
        Arrays.fill(cores, -1);

        if (backtracking(grafo, cores, 0, generos.size())) {
            System.out.println("Estoque organizado com sucesso.\n");

            // Agrupa as categorias por cor
            Map<Integer, List<Categoria>> grupos = new HashMap<>();
            for (int i = 0; i < numCategorias; i++) {
                int cor = cores[i];
                if (!grupos.containsKey(cor)) {
                    grupos.put(cor, new ArrayList<>());
                }
                grupos.get(cor).add(categorias.get(i));
            }

            // Exibe as categorias agrupadas por cor
            for (List<Categoria> grupo : grupos.values()) {
                System.out.println("Grupo de categorias:");
                for (Categoria categoria : grupo) {
                    System.out.println("- " + categoria.getNome());
                }
                System.out.println();
            }
        } else {
            System.out.println("Não é possível organizar o estoque de acordo com as restrições de gênero.");
        }
    }

    private static boolean backtracking(boolean[][] grafo, int[] cores, int posicao, int numCores) {
        if (posicao == cores.length) {
            return true;
        }

        for (int cor = 0; cor < numCores; cor++) {
            if (ehCorSegura(grafo, cores, posicao, cor)) {
                cores[posicao] = cor;
                if (backtracking(grafo, cores, posicao + 1, numCores)) {
                    return true;
                }
                cores[posicao] = -1;
            }
        }

        return false;
    }

    private static boolean ehCorSegura(boolean[][] grafo, int[] cores, int posicao, int cor) {
        for (int i = 0; i < grafo.length; i++) {
            if (grafo[posicao][i] && cores[i] == cor) {
                return false;
            }
        }
        return true;
    }

    private static void exibirArmazem(List<Categoria> categorias, List<Produto> produtos) {
        System.out.println("***        ARMAZÉM        ***");
        for (Categoria categoria : categorias) {
            System.out.println("CATEGORIA: " + categoria.getNome() + " | GÊNERO: " + categoria.getGenero().getNome());
            System.out.println("PRODUTOS:");
            for (Produto produto : produtos) {
                if (produto.getCategoria().equals(categoria)) {
                    System.out.println("- " + produto.getNome());
                }
            }
            System.out.println("------------------------------");
        }
        System.out.println("*****************************");
    }
}

class Genero {
    private String nome;

    public Genero(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

class Categoria {
    private String nome;
    private Genero genero;

    public Categoria(String nome, Genero genero) {
        this.nome = nome;
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public Genero getGenero() {
        return genero;
    }
}

class Produto {
    private String nome;
    private Categoria categoria;

    public Produto(String nome, Categoria categoria) {
        this.nome = nome;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}
