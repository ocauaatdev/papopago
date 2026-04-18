package br.com.fiap.model;

public class Meta {
    private int id;
    private String nome;
    private double valorObjetivo;
    private double valorAcumulado;
    private String dataInicio;
    private String dataFim;
    private String status; //ATIVA, CONCLUIDA, INATIVA

    public Meta() {
    }

    public Meta(int id, String nome, double valorObjetivo, double valorAcumulado, String dataInicio, String dataFim, String status) {
        this.id = id;
        this.nome = nome;
        this.valorObjetivo = valorObjetivo;
        this.valorAcumulado = valorAcumulado;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.status = status;
    }

    public void exibirDadosMeta(){
        System.out.println("Executando método: exibirDadosMeta para a Meta: " + nome);
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

    public double getValorObjetivo() {
        return valorObjetivo;
    }

    public void setValorObjetivo(double valorObjetivo) {
        this.valorObjetivo = valorObjetivo;
    }

    public double getValorAcumulado() {
        return valorAcumulado;
    }

    public void setValorAcumulado(double valorAcumulado) {
        this.valorAcumulado = valorAcumulado;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

