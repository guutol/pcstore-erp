package org.pcstore.dao;

import org.pcstore.db.Conexao;
import org.pcstore.model.Categoria;
import org.pcstore.model.Fornecedor;
import org.pcstore.model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class ProdutoDAO {

    public ProdutoDAO(){}

    public void incluir(Produto produto){
        try (Connection conn = Conexao.getConnection()){
            String sql = "INSERT INTO produtos (nome, marca, categoria_id, preco, quantidade_estoque, fornecedor_id VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, produto.getNome());
            pst.setString(2, produto.getMarca());
            pst.setInt(3, produto.getCategoria().getId());
            pst.setDouble(4, produto.getPreco());
            pst.setInt(5, produto.getQuantidade_estoque());
            pst.setInt(6, produto.getFornecedor().getId());
            pst.execute();
            System.out.println("Produto inserido com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void alterar(Produto produto) {
        try (Connection conn = Conexao.getConnection()){

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void excluir(int id){
        try (Connection conn = Conexao.getConnection()){

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<Produto> listar(){
        try (Connection conn = Conexao.getConnection()){

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public Categoria buscar(Produto produto){
        try (Connection conn = Conexao.getConnection()){

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
