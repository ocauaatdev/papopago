package br.com.fiap.dao;

import br.com.fiap.exceptions.EntidadeNaoEncontradaException;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.InstituicaoFinanceira;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InstituicaoFinanceiraDao {
    private Connection conexao;

    public InstituicaoFinanceiraDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    public void cadastrar(InstituicaoFinanceira instituicaofinanceira) throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("INSERT INTO T_PP_BANK (id_bank, nm_bank, cd_bacen)" +
                "VALUES (?,?,?)");
        stm.setInt(1, instituicaofinanceira.getId());
        stm.setString(2, instituicaofinanceira.getNome());
        stm.setInt(3,instituicaofinanceira.getCodigoBacen());

        stm.executeUpdate();

    }
    public List<InstituicaoFinanceira> getAll() throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM T_PP_BANK");
        ResultSet result = stm.executeQuery();
        List<InstituicaoFinanceira> lista = new ArrayList<>();

        while (result.next()){
            lista.add(parseInstituicaoFinanceira(result));
        }
        return lista;
    }


    public InstituicaoFinanceira pesquisar(int id) throws SQLException, EntidadeNaoEncontradaException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM T_PP_BANK WHERE id = ?");
        stm.setInt(1, id);
        ResultSet result = stm.executeQuery();
        if (!result.next()){
            throw new EntidadeNaoEncontradaException("Categoria não encontrada");
        }
        return parseInstituicaoFinanceira(result);
    }

    private InstituicaoFinanceira parseInstituicaoFinanceira(ResultSet result) throws SQLException{
        int id = result.getInt("id_bank");
        String nome = result.getString("nm_bank");
        int codigoBacen = result.getInt("cd_bacen");

        return new InstituicaoFinanceira(id,nome,codigoBacen);
    }
    public void fecharConexao() throws SQLException {
        conexao.close();
    }
}
