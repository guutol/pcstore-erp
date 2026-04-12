package org.pcstore.model;

public class Produto {
    private int id;
    private String nome;
    private String marcaL;
    private Categoria categoria;
    private double precoL;
    private int quantidade_estoque;
    private Fornecedor fornecedor;

    public Produto(int id, String nome, String marcaL, Categoria categoria, double precoL, int quantidade_estoque, Fornecedor fornecedor) {
        this.id = id;
        this.nome = nome;
        this.marcaL = marcaL;
        this.categoria = categoria;
        this.precoL = precoL;
        this.quantidade_estoque = quantidade_estoque;
        this.fornecedor = fornecedor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarcaL() {
        return marcaL;
    }

    public void setMarcaL(String marcaL) {
        this.marcaL = marcaL;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public double getPrecoL() {
        return precoL;
    }

    public void setPrecoL(double precoL) {
        this.precoL = precoL;
    }

    public int getQuantidade_estoque() {
        return quantidade_estoque;
    }

    public void setQuantidade_estoque(int quantidade_estoque) {
        this.quantidade_estoque = quantidade_estoque;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
}
