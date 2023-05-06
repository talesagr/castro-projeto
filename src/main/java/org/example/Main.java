package org.example;

import org.example.atividade1804.classeMae.Filhos.Netos.*;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("SELECIONA MEUS PRODUTOS");

        List<Produtos> listaProdutos = new ArrayList<>();

        Produtos produto1 = new Produtos("produto1", Categoria.COMIDA);
        Produtos produto2 = new Produtos("produto2", Categoria.FERRO);
        Produtos produto3 = new Produtos("produto3", Categoria.FERRO);
        Produtos produto4 = new Produtos("produto4", Categoria.COMIDA);
        Produtos produto5 = new Produtos("produto5", Categoria.FRIOS);
        Produtos produto6 = new Produtos("produto6", Categoria.COMIDA);
        Produtos produto7 = new Produtos("produto7", Categoria.COMIDA);
        Produtos produto8 = new Produtos("produto8", Categoria.FERRO);
        Produtos produto9 = new Produtos("produto9", Categoria.FERRO);
        Produtos produto10 = new Produtos("produto10", Categoria.COMIDA);
        Produtos produto11 = new Produtos("produto11", Categoria.FERRO);
        Produtos produto12 = new Produtos("produto12", Categoria.FRIOS);
        Produtos produto13 = new Produtos("produto13", Categoria.COMIDA);
        Produtos produto14 = new Produtos("produto14", Categoria.COMIDA);
        Produtos produto15 = new Produtos("produto15", Categoria.FERRO);
        Produtos produto16 = new Produtos("produto16", Categoria.FERRO);
        Produtos produto17 = new Produtos("produto17", Categoria.FRIOS);
        Produtos produto18 = new Produtos("produto18", Categoria.COMIDA);
        Produtos produto19 = new Produtos("produto19", Categoria.COMIDA);
        Produtos produto20 = new Produtos("produto20", Categoria.FERRO);

        addList(listaProdutos, produto1, produto2, produto3, produto4, produto5, produto6, produto7, produto8, produto9, produto10);
        addList(listaProdutos, produto11, produto12, produto13, produto14, produto15, produto16, produto17, produto18, produto19, produto20);

        int[][] graph = {
                {0, 1, 1, 0, 0, 0, 0, 0},
                {1, 0, 1, 1, 0, 0, 0, 0},
                {1, 1, 0, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 1, 0, 0},
                {0, 0, 1, 1, 0, 1, 1, 0},
                {0, 0, 0, 1, 1, 0, 1, 1},
                {0, 0, 0, 0, 1, 1, 0, 1},
                {0, 0, 0, 0, 0, 1, 1, 0}
        };

        Categoria[] categorias = {Categoria.FERRO, Categoria.COMIDA, Categoria.FRIOS, Categoria.CONGELADOS, Categoria.TOXICOS};

        Algoritmo calcula = new Algoritmo(listaProdutos);
        calcula.graphColoring(graph, categorias);
    }

    private static void addList(List<Produtos> listaProdutos, Produtos produto11, Produtos produto12, Produtos produto13, Produtos produto14, Produtos produto15, Produtos produto16, Produtos produto17, Produtos produto18, Produtos produto19, Produtos produto20) {
        listaProdutos.add(produto11);
        listaProdutos.add(produto12);
        listaProdutos.add(produto13);
        listaProdutos.add(produto14);
        listaProdutos.add(produto15);
        listaProdutos.add(produto16);
        listaProdutos.add(produto17);
        listaProdutos.add(produto18);
        listaProdutos.add(produto19);
        listaProdutos.add(produto20);
    }
}