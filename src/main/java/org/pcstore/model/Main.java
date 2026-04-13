package org.pcstore.model;

import org.pcstore.dao.CategoriaDAO;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Categoria categoria = new Categoria();
        CategoriaDAO dao = new CategoriaDAO();

        categoria = dao.buscar(2);
        if(categoria != null)
            System.out.println(categoria.getId() + " " + categoria.getNome());
        else
            System.out.println("Não foi possível localizar a categoria pelo id!");
    }
}
