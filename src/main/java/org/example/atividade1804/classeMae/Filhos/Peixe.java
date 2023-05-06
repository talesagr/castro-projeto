package org.example.atividade1804.classeMae.Filhos;

import org.example.atividade1804.classeMae.Animal;

public class Peixe extends Animal {

    public String corEscama;

    public void soltarBolha(){
        System.out.println("O peixe esta soltando bolinhas!");
    }

    @Override
    public void locomover() {

    }

    @Override
    public void alimentar() {
        System.out.println("O peixe esta comendo alga");
    }

    @Override
    public void emitirSom() {

    }
}
