package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        for (Categoria categoria : Categoria.values()) {
            System.out.println("Produtos da categoria " + categoria + ":");
            for (int i = 0; i < coloracoes.length; i++) {
                if (coloracoes[i] == categoria) {
                    System.out.println(listaProdutos.get(i).getNome());
                }
            }
            System.out.println(); // linha em branco entre as categorias
        }
    }

}

