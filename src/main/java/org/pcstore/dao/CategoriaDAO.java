package org.pcstore.dao;

import org.pcstore.db.Conexao;
import org.pcstore.model.Categoria;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    public CategoriaDAO(){}

    public void incluir(Categoria categoria){
        try (Connection conn = Conexao.getConnection()){
            String sql = "INSERT INTO categorias (nome) VALUES (?);";
            PreparedStatement pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, categoria.getNome());
            pst.execute();
            ResultSet rs = pst.getGeneratedKeys();
            if(rs.next())
                categoria.setId(rs.getInt(1));
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
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void excluir(int id){
        try (Connection conn = Conexao.getConnection()){
            String sql = "DELETE FROM categorias WHERE id=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<Categoria> listar(){
        List<Categoria> lista = new ArrayList<>();
        try (Connection conn = Conexao.getConnection()){
            String sql = "SELECT id, nome FROM categorias";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");

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
            ResultSet rs = pst.executeQuery();
            if(rs.next()) {
                int idDb = rs.getInt("id");
                String nome = rs.getString("nome");

                categoria = new Categoria();
                categoria.setId(idDb);
                categoria.setNome(nome);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categoria;
    }

    public Categoria consultar(String nome) {
        Categoria categoria = null;
        try (Connection conn = Conexao.getConnection()) {
            String sql = "SELECT id, nome FROM categorias WHERE nome=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, nome);
            ResultSet rs = pst.executeQuery();
            if(rs.next()) {
                categoria = new Categoria();
                categoria.setId(rs.getInt("id"));
                categoria.setNome(rs.getString("nome"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categoria;
    }
}
