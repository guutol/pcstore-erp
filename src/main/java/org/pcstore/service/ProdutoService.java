package org.pcstore.service;

import org.pcstore.dao.ProdutoDAO;
import org.pcstore.model.Fornecedor;
import org.pcstore.model.Produto;

public class ProdutoService {
    ProdutoDAO pDAO;

    public ProdutoService() {
        this.pDAO = new ProdutoDAO();
    }

    public boolean cadastrarProduto(Produto novoProduto) {
        if(pDAO.consultar(novoProduto.getNome(), novoProduto.getMarca()) == null) {
            pDAO.incluir(novoProduto);
            return true;
        } else {
            return false;
        }
    }
}
