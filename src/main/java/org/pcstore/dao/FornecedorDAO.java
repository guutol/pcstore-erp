package org.pcstore.dao;

import org.pcstore.db.Conexao;
import org.pcstore.model.Categoria;
import org.pcstore.model.Fornecedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLOutput;
import java.util.ArrayList;
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
            pst.executeUpdate();
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
            pst.executeUpdate();
            System.out.println("Fornecedor excluído com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<Fornecedor> listar(){
        List<Fornecedor> lista = new ArrayList<>();
        try (Connection conn = Conexao.getConnection()){
            String sql = "SELECT id, nome FROM fornecedores";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet result = pst.executeQuery();
            while(result.next()) {
                int id = result.getInt("id");
                String nome = result.getString("nome");

                Fornecedor fornecedores = new Fornecedor();
                fornecedores.setId(id);
                fornecedores.setNome(nome);

                lista.add(fornecedores);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    public Fornecedor buscar(int id){
        Fornecedor fornecedor = null;
        try (Connection conn = Conexao.getConnection()){
            String sql = "SELECT id, nome FROM fornecedores WHERE id=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet result = pst.executeQuery();
            if(result.next()) {
                int idDb = result.getInt("id");
                String nome = result.getString("nome");

                fornecedor = new Fornecedor();
                fornecedor.setId(idDb);
                fornecedor.setNome(nome);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fornecedor;
    }
}
