package com.example.listviewobjetos;

public class Estudante {
    private String nome;
    private String endereco;
    private String email;

    public Estudante(String nome, String endereco, String email) {
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
    }

    public Estudante(Estudante a) {
        this.nome = a.getNome();
        this.endereco = a.getEndereco();
        this.email = a.getEmail();
    }

    public Estudante() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
