package org.pcstore.model;

public class Produto {
    private int id;
    private String nome;
    private String marca;
    private Categoria categoria;
    private double preco;
    private int quantidade_estoque;
    private Fornecedor fornecedor;

    public Produto(){}

    public Produto(int id, String nome, String marca, Categoria categoria, double preco, int quantidade_estoque, Fornecedor fornecedor) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.categoria = categoria;
        this.preco = preco;
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setCategoria(int id) {
        Categoria c = new Categoria();
        c.setId(id);
        this.categoria = c;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
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

    public void setFornecedor(int id) {
        Fornecedor f = new Fornecedor();
        f.setId(id);
        this.fornecedor = f;
    }
}
