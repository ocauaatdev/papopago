package br.com.fiap.view;

import br.com.fiap.dao.MetaDao;
import br.com.fiap.model.Meta;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MetaView {
    private Scanner scanner = new Scanner(System.in);

    // Método para exibir opções de Metas
    public void menuMeta() {
        int opcao;

        do {
            System.out.println("\n=== Opções para Metas ===\n" +
                    "1. Cadastrar Meta\n" +
                    "2. Listar Metas\n" +
                    "0. Voltar");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
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
        } while (opcao != 0);
    }

    // Método para cadastrar informações da Meta
    public void cadastrar() {
        System.out.println("Digite o nome da meta (ex: Viagem, Carro):");
        String nome = scanner.nextLine();

        System.out.println("Digite o valor objetivo:");
        double valorObjetivo = scanner.nextDouble();

        System.out.println("Digite o valor já acumulado:");
        double valorAcumulado = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Digite a data de início (DD/MM/AAAA):");
        String dataInicio = scanner.nextLine();

        System.out.println("Digite a data final prevista (DD/MM/AAAA):");
        String dataFim = scanner.nextLine();

        System.out.println("Digite o status (ATIVA, CONCLUIDA, INATIVA):");
        String status = scanner.nextLine().toUpperCase();

        // Gerando ID aleatório para a Meta (seguindo o modelo de Usuario)
        Random random = new Random();
        int id = random.nextInt(1000);

        try {
            MetaDao dao = new MetaDao();
            Meta meta = new Meta(id, nome, valorObjetivo, valorAcumulado, dataInicio, dataFim, status);
            dao.cadastrar(meta);
            dao.fecharConexao();

            System.out.println("Meta cadastrada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar meta: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Erro: Por favor, insira valores numéricos válidos para os valores financeiros.");
        }
    }

    // Método para listar todas as metas do banco
    private void listar() {
        try {
            MetaDao dao = new MetaDao();
            List<Meta> metas = dao.getAll();

            if (metas.isEmpty()) {
                System.out.println("Nenhuma meta encontrada.");
            } else {
                System.out.println("\n--- Listagem de Metas ---");
                for (Meta meta : metas) {
                    System.out.println("ID: " + meta.getId() +
                            " | Nome: " + meta.getNome() +
                            " | Objetivo: R$" + meta.getValorObjetivo() +
                            " | Acumulado: R$" + meta.getValorAcumulado() +
                            " | Início: " + meta.getDataInicio() +
                            " | Fim: " + meta.getDataFim() +
                            " | Status: " + meta.getStatus());
                }
            }

            dao.fecharConexao();
        } catch (SQLException e) {
            System.out.println("Erro ao listar metas: " + e.getMessage());
        }
    }
}
