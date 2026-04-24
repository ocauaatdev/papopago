package br.com.fiap.model;

public class Categoria {
    private int id;
    private String nomeCategoria;
    private String tipo;

    public Categoria() {
    }

    public Categoria(int id, String nomeCategoria, String tipo) {
        this.id = id;
        this.nomeCategoria = nomeCategoria;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
