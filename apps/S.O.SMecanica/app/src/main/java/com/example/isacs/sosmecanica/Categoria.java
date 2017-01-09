package com.example.isacs.sosmecanica;

/**
 * Created by isacs on 17/12/2016.
 */

public class Categoria {

    private double preco;
    private String veiculo;
    private String estabelecimento;
    private String cidade;
    private String rua;
    private String complemento;
    private String dataHora;

    public Categoria(double preco, String veiculo, String estabelecimento, String cidade, String rua,  String complemento, String dataHora) {
        this.preco = preco;
        this.veiculo = veiculo;
        this.estabelecimento = estabelecimento;
        this.cidade = cidade;
        this.rua = rua;
        this.complemento = complemento;
        this.dataHora = dataHora;
    }

    public Categoria() {
    /*default, no arguments constructor*/
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setEstabelecimento(String estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public String getEstabelecimento() {
        return estabelecimento;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCidade() {
        return cidade;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getRua() {
        return rua;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getComplemento() {
        return complemento;
    }
}
