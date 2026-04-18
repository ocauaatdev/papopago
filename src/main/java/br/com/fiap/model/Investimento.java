package br.com.fiap.model;

public class Investimento {
    private int id;
    private String ticker;
    private String tipo;
    private double valorpatrimonio;
    private String dataVencimento;
    private String origem; // MANUAL ou B3

    public Investimento(){
    }

    public Investimento(int id, String ticker, String tipo, double valorpatrimonio, String dataVencimento, String origem){
        this.id = id;
        this. ticker = ticker;
        this.tipo= tipo;
        this.valorpatrimonio = valorpatrimonio;
        this.dataVencimento = dataVencimento;
        this.origem = origem;
    }

    public void calcularRendimento(){
        System.out.println("executando método: calcular rendimento para o ativo:" + ticker);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValorpatrimonio() {
        return valorpatrimonio;
    }

    public void setValorpatrimonio(double valorpatrimonio) {
        this.valorpatrimonio = valorpatrimonio;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }
}

