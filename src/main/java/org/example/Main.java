package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Produtos> listaProdutos = new ArrayList<>();
        Map<Produtos, Categoria> grafo = new HashMap<>();
        Categoria[] categorias = {Categoria.FERRO, Categoria.COMIDA, Categoria.FRIOS};

        int acao = 0;
        while (acao != 4) {
            menu();

            acao = sc.nextInt();
            if (acao == 1) {
                System.out.println("***       PRODUTOS      ***");
                for (int i = 0; i < listaProdutos.size(); i++) {
                    System.out.println(i + "- NOME: " + listaProdutos.get(i).getNome() + ", CATEGORIA: " + listaProdutos.get(i).getCategoria());
                }
                System.out.println();
            } else if (acao == 2) {
                System.out.println("*** AQUI ESTÁ SEU ARMAZÉM: ***");

                for (Produtos produto : listaProdutos) {
                    grafo.put(produto, produto.getCategoria());
                }

                if (listaProdutos.isEmpty()) {
                    System.out.println("Seu armazém está vazio. Adicione produtos antes de realizar a coloração do grafo.");
                } else {
                    GrafoColoracao grafoColoracao = new GrafoColoracao(grafo, categorias);
                    grafoColoracao.colorirGrafo();
                }
                System.out.println();
            } else if (acao == 3) {
                cadastrarProduto(sc, listaProdutos);
                System.out.println("Produto cadastrado com sucesso!");
                System.out.println();
            } else if (acao == 4) {
                System.out.println("Encerrando o programa. Obrigado por utilizar!");
            } else {
                System.out.println("Opção inválida. Por favor, selecione uma opção válida.");
                System.out.println();
            }
        }
    }

    private static void menu() {
        System.out.println("***    SEJA BEM-VINDO   ***");
        System.out.println("***          AO         ***");
        System.out.println("*** COLORAÇÃO DE GRAFOS ***");
        System.out.println("***          MENU       ***");
        System.out.println("*** 1 - MEUS PRODUTOS   ***");
        System.out.println("*** 2 - MEU ARMAZÉM     ***");
        System.out.println("*** 3 - CADASTRAR PRODUTO ***");
        System.out.println("*** 4 - SAIR            ***");
        System.out.println("*** O QUE DESEJA FAZER? ***");
    }

    private static void cadastrarProduto(Scanner sc, List<Produtos> listaProdutos) {
        System.out.println("*** CADASTRAR PRODUTO ***");
        System.out.println("Informe o nome do produto:");
        String nome = sc.next();
        System.out.println("Informe a categoria do produto (0 - FERRO, 1 - COMIDA, 2 - FRIOS):");
        int categoria = sc.nextInt();

        Categoria categoriaProduto;
        switch (categoria) {
            case 0:
                categoriaProduto = Categoria.FERRO;
                break;
            case 1:
                categoriaProduto = Categoria.COMIDA;
                break;
            case 2:
                categoriaProduto = Categoria.FRIOS;
                break;
            default:
                System.out.println("Categoria inválida. O produto será cadastrado como Categoria.FERRO.");
                categoriaProduto = Categoria.FERRO;
                break;
        }

        Produtos produto = new Produtos(nome, categoriaProduto);
        listaProdutos.add(produto);
    }
}

class GrafoColoracao {
    private Map<Produtos, Categoria> grafo;
    private Categoria[] categorias;
    private int[] cores;
    private int numCores;

    public GrafoColoracao(Map<Produtos, Categoria> grafo, Categoria[] categorias) {
        this.grafo = grafo;
        this.categorias = categorias;
        this.cores = new int[grafo.size()];
        this.numCores = categorias.length;
    }

    public void colorirGrafo() {
        if (podeColorir()) {
            colorirRecursivamente(0);
            exibirColoracao();
        } else {
            System.out.println("Não é possível colorir o grafo com as categorias disponíveis.");
        }
    }

    private boolean podeColorir() {
        return numCores >= grafo.size();
    }

    private void colorirRecursivamente(int produtoIndex) {
        if (produtoIndex == grafo.size()) {
            return; // Todos os produtos foram coloridos
        }

        Produtos produto = (Produtos) grafo.keySet().toArray()[produtoIndex];

        for (int cor = 1; cor <= numCores; cor++) {
            if (podeAtribuirCor(produto, cor)) {
                cores[produtoIndex] = cor;

                if (podeColorirRestante(produtoIndex)) {
                    colorirRecursivamente(produtoIndex + 1);
                }

                cores[produtoIndex] = 0; // Reseta a cor para tentar outra cor
            }
        }
    }

    private boolean podeAtribuirCor(Produtos produto, int cor) {
        for (Map.Entry<Produtos, Categoria> entry : grafo.entrySet()) {
            Produtos adjacente = entry.getKey();
            Categoria categoria = entry.getValue();

            if (grafo.get(produto).equals(categoria) && cores[getIndex(adjacente)] == cor) {
                return false; // Produto adjacente já possui a mesma cor
            }
        }
        return true;
    }

    private boolean podeColorirRestante(int produtoIndex) {
        if (produtoIndex == grafo.size() - 1) {
            return true; // Todos os produtos foram coloridos
        }

        for (int i = produtoIndex + 1; i < grafo.size(); i++) {
            Produtos produto = (Produtos) grafo.keySet().toArray()[i];
            if (!podeAtribuirCor(produto, cores[produtoIndex])) {
                return false; // Existe um produto adjacente com a mesma cor
            }
        }
        return true;
    }

    private void exibirColoracao() {
        System.out.println("*** COLORAÇÃO DO GRAFO ***");
        int index = 0;
        for (Map.Entry<Produtos, Categoria> entry : grafo.entrySet()) {
            Produtos produto = entry.getKey();
            Categoria categoria = entry.getValue();
            int cor = cores[index];
            index++;

            System.out.println("Produto: " + produto.getNome() + ", Categoria: " + categoria + ", Cor: " + cor);
        }
    }

    private int getIndex(Produtos produto) {
        int index = 0;
        for (Produtos p : grafo.keySet()) {
            if (p.equals(produto)) {
                return index;
            }
            index++;
        }
        return -1;
    }
}
