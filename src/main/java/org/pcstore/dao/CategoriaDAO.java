package org.pcstore.dao;

import org.pcstore.db.Conexao;
import org.pcstore.model.Categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
    public void alterar(Categoria categoria) {
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
    public List<Categoria> listar(){
        try (Connection conn = Conexao.getConnection()){

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    public Categoria buscar(Categoria categoria){
        try (Connection conn = Conexao.getConnection()){

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
