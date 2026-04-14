package org.pcstore.dao;

import org.pcstore.db.Conexao;
import org.pcstore.model.Categoria;
import org.pcstore.model.Fornecedor;
import org.pcstore.model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    public ProdutoDAO(){}

    public void incluir(Produto produto) {
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

    public void alterar(int id, Produto produto) {
        try (Connection conn = Conexao.getConnection()){
            String sql = "UPDATE produtos SET nome=?, marca=?, categoria_id=?, preco=?, quantidade_estoque=?, fornecedor_id=? WHERE id=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, produto.getNome());
            pst.setString(2, produto.getMarca());
            pst.setInt(3, produto.getCategoria().getId());
            pst.setDouble(4, produto.getPreco());
            pst.setInt(5, produto.getQuantidade_estoque());
            pst.setInt(6, produto.getFornecedor().getId());
            pst.setInt(7, id);
            pst.executeUpdate();
            System.out.println("Categoria alterado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        try (Connection conn = Conexao.getConnection()){
            String sql = "DELETE FROM produtos WHERE id=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("Produto excluído com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Produto> listar() {
        List<Produto> lista = new ArrayList<>();
        try (Connection conn = Conexao.getConnection()) {
            String sql = "SELECT id, nome, marca, categoria_id, preco, quantidade_estoque, fornecedor_id FROM produtos";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet result = pst.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String nome = result.getString("nome");
                String marca = result.getString("marca");
                int categoriaId = result.getInt("categoria_id");
                double preco = result.getDouble("preco");
                int quantidade = result.getInt("quantidade_estoque");
                int fornecedorId = result.getInt("fornecedor_id");

                Categoria categoria = new Categoria();
                categoria.setId(categoriaId);

                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId(fornecedorId);

                Produto produto = new Produto();
                produto.setId(id);
                produto.setNome(nome);
                produto.setMarca(marca);
                produto.setCategoria(categoria);
                produto.setPreco(preco);
                produto.setQuantidade_estoque(quantidade);
                produto.setFornecedor(fornecedor);

                lista.add(produto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Produto buscar(int id) {
        Produto produto = null;
        try (Connection conn = Conexao.getConnection()) {
            String sql = "SELECT id, nome, marca, categoria_id, preco, quantidade_estoque, fornecedor_id FROM produtos WHERE id=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet result = pst.executeQuery();

            if (result.next()) {
                int idDb = result.getInt("id");
                String nome = result.getString("nome");
                String marca = result.getString("marca");
                int categoriaId = result.getInt("categoria_id");
                double preco = result.getDouble("preco");
                int quantidade = result.getInt("quantidade_estoque");
                int fornecedorId = result.getInt("fornecedor_id");

                Categoria categoria = new Categoria();
                categoria.setId(categoriaId);

                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId(fornecedorId);

                produto = new Produto();
                produto.setId(idDb);
                produto.setNome(nome);
                produto.setMarca(marca);
                produto.setCategoria(categoria);
                produto.setPreco(preco);
                produto.setQuantidade_estoque(quantidade);
                produto.setFornecedor(fornecedor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return produto;
    }
}
