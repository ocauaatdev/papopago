package br.com.fiap.model;

public class Investimento {
    private int id;
    private String ticker;
    private String tipo;
    private double valorpatrimonio;
    private String dataResgate;
    private String origem; // MANUAL ou B3
    private int idUsuario;

    public Investimento(){
    }

    public Investimento(int id, String ticker, String tipo, double valorpatrimonio, String dataResgate, String origem, int idUsuario) {
        this.id = id;
        this.ticker = ticker;
        this.tipo = tipo;
        this.valorpatrimonio = valorpatrimonio;
        this.dataResgate = dataResgate;
        this.origem = origem;
        this.idUsuario = idUsuario;
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

    public String getDataResgate() {
        return dataResgate;
    }

    public void setDataResgate(String dataResgate) {
        this.dataResgate = dataResgate;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}

