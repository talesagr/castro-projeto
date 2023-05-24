package org.example;

import java.util.*;

public class Algoritmo {

    private boolean solutionFound = false;
    private List<Produtos> listaProdutos;

    public Algoritmo(List<Produtos> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public void graphColoring(int[][] graph, Categoria[] cores) {
        int numVertices = graph.length;
        Categoria[] coloracoes = new Categoria[numVertices];
        graphColoring(graph, cores, 0, coloracoes);
    }
//todo Atual problema é que ele nao esta mostrando a categoria certa. REVISAR o que queremos mostrar e comparar com o que ele esta mostrando
    private void graphColoring(int[][] graph, Categoria[] cores, int vertice, Categoria[] coloracoes) {
        int numVertices = graph.length;
        if (vertice == numVertices) {
            printSolution(coloracoes);
            solutionFound = true;
            return;
        }

        for (Categoria cor : cores) {
            if (isColorValid(graph, coloracoes, vertice, cor)) {
                coloracoes[vertice] = cor;
                graphColoring(graph, cores, vertice + 1, coloracoes);
                coloracoes[vertice] = null; // backtrack

                if (solutionFound) {
                    return;
                }
            }
        }
    }

    private boolean isColorValid(int[][] graph, Categoria[] coloracoes, int vertice, Categoria cor) {
        for (int i = 0; i < graph.length; i++) {
            if (graph[vertice][i] == 1 && coloracoes[i] == cor) {
                return false;
            }
        }
        return true;
    }

    private void printSolution(Categoria[] coloracoes) {
        Map<Categoria, List<String>> produtosPorCategoria = new HashMap<>();

        for (Categoria categoria : Categoria.values()) {
            produtosPorCategoria.put(categoria, new ArrayList<>());
        }

        for (int i = 0; i < coloracoes.length; i++) {
            Categoria categoria = coloracoes[i];
            produtosPorCategoria.get(categoria).add(listaProdutos.get(i).getNome());
        }

        for (Categoria categoria : Categoria.values()) {
            List<String> produtos = produtosPorCategoria.get(categoria);
            System.out.println("*** Produtos da categoria " + categoria + ": ***");
            for (String produto : produtos) {
                System.out.println(produto);
            }
            System.out.println(); // linha em branco entre as categorias
        }
    }

}

