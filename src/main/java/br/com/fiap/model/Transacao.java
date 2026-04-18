package br.com.fiap.model;

public abstract class Transacao {
    protected int id;
    protected String descricao;
    protected double valor;
    protected String data;

    public Transacao(){
    }

    public Transacao(int id, String descricao, double valor, String data) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void validarTransacao() {
        System.out.println("Executando método:validartransacao para: " + descricao);
    }

    public abstract double calcularImpactoSaldo();
}
