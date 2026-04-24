package br.com.fiap.view;

import br.com.fiap.dao.CategoriaDao;
import br.com.fiap.dao.TransacaoDao;
import br.com.fiap.exceptions.EntidadeNaoEncontradaException;
import br.com.fiap.model.Categoria;
import br.com.fiap.model.Transacao;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TransacaoView {
    private Scanner scanner = new Scanner(System.in);

    //Metodo para exibir opções
    public void menuTransacao() {
        int opcao;

        do {
            System.out.println("=== Opções para Transação ===\n" +
                    "1. Registrar nova transação\n" +
                    "2. Listar transações\n" +
                    "0. Voltar");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    registrar();
                    break;
                case 2:
                    listar();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    public void listar(){
        try {
            TransacaoDao dao = new TransacaoDao();
            List<Transacao> transacaoList = dao.getAll();

            for (Transacao t : transacaoList){
                System.out.println("========================================");
                System.out.println("ID: " + t.getId());
                System.out.println("Descrição: " + t.getDescricao());
                System.out.println("Valor: R$ " + String.format("%.2f", t.getValor()));
                System.out.println("Data: " + t.getData());
                System.out.println("Origem: " + t.getOrigem());
                System.out.println("Conta ID: " + t.getId_conta());
                System.out.println("Categoria ID: " + t.getId_categoria());
                System.out.println("========================================\n");
            }
            dao.fecharConexao();
        } catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }

    public void registrar() {
        Random random = new Random();
        int id = random.nextInt(100);

        System.out.println("Digite a descrição da transação:");
        String descricao = scanner.nextLine();

        System.out.println("Digite o valor da transação:");
        double valor = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Digite a data em que a transação foi feita:");
        String data = scanner.nextLine();

        String origem = "MANUAL";
        int idConta = 1;

        System.out.println("Selecione a categoria da Transação:");

        try {
            CategoriaDao categoriaDao = new CategoriaDao();
            System.out.println("\n=== CATEGORIAS DISPONÍVEIS ===");

            List<Categoria> categorias = categoriaDao.getAll();

            for (Categoria c : categorias) {
                System.out.println(c.getId() + " - " + c.getNomeCategoria());
            }

            System.out.print("Escolha o ID da categoria: ");
            int idCategoria = scanner.nextInt();
            scanner.nextLine();

            Categoria categoria = categoriaDao.pesquisar(idCategoria);

            if (categoria == null) {
                System.out.println("Categoria inválida!");
                return;
            }

            System.out.println("Categoria escolhida: " + categoria.getNomeCategoria());

            Transacao transacao = new Transacao(id, descricao, valor, data, origem, idConta, idCategoria);
            TransacaoDao dao = new TransacaoDao();
            dao.registrar(transacao);
            dao.fecharConexao();
            categoriaDao.fecharConexao();
            System.out.println("Transação registrada!");


        } catch (SQLException e){
            System.err.println(e.getMessage());
        }
        catch (EntidadeNaoEncontradaException e){
            System.err.println(e.getMessage());
        }

    }
}
