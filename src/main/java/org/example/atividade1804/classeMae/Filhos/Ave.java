package org.example.atividade1804.classeMae.Filhos;

import org.example.atividade1804.classeMae.Animal;

public class Ave extends Animal {
    public String corPena;

    public void fazerNinho(){
        System.out.println("A ave esta fazendo seu ninho para seus filhotes");
    }

    @Override
    public void locomover() {
        System.out.println("A ave esta andando");
    }

    @Override
    public void alimentar() {
        System.out.println("A ave esta comendo");
    }

    @Override
    public void emitirSom() {
        System.out.println("A ave esta chamando para acasalamento");
    }
}
