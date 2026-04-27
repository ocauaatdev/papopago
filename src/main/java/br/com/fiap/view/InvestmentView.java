package br.com.fiap.view;

import br.com.fiap.dao.InvestmentDao;
import br.com.fiap.model.Investimento;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class InvestmentView {
    private Scanner scanner = new Scanner(System.in);

    //Metodo para exibir opções
    public void menuInvestimento() {
        int opcao;

        do {
            System.out.println("\n=== Opções para Investimento ===\n" +
                    "1. Registrar novo Investimento\n" +
                    "2. Listar aplicações\n" +
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
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    public void listar(){
        try {
            InvestmentDao dao = new InvestmentDao();
            List<Investimento> investimentosList = dao.getAll();

            for (Investimento i : investimentosList){
                System.out.println("-----------------------------------");
                System.out.println("ID: " + i.getId());
                System.out.println("Ticker: " + i.getTicker());
                System.out.println("Tipo: " + i.getTipo());
                System.out.println("Valor Patrimônio: " + i.getValorpatrimonio());
                System.out.println("Data de Resgate: " + i.getDataResgate());
                System.out.println("Origem: " + i.getOrigem());
                System.out.println("ID do Usuário: " + i.getIdUsuario());
                System.out.println("-----------------------------------");
            }
            dao.fecharConexao();
        } catch (SQLException e){
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void registrar() {
        System.out.println("Digite o ticker:");
        String ticker = scanner.nextLine();

        System.out.println("Escolha o tipo de investimento:\n" +
                "1. Renda Fixa\n" +
                "2. Renda Variável\n" +
                "3. Fundos de Investimento\n" +
                "4. Investimentos Alternativos\n" +
                "\nSelecione a opção:");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        String tipo;

        switch (opcao){
            case 1:
                tipo = "Renda Fixa";
                break;
            case 2:
                tipo = "Renda Variável";
                break;
            case 3:
                tipo = "Fundos de Investimento";
                break;
            case 4:
                tipo = "Investimentos Alternativos";
                break;
            default:
                System.out.println("Tipo de investimento inválido!");
                return;
        }


        System.out.println("Digite o valor para resgate:");
        double valor = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Digite a data em que o resgate pode ser feito:");
        String resgate = scanner.nextLine();

        String origem = "MANUAL";

        int idConta = 2;

        try {
            Investimento investimento = new Investimento();
            investimento.setTicker(ticker);
            investimento.setTipo(tipo);
            investimento.setValorpatrimonio(valor);
            investimento.setDataResgate(resgate);
            investimento.setOrigem(origem);
            investimento.setIdUsuario(idConta);

            InvestmentDao dao = new InvestmentDao();
            dao.registrar(investimento);
            dao.fecharConexao();

            System.out.println("Investimento registrado com sucesso!");

        } catch (SQLException e){
            System.out.println("Erro: " + e.getMessage());
        }

    }
}
