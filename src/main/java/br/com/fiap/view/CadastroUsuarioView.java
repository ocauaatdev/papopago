package br.com.fiap.view;

import br.com.fiap.dao.UsuarioDao;
import br.com.fiap.model.Usuario;

import java.sql.SQLException;

public class CadastroUsuarioView {
    public static void main(String[] args) {
        try{
            UsuarioDao dao = new UsuarioDao();
            Usuario joaquim = new Usuario(1, "Joaquim", "joaquim@exemplo.com", "15/08/1989"
                    , "11-99999999", "Senha#12345", "314.798.530-03");

            dao.cadastrar(joaquim);
            dao.fecharConexao();
            System.out.println("Usuario cadastrado com sucesso");

        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
