package org.example.exercicio3;

public class Carro implements ControladorAutomovel{
    boolean ligado;
    boolean acelerando;
    boolean freiando;
    @Override
    public void ligar() {
        if (ligado){
            System.out.println("Nao eh possivel ligar 2x o carro");
        } else {
            System.out.println("ligando carro");
            boolean ligado = true;
        }
    }

    @Override
    public void desligar() {
        if (ligado) {
            System.out.println("Desligando o carro");
            boolean ligado = false;
        } else {
            System.out.println("Carro ja desligado");
        }
    }

    @Override
    public void acelerar() {
        if (freiando) {
            System.out.println("Nao eh possivel acelerar");
        } else {
            System.out.println("ACELERANDO!!");
            boolean acelerando = true;
        }
    }

    @Override
    public void freiar() {
        if (acelerando){
            System.out.println("Nao eh possivel freiar");
        } else {
            System.out.println("FREIANDO!!");
            boolean freiando = true;
        }
    }

    @Override
    public void buzinar() {
        System.out.println("BUZINA TOCANDO");
    }
}
