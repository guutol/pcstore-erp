package org.pcstore.controller;

import org.pcstore.dao.ProdutoDAO;

public class ProdutoController {
    private ProdutoDAO produtoDAO;

    public ProdutoController() {}

    public ProdutoController(ProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
    }

    public boolean buscarNomeMarca(String nome, String marca) {
        return true;
    }

    public boolean cadastro(String nome, String marca, int categoria_id, double preco, int quantidade_estoque, int fornecedor_id) {


        return true;
    }
}
