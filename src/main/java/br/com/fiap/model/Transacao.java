package br.com.fiap.model;

public class Transacao {
    private int id;
    private String descricao;
    private double valor;
    private String data;
    private String origem; //Serve para controle, se o usuario registrou manualmente a transação ou não
    private int id_conta;
    private int id_categoria;

    public Transacao(){
    }

    public Transacao(int id, String descricao, double valor, String data, String origem, int id_conta, int id_categoria) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.origem = origem;
        this.id_conta = id_conta;
        this.id_categoria = id_categoria;
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

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public int getId_conta() {
        return id_conta;
    }

    public void setId_conta(int id_conta) {
        this.id_conta = id_conta;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    //public abstract double calcularImpactoSaldo();
}
