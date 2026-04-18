package br.com.fiap.model;

public class Despesa extends Transacao{

    public Despesa() {
    }

    public Despesa(int id, String descricao, double valor, String data) {
        super(id, descricao, valor, data);
    }

    @Override
    public double calcularImpactoSaldo() {
        return -valor;
    }
}

