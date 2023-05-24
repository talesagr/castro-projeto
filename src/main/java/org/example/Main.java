package org.example;

import org.example.atividade1804.classeMae.Filhos.Netos.*;
import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Produtos> listaProdutos = new ArrayList<>();

        Produtos produto1 = new Produtos("produto1", Categoria.COMIDA);
        Produtos produto2 = new Produtos("produto2", Categoria.FERRO);
        Produtos produto3 = new Produtos("produto3", Categoria.FERRO);
        Produtos produto4 = new Produtos("produto4", Categoria.COMIDA);
        Produtos produto5 = new Produtos("produto5", Categoria.FRIOS);
        listaProdutos.add(produto1);
        listaProdutos.add(produto2);
        listaProdutos.add(produto3);
        listaProdutos.add(produto4);
        listaProdutos.add(produto5);
        menu();

        int acao = sc.nextInt();
        if (acao == 1) {
            System.out.println("***       PRODUTOS      ***");
            for (int i = 0; i < listaProdutos.size(); i++) {
                System.out.println(i + "- NOME: " + listaProdutos.get(i).nome + ", CATEGORIA: " + listaProdutos.get(i).getCategoria());
            }
        } else if (acao == 2) {
                Algoritmo calcula = new Algoritmo(listaProdutos);
                System.out.println("*** AQUI ESTA SEU ARMAZEM: ***");

                // Para nao dar problema, o grafo precisa sempre ser "compativel" com o tamanho da lista de produto, por exemplo: se a lista possui 5 produtos, entao o grafo
                // precisa ser 5x5. Caso a lista de produtos tenha 8 produtos, o grafo precisa ser 8x8
            /**
            *incluir opcao de cadastrar produtos com categoria e nome, e assim que incluir, aumentar tamanho do grafo em 1 lado cada.
            *OU
            *incluir imagens de produtos, em alguma outra aplicacao (FRONT-END)
             *  */

                int[][] graph = {
                        {0, 1, 1, 0, 0},
                        {1, 0, 0, 1, 1},
                        {0, 1, 1, 0, 0},
                        {1, 1, 0, 1, 1},
                        {0, 0, 1, 1, 1},
                };
                Categoria[] categorias = {Categoria.FERRO, Categoria.COMIDA, Categoria.FRIOS};
                calcula.graphColoring(graph, categorias);
        }
    }

    private static void menu() {
            System.out.println("***    SEJA BEM VINDO   ***");
            System.out.println("***          AO         ***");
            System.out.println("*** COLORACAO DE GRAFOS ***");
            System.out.println("***          MENU       ***");
            System.out.println("*** 1 - MEUS PRODUTOS   ***");
            System.out.println("*** 2 - MEU ARMAZEM     ***");
            System.out.println("*** O QUE DESEJA FAZER? ***");
    }
}