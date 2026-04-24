package br.com.fiap.model;

public class Conta {
    private int id;
    private String nomeConta;
    private String tipo;
    private double saldo;
    private int id_usuario;
    private int id_inst_fin;

    public Conta() {

    }
    public Conta(int id, String nomeConta, String tipo, double saldo, int id_usuario, int id_inst_fin){
        this.id =id;
        this.nomeConta =nomeConta;
        this.tipo =tipo;
        this.saldo =saldo;
        this.id_usuario =id_usuario;
        this.id_inst_fin = id_inst_fin;
    }
    public void exibirDadosConta(){
        System.out.println("Executando método: exibirDadosConta para a Conta: " + nomeConta);

    }

//    public void aplicarTransacao(Transacao transacao){
//        System.out.println("Saldo conta: " + (saldo += transacao.calcularImpactoSaldo()));
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeConta() {
        return nomeConta;
    }

    public void setNomeConta(String nomeConta) {
        this.nomeConta = nomeConta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_inst_fin() {
        return id_inst_fin;
    }

    public void setId_inst_fin(int id_inst_fin) {
        this.id_inst_fin = id_inst_fin;
    }
}
