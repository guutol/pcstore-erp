package org.pcstore.dao;

import org.pcstore.db.Conexao;
import org.pcstore.model.Categoria;
import org.pcstore.model.Fornecedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLOutput;
import java.util.List;

public class FornecedorDAO {

    public FornecedorDAO(){}

    public void incluir(Fornecedor fornecedor){
        try (Connection conn = Conexao.getConnection()){
            String sql = "INSERT INTO fornecedores (nome, cnpj, telefone, email) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, fornecedor.getNome());
            pst.setString(2, fornecedor.getCnpj());
            pst.setString(3, fornecedor.getTelefone());
            pst.setString(4, fornecedor.getEmail());
            pst.execute();
            System.out.println("Fornecedor inserido com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void alterar(Fornecedor fornecedor) {
        try (Connection conn = Conexao.getConnection()){
            String sql = "UPDATE fornecedores SET nome=? WHERE id=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, fornecedor.getNome());
            pst.execute();
            System.out.println("Fornecedor alterado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void excluir(int id){
        try (Connection conn = Conexao.getConnection()){
            String sql = "DELETE FROM fornecedores WHERE id=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            System.out.println("Fornecedor excluído com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<Fornecedor> listar(){
        try (Connection conn = Conexao.getConnection()){

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public Categoria buscar(Fornecedor fornecedor){
        try (Connection conn = Conexao.getConnection()){

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
