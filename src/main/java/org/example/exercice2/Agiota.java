package org.example.exercice2;

import java.util.List;

public class Agiota {
    public String nome;
    public List<String> armas;
    public boolean agressivo;
    public boolean alzheimer;
    public Integer dinheiro;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<String> getArmas() {
        return armas;
    }

    public void setArmas(List<String> armas) {
        this.armas = armas;
    }

    public boolean isAgressivo() {
        return agressivo;
    }

    public void setAgressivo(boolean agressivo) {
        this.agressivo = agressivo;
    }

    public boolean isAlzheimer() {
        return alzheimer;
    }

    public void setAlzheimer(boolean alzheimer) {
        this.alzheimer = alzheimer;
    }

    public Integer getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(Integer dinheiro) {
        this.dinheiro = dinheiro;
    }

    public Agiota(String nome, List<String> armas, boolean agressivo, boolean alzheimer, Integer dinheiro) {
        this.nome = nome;
        this.armas = armas;
        this.agressivo = agressivo;
        this.alzheimer = alzheimer;
        this.dinheiro = dinheiro;
    }
    public Agiota() {
        this.nome = nome;
        this.armas = armas;
        this.agressivo = agressivo;
        this.alzheimer = alzheimer;
        this.dinheiro = dinheiro;
    }
    public void emprestar(){
        System.out.println("O agiota esta emprestando dinheiro");
        dinheiro = dinheiro - 100;
    }

    public void cobrar() {
        System.out.println("O agiota esta cobrando");
    }

    public void ameacar(){
        System.out.println("O agiota esta ameacando");
    }

    public void recebendo(){
        System.out.println("O agiota esta finalmente recebendo");
        dinheiro = dinheiro + 500;
    }
}
