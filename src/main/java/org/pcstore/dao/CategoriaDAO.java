package org.pcstore.dao;

import org.pcstore.db.Conexao;
import org.pcstore.model.Categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    public CategoriaDAO(){}

    public void incluir(Categoria categoria){
        try (Connection conn = Conexao.getConnection()){
            String sql = "INSERT INTO categorias (nome) VALUES (?);";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, categoria.getNome());
            pst.execute();
            System.out.println("Categoria inserida com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void alterar(int id, Categoria categoria) {
        try (Connection conn = Conexao.getConnection()){
            String sql = "UPDATE categorias SET nome=? WHERE id=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, categoria.getNome());
            pst.setInt(2, id);
            pst.execute();
            System.out.println("Categoria alterado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void excluir(int id){
        try (Connection conn = Conexao.getConnection()){
            String sql = "DELETE FROM categorias WHERE id=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            System.out.println("Categoria excluída com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<Categoria> listar(){
        List<Categoria> lista = new ArrayList<>();
        try (Connection conn = Conexao.getConnection()){
            String sql = "SELECT id, nome FROM categorias";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet result = pst.executeQuery();
            while(result.next()) {
                int id = result.getInt("id");
                String nome = result.getString("nome");

                Categoria categoria = new Categoria();
                categoria.setId(id);
                categoria.setNome(nome);

                lista.add(categoria);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    public Categoria buscar(int id){
        Categoria categoria = null;
        try (Connection conn = Conexao.getConnection()){
            String sql = "SELECT id, nome FROM categorias WHERE id=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet result = pst.executeQuery();
            if(result.next()) {
                int idDb = result.getInt("id");
                String nome = result.getString("nome");

                categoria = new Categoria();
                categoria.setId(idDb);
                categoria.setNome(nome);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categoria;
    }
}
