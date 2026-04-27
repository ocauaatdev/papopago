package br.com.fiap.dao;

import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Investimento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InvestmentDao {
    private Connection conexao;

    public InvestmentDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    public void registrar(Investimento investment) throws SQLException{
        PreparedStatement stm = conexao.prepareStatement("INSERT INTO T_PP_INVESTMENT (id_investment, cd_ticker, ds_tipo, dt_resgate, vl_patrimonio, ds_origem, id_usuario)" +
                "VALUES(?,?,?,?,?,?,?)");


        stm.setInt(1, investment.getId());
        stm.setString(2, investment.getTicker());
        stm.setString(3, investment.getTipo());
        stm.setString(4, investment.getDataResgate());
        stm.setDouble(5, investment.getValorpatrimonio());
        stm.setString(6, investment.getOrigem());
        stm.setInt(7, investment.getIdUsuario());

        stm.executeUpdate();
    }

    public List<Investimento> getAll() throws SQLException{
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM T_PP_INVESTMENT");
        ResultSet result = stm.executeQuery();
        List<Investimento> lista = new ArrayList<>();

        while (result.next()){
            int id = result.getInt("id_investment");
            String ticker = result.getString("cd_ticker");
            String tipo = result.getString("ds_tipo");
            String dataResgate = result.getString("dt_resgate");
            double valorpatrimonio = result.getDouble("vl_patrimonio");
            String origem = result.getString("ds_origem");
            int idUsuario = result.getInt("id_usuario");

            lista.add (new Investimento (id, ticker, tipo, valorpatrimonio, dataResgate, origem, idUsuario));
        }
        return lista;
    }

    public void fecharConexao() throws SQLException {
        conexao.close();
    }
}
