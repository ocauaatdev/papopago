package br.com.fiap.model;

public class InstituicaoFinanceira {
    private int id;
    private String nome;
    private int codigoBacen;

    public InstituicaoFinanceira() {
    }

    public InstituicaoFinanceira(int id, String nome, int codigoBacen) {
        this.id = id;
        this.nome = nome;
        this.codigoBacen = codigoBacen;
    }

    public void exibirDadosInstFinanceira(){
        System.out.println("Executando método: exibirDadosInstFinanceira para a Instituição: " + nome);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigoBacen() {
        return codigoBacen;
    }

    public void setCodigoBacen(int codigoBacen) {
        this.codigoBacen = codigoBacen;
    }
}

