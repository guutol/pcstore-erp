package org.pcstore.service;

import org.pcstore.dao.CategoriaDAO;
import org.pcstore.model.Categoria;

import java.util.Scanner;

public class CategoriaService {
    private CategoriaDAO cDAO;

    public CategoriaService() {
        this.cDAO = new CategoriaDAO();
    }

    public boolean cadastrarCategoria(String nome) {
        Categoria categoria = new Categoria();
        if(cDAO.consultar(nome) == null) {
            categoria.setNome(nome);
            cDAO.incluir(categoria);
            return true;
        } else {
            return false;
        }
    }
}
