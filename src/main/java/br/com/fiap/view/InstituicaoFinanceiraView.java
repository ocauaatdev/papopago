package br.com.fiap.view;

import br.com.fiap.dao.InstituicaoFinanceiraDao;
import br.com.fiap.model.InstituicaoFinanceira;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class InstituicaoFinanceiraView {
    private Scanner scanner = new Scanner(System.in);

    //Metodo para exibir opções de Instiuição financeira
    public void menuInstituicaoFinanceira(){
        int opcao;

        do {
            System.out.println("\n=== Opções para Instiuição Financeira ===\n" +
                    "1. Cadastrar Instituição \n" +
                    "2. Listar Instituição\n" +
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

    //Metodo para cadastrar informações da Instituição Finaceira
    public void cadastrar(){
        System.out.println("Digite o nome da instituição financeira: ");
        String nome = scanner.nextLine();

        System.out.println("Digite o código Bacen da instituição financeira: ");
        int codigoBacen = scanner.nextInt();
        scanner.nextLine();

        try {
            InstituicaoFinanceiraDao dao = new InstituicaoFinanceiraDao();

            InstituicaoFinanceira instituicaoFinanceira = new InstituicaoFinanceira();
            instituicaoFinanceira.setNome(nome);
            instituicaoFinanceira.setCodigoBacen(codigoBacen);

            dao.cadastrar(instituicaoFinanceira);
            dao.fecharConexao();

            System.out.println("Instituição Financeira Cadastrada!");
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    //Metodo para listar todas instituições financeiras
    private void listar(){
        try {
            InstituicaoFinanceiraDao dao = new InstituicaoFinanceiraDao();
            List<InstituicaoFinanceira> lista = dao.getAll();

            //para cada instituicao financeira dentro da List de instituicões faça:
            for (InstituicaoFinanceira i : lista){
                System.out.println("ID: " + i.getId());
                System.out.println("Nome: " + i.getNome());
                System.out.println("Código Bacen: " + i.getCodigoBacen());
                System.out.println("-----------------------------");
            }

            dao.fecharConexao();
        }catch (SQLException e){
            System.out.println("Erro: " + e.getMessage());
        }
    }
}