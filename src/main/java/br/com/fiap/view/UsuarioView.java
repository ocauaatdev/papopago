package br.com.fiap.view;

import br.com.fiap.dao.UsuarioDao;
import br.com.fiap.model.Usuario;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class UsuarioView {
    private Scanner scanner = new Scanner(System.in);

    //Metodo para exibir opções do Usuário
    public void menuUsuario(){
        int opcao;

        do {
            System.out.println("\n=== Opções para Usuário ===\n" +
                    "1. Cadastrar Usuário\n" +
                    "2. Listar Usuários\n" +
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

    //Metodo para cadastrar informações do Usuario
    public void cadastrar(){
            System.out.println("Digite seu nome: ");
            String nome = scanner.nextLine();

            System.out.println("Digite seu e-mail:");
            String email = scanner.nextLine();

            System.out.println("Digite sua data de nascimento:");
            String dtNascimento = scanner.nextLine();

            System.out.println("Digite seu telefone:");
            String telefone = scanner.nextLine();

            System.out.println("Digite seu CPF:");
            String cpf = scanner.nextLine();

            System.out.println("Digite sua senha:");
            String senha = scanner.nextLine();

        try {
            UsuarioDao dao = new UsuarioDao();
            Usuario usuario = new Usuario();
            usuario.setNome(nome);
            usuario.setEmail(email);
            usuario.setDataNascimento(dtNascimento);
            usuario.setNumeroTelefone(telefone);
            usuario.setCpf(cpf);
            usuario.setSenha(senha);
            dao.cadastrar(usuario);
            dao.fecharConexao();

            System.out.println("Usuário Cadastrado!");
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    //Metodo para listar todos usuários do banco
    private void listar(){
        try {
            UsuarioDao dao = new UsuarioDao();
            List<Usuario> usuarios = dao.getAll();

            //para cada usuario dentro da List de usuarios faça:
            for (Usuario usuario : usuarios){
                System.out.println("Id: " + usuario.getId() + " - " + usuario.getNome() + ", nascido na data: "
                        + usuario.getDataNascimento() + ", CPF: " + usuario.getCpf() + ", e-mail: " + usuario.getEmail() + " - telefone: " +
                        usuario.getNumeroTelefone() + ", senha: " + usuario.getSenha());
            }

            dao.fecharConexao();
        }catch (SQLException e){
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
