package org.example.atividade1804.classeMae.Filhos.Netos;

import org.example.atividade1804.classeMae.Filhos.Reptil;

public class Cobra extends Reptil {

    @Override
    public void alimentar(){
        System.out.println("A cobra esta esmagando sua presa");
    }

    @Override
    public void locomover(){
        System.out.println("A cobra esta rastejando");
    }
}
