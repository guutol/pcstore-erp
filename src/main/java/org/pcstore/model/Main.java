package org.pcstore.model;

import org.pcstore.dao.CategoriaDAO;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Categoria categoria = new Categoria();
        categoria.setNome("Processador");
        System.out.println("Testando inserção de categoria...");
        CategoriaDAO dao = new CategoriaDAO();
        dao.incluir(categoria);
    }
}
