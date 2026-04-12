package org.pcstore.dao;

import org.pcstore.db.Conexao;
import org.pcstore.model.Categoria;
import org.pcstore.model.Fornecedor;
import org.pcstore.model.Produto;

import java.sql.Connection;
import java.util.List;

public class ProdutoDAO {

    public ProdutoDAO(){}

    public void incluir(Produto produto){
        try (Connection conn = Conexao.getConnection()){

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
