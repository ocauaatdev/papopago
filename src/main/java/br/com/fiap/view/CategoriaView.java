package br.com.fiap.view;

import br.com.fiap.dao.CategoriaDao;
import br.com.fiap.dao.UsuarioDao;
import br.com.fiap.model.Categoria;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CategoriaView {
    private Scanner scanner = new Scanner(System.in);

    //Metodo para exibir opções
    public void menuCategoria(){
        int opcao;

        do {
            System.out.println("\n=== Opções para Categoria ===\n" +
                    "1. Cadastrar nova Categoria\n" +
                    "2. Listar Categorias\n" +
                    "0. Voltar");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao){
                case 1:
                    cadastrar();
                    break;
                case 2:
                    listar();
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }while (opcao != 0);
    }

    public void cadastrar(){
        System.out.println("Digite o nome da categoria:");
        String nome = scanner.nextLine();

        System.out.println("Escolha o tipo da categoria:\n1. RECEITA\n2. DESPESA");
        int escolha = scanner.nextInt();
        scanner.nextLine();

        String tipo;

        if (escolha == 1){
            tipo = "RECEITA";
        } else{
            tipo = "DESPESA";
        }

        try {
            Categoria categoria = new Categoria();
            categoria.setNomeCategoria(nome);
            categoria.setTipo(tipo);
            CategoriaDao dao = new CategoriaDao();
            dao.cadastrar(categoria);
            dao.fecharConexao();

            System.out.println("Categoria cadastrada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void listar(){
        try {
            CategoriaDao dao = new CategoriaDao();
            List<Categoria> categorias = dao.getAll();

            for (Categoria categoria : categorias){
                System.out.println("Id: " + categoria.getId() + " - " + categoria.getNomeCategoria() + " - Tipo: " + categoria.getTipo());
            }

            dao.fecharConexao();
        }catch (SQLException e){
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
