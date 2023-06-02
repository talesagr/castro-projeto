package org.example.services;

import org.example.domain.Genero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GeneroService {
    static void exibirGeneros(List<Genero> generos) {
        System.out.println("Escolha o gênero:");
        for (int i = 0; i < generos.size(); i++) {
            System.out.println((i + 1) + "- " + generos.get(i).getNome());
        }
    }

    public static List<Genero> criarGenerosFixos() {
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
}
