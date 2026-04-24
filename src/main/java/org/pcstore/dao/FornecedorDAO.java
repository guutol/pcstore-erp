package org.pcstore.dao;

import org.pcstore.db.Conexao;
import org.pcstore.model.Fornecedor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAO {

    public FornecedorDAO(){}

    public void incluir(Fornecedor fornecedor){
        try (Connection conn = Conexao.getConnection()){
            String sql = "INSERT INTO fornecedores (nome, cnpj, telefone, email) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, fornecedor.getNome());
            pst.setString(2, fornecedor.getCnpj());
            pst.setString(3, fornecedor.getTelefone());
            pst.setString(4, fornecedor.getEmail());
            pst.executeUpdate();

            ResultSet rs = pst.getGeneratedKeys();
            if(rs.next()) {
                fornecedor.setId(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void alterar(int id, Fornecedor fornecedor) {
        try (Connection conn = Conexao.getConnection()){
            String sql = "UPDATE fornecedores SET nome=?, cnpj=?, telefone=?, email=? WHERE id=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, fornecedor.getNome());
            pst.setString(2, fornecedor.getCnpj());
            pst.setString(3, fornecedor.getTelefone());
            pst.setString(4, fornecedor.getEmail());
            pst.setInt(5, id);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id){
        try (Connection conn = Conexao.getConnection()){
            String sql = "DELETE FROM fornecedores WHERE id=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Fornecedor> listar(){
        List<Fornecedor> lista = new ArrayList<>();
        try (Connection conn = Conexao.getConnection()){
            String sql = "SELECT id, nome, cnpj, telefone, email FROM fornecedores";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet result = pst.executeQuery();

            while(result.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId(result.getInt("id"));
                fornecedor.setNome(result.getString("nome"));
                fornecedor.setCnpj(result.getString("cnpj"));
                fornecedor.setTelefone(result.getString("telefone"));
                fornecedor.setEmail(result.getString("email"));

                lista.add(fornecedor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Fornecedor buscar(int id){
        Fornecedor fornecedor = null;
        try (Connection conn = Conexao.getConnection()){
            String sql = "SELECT id, nome, cnpj, telefone, email FROM fornecedores WHERE id=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet result = pst.executeQuery();

            if(result.next()) {
                fornecedor = new Fornecedor();
                fornecedor.setId(result.getInt("id"));
                fornecedor.setNome(result.getString("nome"));
                fornecedor.setCnpj(result.getString("cnpj"));
                fornecedor.setTelefone(result.getString("telefone"));
                fornecedor.setEmail(result.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fornecedor;
    }

    public Fornecedor consultar(String nome) {
        Fornecedor fornecedor = null;
        try (Connection conn = Conexao.getConnection()) {
            String sql = "SELECT id, nome, cnpj, telefone, email FROM fornecedores WHERE nome=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, nome);
            ResultSet rs = pst.executeQuery();

            if(rs.next()) {
                fornecedor = new Fornecedor();
                fornecedor.setId(rs.getInt("id"));
                fornecedor.setNome(rs.getString("nome"));
                fornecedor.setCnpj(rs.getString("cnpj"));
                fornecedor.setTelefone(rs.getString("telefone"));
                fornecedor.setEmail(rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fornecedor;
    }
}