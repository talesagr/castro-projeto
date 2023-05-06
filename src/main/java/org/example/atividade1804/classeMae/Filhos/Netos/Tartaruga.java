package org.example.atividade1804.classeMae.Filhos.Netos;

import org.example.atividade1804.classeMae.Filhos.Reptil;

public class Tartaruga extends Reptil {
    @Override
    public void locomover(){
        System.out.println("A TARARUGA esta se movendo, mas, BEEEEEM lentamente");
    }

    @Override
    public void emitirSom(){
        System.out.println("A TARARUGA esta surrurando que ira ganhar a corrida da Lebre");
    }
}
