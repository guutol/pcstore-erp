package org.pcstore.service;

import org.pcstore.dao.ProdutoDAO;

public class ProdutoService {
    ProdutoDAO pDAO;

    public ProdutoService() {
        this.pDAO = new ProdutoDAO();
    }
}
