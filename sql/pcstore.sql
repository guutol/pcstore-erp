CREATE DATABASE pcstore_db;

USE pcstore_db;



CREATE TABLE clientes (
	id INT PRIMARY KEY,
    nome VARCHAR(100),
    cpf VARCHAR(100),
    telefone VARCHAR(100),
    email VARCHAR(100)
);

CREATE TABLE vendas (
	id INT PRIMARY KEY,
    cliente_id INT,
    data_venda DATETIME,
    valor_total DOUBLE,   
    FOREIGN KEY (cliente_id) REFERENCES clientes(id)
);



CREATE TABLE fornecedores (
	id INT PRIMARY KEY,
    nome VARCHAR(100),
    cnpj VARCHAR(100),
    telefone VARCHAR(100),
    email VARCHAR(100)
);

CREATE TABLE compras (
	id INT PRIMARY KEY,
    fornecedor_id INT,
    data_compra DATETIME,
    valor_total DOUBLE,
    FOREIGN KEY (fornecedor_id) REFERENCES fornecedores(id)
);



CREATE TABLE categorias (
	id INT PRIMARY KEY,
    nome VARCHAR(100)
);

CREATE TABLE produtos (
	id INT PRIMARY KEY,
    nome VARCHAR(100),
    marca VARCHAR(100),
    categoria_id INT,
    preco DOUBLE,
    quantidade_estoque INT,
    fornecedor_id INT,
    FOREIGN KEY (categoria_id) REFERENCES categorias(id),
    FOREIGN KEY (fornecedor_id) REFERENCES fornecedores(id)
);

CREATE TABLE item_venda (
	id INT PRIMARY KEY,
    produto_id INT,
    quantidade INT,
    preco_unitario DOUBLE,
    sub_total DOUBLE,
    venda_id INT,
    FOREIGN KEY (produto_id) REFERENCES produtos(id),
    FOREIGN KEY (venda_id) REFERENCES vendas(id)
);

CREATE TABLE item_compras (
	id INT PRIMARY KEY,
    produto_id INT,
    quantidade INT,
    custo_unitario DOUBLE,
    sub_total DOUBLE,
    compra_id INT,
    FOREIGN KEY (produto_id) REFERENCES produtos(id),
    FOREIGN KEY (compra_id) REFERENCES compras(id)
);


SHOW TABLES;