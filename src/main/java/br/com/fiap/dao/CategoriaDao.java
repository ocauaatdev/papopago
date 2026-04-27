package br.com.fiap.dao;

import br.com.fiap.exceptions.EntidadeNaoEncontradaException;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDao {
    private Connection conexao;

    public CategoriaDao() throws SQLException{
        conexao = ConnectionFactory.getConnection();
    }

    public void cadastrar(Categoria categoria) throws SQLException{
        PreparedStatement stm = conexao.prepareStatement("INSERT INTO T_PP_CATEGORIA (id_categoria, nm_categoria, ds_tipo_categoria)" +
                "VALUES (?,?,?)");

        stm.setInt(1, categoria.getId());
        stm.setString(2, categoria.getNomeCategoria());
        stm.setString(3, categoria.getTipo());

        stm.executeUpdate();
    }

    public List<Categoria> getAll() throws SQLException{
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM T_PP_CATEGORIA");
        ResultSet result = stm.executeQuery();
        List<Categoria> lista = new ArrayList<>();

        while (result.next()){
            lista.add(parseCategoria(result));
        }
        return lista;
    }

    public Categoria pesquisar(int id) throws SQLException, EntidadeNaoEncontradaException{
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM T_PP_CATEGORIA WHERE id_categoria = ?");
        stm.setInt(1, id);
        ResultSet result = stm.executeQuery();
        if (!result.next()){
            throw new EntidadeNaoEncontradaException("Categoria não encontrada");
        }
        return parseCategoria(result);
    }

    private Categoria parseCategoria(ResultSet result) throws SQLException{
        int id = result.getInt("id_categoria");
        String nome = result.getString("nm_categoria");
        String tipo = result.getString("ds_tipo_categoria");

        return new Categoria(id,nome,tipo);
    }

    //Fecha conexão com banco de dados
    public void fecharConexao() throws SQLException {
        conexao.close();
    }
}
