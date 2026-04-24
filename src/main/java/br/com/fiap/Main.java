package br.com.fiap;

import br.com.fiap.view.CategoriaView;
import br.com.fiap.view.TransacaoView;
import br.com.fiap.view.UsuarioView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println(" ____                          ____                           \n" +
                    "/\\  _`\\                       /\\  _`\\                         \n" +
                    "\\ \\ \\L\\ \\ __     _____     ___\\ \\ \\L\\ \\ __       __     ___   \n" +
                    " \\ \\ ,__/'__`\\  /\\ '__`\\  / __`\\ \\ ,__/'__`\\   /'_ `\\  / __`\\ \n" +
                    "  \\ \\ \\/\\ \\L\\.\\_\\ \\ \\L\\ \\/\\ \\L\\ \\ \\ \\/\\ \\L\\.\\_/\\ \\L\\ \\/\\ \\L\\ \\\n" +
                    "   \\ \\_\\ \\__/.\\_\\\\ \\ ,__/\\ \\____/\\ \\_\\ \\__/.\\_\\ \\____ \\ \\____/\n" +
                    "    \\/_/\\/__/\\/_/ \\ \\ \\/  \\/___/  \\/_/\\/__/\\/_/\\/___L\\ \\/___/ \n" +
                    "                   \\ \\_\\                         /\\____/      \n" +
                    "                    \\/_/                         \\_/__/       ");

            System.out.println("=================================");
            System.out.println("BEM VINDO(A)\n" +
                    "Selecione uma opção:\n" +
                    "1. Opções de Usuário\n" +
                    "2. Opções de Conta\n" +
                    "3. Opções de Transação\n" +
                    "4. Opções de Investimento\n" +
                    "5. Opções de Meta\n" +
                    "6. Opções de Instituição Financeira\n" +
                    "7. Opções de Categoria\n" +
                    "0. Sair");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao){
                case 1:
                    new UsuarioView().menuUsuario();
                    break;
                case 2:
                    //chama a view da Conta
                case 3:
                    new TransacaoView().menuTransacao();
                    break;
                case 4:
                    //chama view de Investimento
                case 5:
                    //chama a view de Meta
                case 6:
                    //chama a view de Instituição Financeira
                case 7:
                    new CategoriaView().menuCategoria();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }
        }while (opcao != 0);
        scanner.close();

    }
}