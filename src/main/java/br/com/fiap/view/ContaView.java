package br.com.fiap.view;

import br.com.fiap.dao.ContaDao;
import br.com.fiap.dao.InstituicaoFinanceiraDao;
import br.com.fiap.model.Conta;
import br.com.fiap.model.InstituicaoFinanceira;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ContaView {
    private Scanner scanner = new Scanner(System.in);

    public void menuConta() {
        int opcao;

        do {
            System.out.println("\n=== Opções para Conta ===\n" +
                    "1. Cadastrar Conta \n" +
                    "2. Listar Contas\n" +
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
        System.out.println("Digite o nome da conta: ");
        String nomeConta = scanner.nextLine();

        System.out.println("Digite o saldo inicial da conta: ");
        double saldo = scanner.nextDouble();
        scanner.nextLine();

        int id_usuario = 1;

        try {
            ContaDao dao = new ContaDao();
            InstituicaoFinanceiraDao instFinDao = new InstituicaoFinanceiraDao();

            List<InstituicaoFinanceira> instituicoes = instFinDao.getAll();
            System.out.println("Selecione a instituição financeira:");

            for (InstituicaoFinanceira inst : instituicoes) {
                System.out.println("ID: " + inst.getId() + " - " + inst.getNome());
            }

            System.out.print("Escolha o ID da Instituição Financeira: ");
            int id_inst_fin = scanner.nextInt();
            scanner.nextLine();

            Conta conta = new Conta();
            conta.setNomeConta(nomeConta);
            conta.setSaldo(saldo);
            conta.setId_usuario(id_usuario);
            conta.setId_inst_fin(id_inst_fin);

            dao.cadastrar(conta);
            dao.fecharConexao();
            System.out.println("Conta cadastrada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar a conta: " + e.getMessage());
        }
    }

    public void listar(){
        try {
            ContaDao dao = new ContaDao();
            List<Conta> contas = dao.getAll();

            System.out.println("\n=== Lista de Contas ===");
            for (Conta conta : contas) {
                System.out.println("ID: " + conta.getId() + " - Nome: " + conta.getNomeConta() + " - Saldo: " + conta.getSaldo() + " - ID Usuário: " + conta.getId_usuario() + " - ID Instituição Financeira: " + conta.getId_inst_fin());
            }
            dao.fecharConexao();
        } catch (SQLException e) {
            System.out.println("Erro ao listar as contas: " + e.getMessage());
        }
    }
}
