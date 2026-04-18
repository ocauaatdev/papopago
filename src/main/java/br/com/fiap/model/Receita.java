package br.com.fiap.model;

public class Receita extends Transacao{

    public Receita(int id, String descricao, double valor, String data) {
        super(id, descricao, valor, data);
    }

    public Receita() {
    }

    @Override
    public double calcularImpactoSaldo() {
        return valor;
    }
}

