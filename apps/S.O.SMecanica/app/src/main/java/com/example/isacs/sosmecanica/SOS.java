package com.example.isacs.sosmecanica;

/**
 * Created by isacs on 17/12/2016.
 */

public class SOS {


    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
    private String item;
    private String dataHora;
    private String status;
    private String contato;
    private String nome;

    public SOS(String nome, String item, String status, String contato, String dataHora) {
        this.item = item;
        this.dataHora = dataHora;
        this.status = status;
        this.contato = contato;
        this.nome = nome;
    }

    public SOS() {
    /*default, no arguments constructor*/
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getContato() {
        return contato;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

