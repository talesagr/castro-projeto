package org.example.atividade1804.classeMae.Filhos.Netos;

import org.example.atividade1804.classeMae.Filhos.Mamifero;

public class Cachorro extends Mamifero {
    public void abanarRabo(){
        System.out.println("O dog esta abanando seu rabo");
    }

    public void enterrarOsso(){
        System.out.println("O dog esta enterrando o osso que achou!");
    }

    @Override
    public void alimentar(){
        System.out.println("the dog is nhack nhack my perneishon");
    }
}
