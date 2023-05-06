package org.example.exercice2;


public class Car {
    public String modelo;
    protected int nivelGasolina = 100;
    public boolean ligado;

    

    public Car(String modelo, int nivelGasolina, boolean ligado) {
        this.modelo = modelo;
        this.nivelGasolina = nivelGasolina;
        this.ligado = ligado;
    }
    public Car() {
        this.modelo = modelo;
        this.nivelGasolina = nivelGasolina;
        this.ligado = ligado;
    }
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getNivelGasolina() {
        return nivelGasolina;
    }

    public void setNivelGasolina(int nivelGasolina) {
        this.nivelGasolina = nivelGasolina;
    }

    public boolean isLigado() {
        return ligado;
    }

    public void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

    public void ligar(){
        ligado = true;
    }
    public void desligar(){
        ligado = false;
    }

    public void andar() {
        nivelGasolina = nivelGasolina - 10;
        if (nivelGasolina <= 0) {
            System.out.println("O tanque esta vazio");
        }
    }
}
