package org.example;

public class Produtos {
    String nome;
    Categoria categoria;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Produtos(String nome, Categoria categoria){
        this.nome = nome;
        this.categoria = categoria;
    }
}
