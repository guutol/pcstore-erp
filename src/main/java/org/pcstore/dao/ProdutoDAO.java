package org.pcstore.dao;

import org.pcstore.db.Conexao;
import org.pcstore.model.Categoria;
import org.pcstore.model.Fornecedor;
import org.pcstore.model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    public ProdutoDAO(){}

    public void incluir(Produto produto) {
        try (Connection conn = Conexao.getConnection()){
            String sql = "INSERT INTO produtos (nome, marca, categoria_id, preco, quantidade_estoque, fornecedor_id) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, produto.getNome());
            pst.setString(2, produto.getMarca());
            pst.setInt(3, produto.getCategoria().getId());
            pst.setDouble(4, produto.getPreco());
            pst.setInt(5, produto.getQuantidade_estoque());
            pst.setInt(6, produto.getFornecedor().getId());
            pst.executeUpdate();

            ResultSet rs = pst.getGeneratedKeys();
            if(rs.next()) {
                produto.setId(rs.getInt(1));
            }
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Produto> listar() {
        List<Produto> lista = new ArrayList<>();
        try (Connection conn = Conexao.getConnection()) {
            String sql = "SELECT p.id, p.nome, p.marca, p.preco, p.quantidade_estoque, " +
                    "c.id AS categoria_id, c.nome AS categoria_nome, " +
                    "f.id AS fornecedor_id, f.nome AS fornecedor_nome, f.cnpj, f.telefone, f.email " +
                    "FROM produtos p " +
                    "JOIN categorias c ON p.categoria_id = c.id " +
                    "JOIN fornecedores f ON p.fornecedor_id = f.id " +
                    "ORDER BY p.id";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                lista.add(montarProduto(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Produto buscar(int id) {
        Produto produto = null;
        try (Connection conn = Conexao.getConnection()) {
            String sql = "SELECT p.id, p.nome, p.marca, p.preco, p.quantidade_estoque, " +
                    "c.id AS categoria_id, c.nome AS categoria_nome, " +
                    "f.id AS fornecedor_id, f.nome AS fornecedor_nome, f.cnpj, f.telefone, f.email " +
                    "FROM produtos p " +
                    "JOIN categorias c ON p.categoria_id = c.id " +
                    "JOIN fornecedores f ON p.fornecedor_id = f.id " +
                    "WHERE p.id=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                produto = montarProduto(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return produto;
    }

    public Produto consultar(String nome, String marca) {
        Produto produto = null;
        try (Connection conn = Conexao.getConnection()) {
            String sql = "SELECT p.id, p.nome, p.marca, p.preco, p.quantidade_estoque, " +
                    "c.id AS categoria_id, c.nome AS categoria_nome, " +
                    "f.id AS fornecedor_id, f.nome AS fornecedor_nome, f.cnpj, f.telefone, f.email " +
                    "FROM produtos p " +
                    "JOIN categorias c ON p.categoria_id = c.id " +
                    "JOIN fornecedores f ON p.fornecedor_id = f.id " +
                    "WHERE p.nome=? AND p.marca=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, nome);
            pst.setString(2, marca);
            ResultSet rs = pst.executeQuery();

            if(rs.next()) {
                produto = montarProduto(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return produto;
    }

    private Produto montarProduto(ResultSet rs) throws Exception {
        Categoria categoria = new Categoria();
        categoria.setId(rs.getInt("categoria_id"));
        categoria.setNome(rs.getString("categoria_nome"));

        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setId(rs.getInt("fornecedor_id"));
        fornecedor.setNome(rs.getString("fornecedor_nome"));
        fornecedor.setCnpj(rs.getString("cnpj"));
        fornecedor.setTelefone(rs.getString("telefone"));
        fornecedor.setEmail(rs.getString("email"));

        Produto produto = new Produto();
        produto.setId(rs.getInt("id"));
        produto.setNome(rs.getString("nome"));
        produto.setMarca(rs.getString("marca"));
        produto.setCategoria(categoria);
        produto.setPreco(rs.getDouble("preco"));
        produto.setQuantidade_estoque(rs.getInt("quantidade_estoque"));
        produto.setFornecedor(fornecedor);

        return produto;
    }
}
