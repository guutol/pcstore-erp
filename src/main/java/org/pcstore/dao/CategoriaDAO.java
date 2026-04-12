package org.pcstore.dao;

import org.pcstore.db.Conexao;
import org.pcstore.model.Categoria;

import java.sql.Connection;
import java.util.List;

public class CategoriaDAO {
    private Connection conn;

    public CategoriaDAO() {
        conn = Conexao.getConnection();
    }

    public void salvar(Categoria categoria){

    }
    public void alterar(Categoria categoria) {

    }
    public void excluir(int id){

    }
    public List<Categoria> listar(){
        return null;
    }
    public Categoria buscar(Categoria categoria){
        return null;
    }
}
