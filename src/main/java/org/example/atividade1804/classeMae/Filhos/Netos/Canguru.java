package org.example.atividade1804.classeMae.Filhos.Netos;

import org.example.atividade1804.classeMae.Filhos.Mamifero;

public class Canguru extends Mamifero {
    public void usarBolsa(){
        System.out.println("O canguru esta utilizando sua bolsa para guardar seus filhotes");
    }

    @Override
    public void locomover(){
        System.out.println("O canguru ta doidao andando por ai");
    }
    @Override
    public void emitirSom(){
        System.out.println("O canguru esta fazendo rap!! vai entender o que ele diz?");
    }
}
