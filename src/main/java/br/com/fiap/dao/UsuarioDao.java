package br.com.fiap.dao;

import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDao {
    private Connection conexao;

    //Construtor:
    public UsuarioDao() throws SQLException{
     conexao = ConnectionFactory.getConnection();
    }

    public void cadastrar(Usuario usuario) throws SQLException{
        PreparedStatement stm = conexao.prepareStatement
                ("INSERT INTO T_PP_USUARIO (id_usuario, nm_usuario, dt_nascimento, nr_telefone, eml_usuario, sen_senha, nr_cpf)" +
                        "VALUES (?, ?, ?, ?, ?, ?, ?)");

        stm.setInt(1, usuario.getId());
        stm.setString(2, usuario.getNome());
        stm.setString(3, usuario.getDataNascimento());
        stm.setString(4, usuario.getNumeroTelefone());
        stm.setString(5, usuario.getEmail());
        stm.setString(6, usuario.getSenha());
        stm.setString(7, usuario.getCpf());
        stm.executeUpdate();

    }

    //Fecha conexão com banco de dados
    public void fecharConexao() throws SQLException {
        conexao.close();
    }

    //atualizar...
    //deletar...
    //listar...
}
