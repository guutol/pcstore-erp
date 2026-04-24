package org.pcstore.service;

import org.pcstore.dao.ProdutoDAO;
import org.pcstore.model.Produto;

import java.util.List;

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

    public boolean alterarProduto(int id, Produto produtoNovo) {
        if(pDAO.buscar(id) != null) {
            pDAO.alterar(id, produtoNovo);
            return true;
        } else {
            return false;
        }
    }

    public boolean excluirProduto(int id) {
        if(pDAO.buscar(id) != null) {
            pDAO.excluir(id);
            return true;
        } else {
            return false;
        }
    }

    public Produto buscarProduto(int id) {
        return pDAO.buscar(id);
    }

    public List<Produto> listarProdutos() {
        return pDAO.listar();
    }
}
