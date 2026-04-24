package br.com.fiap.dao;

import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Categoria;
import br.com.fiap.model.Transacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransacaoDao {

    private Connection conexao;

    public TransacaoDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    public void registrar(Transacao transacao) throws SQLException{
        PreparedStatement stm = conexao.prepareStatement("INSERT INTO T_PP_TRANSACAO (id_transacao, ds_transacao, vl_transacao, dt_transacao, ds_origem, id_conta, id_categoria)" +
                "VALUES(?,?,?,?,?,?,?)");

        stm.setInt(1, transacao.getId());
        stm.setString(2, transacao.getDescricao());
        stm.setDouble(3, transacao.getValor());
        stm.setString(4, transacao.getData());
        stm.setString(5, transacao.getOrigem());
        stm.setInt(6, transacao.getId_conta());
        stm.setInt(7, transacao.getId_categoria());

        stm.executeUpdate();
    }

    public List<Transacao> getAll() throws SQLException{
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM T_PP_TRANSACAO");
        ResultSet result = stm.executeQuery();
        List<Transacao> lista = new ArrayList<>();

        while (result.next()){
            int id = result.getInt("id_transacao");
            String descricao = result.getString("ds_transacao");
            double valor = result.getDouble("vl_transacao");
            String data = result.getString("dt_transacao");
            String origem = result.getString("ds_origem");
            int idConta = result.getInt("id_conta");
            int idCategoria = result.getInt("id_categoria");

            lista.add(new Transacao(id, descricao, valor, data, origem, idConta, idCategoria));
        }
        return lista;
    }

    public void fecharConexao() throws SQLException {
        conexao.close();
    }
}
