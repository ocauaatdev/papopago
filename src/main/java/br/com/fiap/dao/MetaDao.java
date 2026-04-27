package br.com.fiap.dao;

import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Meta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MetaDao {
    private Connection conexao;

    // Construtor que recebe/cria a conexão
    public MetaDao() throws SQLException {
        this.conexao = ConnectionFactory.getConnection();
    }

    // CREATE: Método para cadastrar uma nova Meta
    public void cadastrar(Meta meta) throws SQLException {
        PreparedStatement stm = conexao.prepareStatement(
                "INSERT INTO T_PP_META (id_meta, nm_meta, vl_objetivo, vl_acumulado, dt_inicio, dt_fim, st_meta) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?)"
        );

        stm.setInt(1, meta.getId());
        stm.setString(2, meta.getNome());
        stm.setDouble(3, meta.getValorObjetivo());
        stm.setDouble(4, meta.getValorAcumulado());
        stm.setString(5, meta.getDataInicio());
        stm.setString(6, meta.getDataFim());
        stm.setString(7, meta.getStatus());

        stm.executeUpdate();
    }

    // READ: Método para buscar todas as Metas
    public List<Meta> getAll() throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM T_PP_META");
        ResultSet result = stm.executeQuery();
        List<Meta> lista = new ArrayList<>();

        while (result.next()) {
            int id = result.getInt("id_meta");
            String nome = result.getString("nm_meta");
            double vlObjetivo = result.getDouble("vl_objetivo");
            double vlAcumulado = result.getDouble("vl_acumulado");
            String dtInicio = result.getString("dt_inicio");
            String dtFim = result.getString("dt_fim");
            String status = result.getString("st_meta");

            // Adiciona à lista usando o construtor da classe Meta
            lista.add(new Meta(id, nome, vlObjetivo, vlAcumulado, dtInicio, dtFim, status));
        }
        return lista;
    }

    // UPDATE: Exemplo de método para atualizar o progresso da meta
    public void atualizar(Meta meta) throws SQLException {
        PreparedStatement stm = conexao.prepareStatement(
                "UPDATE T_PP_META SET nm_meta = ?, vl_objetivo = ?, vl_acumulado = ?, " +
                        "dt_inicio = ?, dt_fim = ?, st_meta = ? WHERE id_meta = ?"
        );
        stm.setString(1, meta.getNome());
        stm.setDouble(2, meta.getValorObjetivo());
        stm.setDouble(3, meta.getValorAcumulado());
        stm.setString(4, meta.getDataInicio());
        stm.setString(5, meta.getDataFim());
        stm.setString(6, meta.getStatus());
        stm.setInt(7, meta.getId());

        stm.executeUpdate();
    }

    // DELETE: Método para excluir uma meta pelo ID
    public void remover(int id) throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("DELETE FROM T_PP_META WHERE id_meta = ?");
        stm.setInt(1, id);
        stm.executeUpdate();
    }

    // Fecha a conexão com o banco de dados
    public void fecharConexao() throws SQLException {
        if (conexao != null && !conexao.isClosed()) {
            conexao.close();
        }
    }
}
