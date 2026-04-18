package br.com.fiap.model;

public class Usuario {

    private int id;
    private String nome;
    private String email;
    private String dataNascimento;
    private String numeroTelefone;
    private String senha;
    private String cpf;

    public Usuario() {
    }

    public Usuario(int id, String nome, String email, String dataNascimento, String numeroTelefone, String senha, String cpf) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.numeroTelefone = numeroTelefone;
        this.senha = senha;
        this.cpf = cpf;
    }

    public void exibirperfil() {
        System.out.println("executando Método: exibirperfil para o usuário: " + nome);
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
