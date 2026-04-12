package org.pcstore.dao;

import org.pcstore.db.Conexao;
import org.pcstore.model.Categoria;
import org.pcstore.model.Fornecedor;

import java.sql.Connection;
import java.util.List;

public class FornecedorDAO {

    public FornecedorDAO(){}

    public void incluir(Fornecedor fornecedor){
        try (Connection conn = Conexao.getConnection()){

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void alterar(Fornecedor fornecedor) {
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
