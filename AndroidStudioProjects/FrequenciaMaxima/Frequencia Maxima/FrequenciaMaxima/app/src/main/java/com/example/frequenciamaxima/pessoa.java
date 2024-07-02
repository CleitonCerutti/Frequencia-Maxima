package com.example.frequenciamaxima;

import androidx.annotation.NonNull;

public class pessoa {

    private String nome;
    private String idade;
    private String fcm;

    public static Object get(int position) {
        return null;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }
    public String getFcm() {
        return fcm;
    }

    public void setFcm(String fcm) {
        this.fcm = fcm;
    }


    @NonNull
    @Override

    public String toString() {
        return "Nome: " + nome  + "\nFCM: " + fcm;
    }
}