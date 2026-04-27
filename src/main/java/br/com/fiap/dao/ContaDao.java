package br.com.fiap.dao;

import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Conta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContaDao {
    private Connection conexao;

    public ContaDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    public void cadastrar(Conta conta) throws SQLException {
        String sql = "INSERT INTO T_PP_CONTA (id_conta, nm_conta, nr_saldo, id_usuario, id_bank) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setInt(1, conta.getId());
        stm.setString(2, conta.getNomeConta());
        stm.setDouble(3, conta.getSaldo());
        stm.setInt(4, conta.getId_usuario());
        stm.setInt(5, conta.getId_inst_fin());

        stm.executeUpdate();
        stm.close();
    }

    public List<Conta> getAll() throws SQLException {
        List<Conta> lista = new ArrayList<>();
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM T_PP_CONTA");
        ResultSet result = stm.executeQuery();

        while (result.next()){
            int id = result.getInt("id_conta");
            String nome = result.getString("nm_conta");
            double saldo = result.getDouble("nr_saldo");
            int idUsuario = result.getInt("id_usuario");
            int idBank = result.getInt("id_bank");

            lista.add(new Conta(id, nome, saldo, idUsuario, idBank));
        }
        return lista;
    }

    public void fecharConexao() throws SQLException {
        conexao.close();
    }

}
