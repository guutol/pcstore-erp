package org.pcstore.service;

import org.pcstore.dao.FornecedorDAO;

public class FornecedorService {
    FornecedorDAO fDAO;

    public FornecedorService() {
        this.fDAO = new FornecedorDAO();
    }
}
