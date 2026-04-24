package org.pcstore.service;

import org.pcstore.dao.FornecedorDAO;
import org.pcstore.model.Categoria;
import org.pcstore.model.Fornecedor;

public class FornecedorService {
    FornecedorDAO fDAO;

    public FornecedorService() {
        this.fDAO = new FornecedorDAO();
    }

    public boolean cadastrarFornecedor(Fornecedor novoFornecedor) {
        if(fDAO.consultar(novoFornecedor.getNome()) == null) {
            novoFornecedor.setNome(novoFornecedor.getNome());
            fDAO.incluir(novoFornecedor);
            return true;
        } else {
            return false;
        }
    }

    public void alterarFornecedor(int id, Fornecedor fornecedorNovo) {
        fDAO.alterar(id, fornecedorNovo);
    }

    public void excluirFornecedor(int id) {
        fDAO.excluir(id);
    }
}
