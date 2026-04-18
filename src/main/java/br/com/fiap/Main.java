package br.com.fiap;

import br.com.fiap.exceptions.UsuarioNaoEncontradoException;
import br.com.fiap.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try{
            Connection conexao = ConnectionFactory.getConnection();
            System.out.println("Conexão realizada!");
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }

//        System.out.println("__________                     __________                        \n" +
//                "\\______   \\_____  ______   ____\\______   \\_____     ____   ____  \n" +
//                " |     ___/\\__  \\ \\____ \\ /  _ \\|     ___/\\__  \\   / ___\\ /  _ \\ \n" +
//                " |    |     / __ \\|  |_> >  <_> )    |     / __ \\_/ /_/  >  <_> )\n" +
//                " |____|    (____  /   __/ \\____/|____|    (____  /\\___  / \\____/ \n" +
//                "                \\/|__|                         \\//_____/         ");
//
//        System.out.println("===================================\n" +
//                "SEJA BEM VINDO");
//
//        Scanner scanner = new Scanner(System.in);
//        int opcao = -1;
//
//        System.out.println("Selecione uma opção:\n" +
//                "1. Cadastrar Usuario\n" +
//                "2. Registrar ganho\n" +
//                "3. Registrar gasto\n" +
//                "4. Registrar investimento\n" +
//                "5. Criar nova meta\n" +
//                "6. Cadastrar nova conta\n" +
//                "7. Cadastrar Instituição Financeira\n");
//
//
//        switch (opcao = scanner.nextInt()){
//            case 1:
//                System.out.println("opcao 1");
//            case 2:
//                System.out.println("opcao 2");
//            case 3:
//                System.out.println("opcao 3");
//            case 4:
//                System.out.println("opcao 4");
//            case 5:
//                System.out.println("opcao 5");
//            case 6:
//                System.out.println("opcao 6");
//            case 7:
//                System.out.println("opcao 7");
//            default:
//                System.out.println("Opção inválida!");
//        }
//
//
//        scanner.close();
    }
}