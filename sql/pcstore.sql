DROP DATABASE IF EXISTS pcstore_db;
CREATE DATABASE pcstore_db;
USE pcstore_db;

CREATE TABLE clientes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    telefone VARCHAR(100),
    email VARCHAR(100)
);

CREATE TABLE fornecedores (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    cnpj VARCHAR(18) NOT NULL UNIQUE,
    telefone VARCHAR(100),
    email VARCHAR(100)
);

CREATE TABLE categorias (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL
);

CREATE TABLE produtos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    marca VARCHAR(100) NOT NULL,
    categoria_id INT NOT NULL,
    preco DECIMAL(10,2) NOT NULL,
    quantidade_estoque INT NOT NULL,
    fornecedor_id INT NOT NULL,
    FOREIGN KEY (categoria_id) REFERENCES categorias(id),
    FOREIGN KEY (fornecedor_id) REFERENCES fornecedores(id)
);

CREATE TABLE vendas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    cliente_id INT NOT NULL,
    data_venda DATETIME NOT NULL,
    valor_total DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (cliente_id) REFERENCES clientes(id)
);

CREATE TABLE compras (
    id INT PRIMARY KEY AUTO_INCREMENT,
    fornecedor_id INT NOT NULL,
    data_compra DATETIME NOT NULL,
    valor_total DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (fornecedor_id) REFERENCES fornecedores(id)
);

CREATE TABLE item_venda (
    id INT PRIMARY KEY AUTO_INCREMENT,
    produto_id INT NOT NULL,
    quantidade INT NOT NULL,
    preco_unitario DECIMAL(10,2) NOT NULL,
    sub_total DECIMAL(10,2) NOT NULL,
    venda_id INT NOT NULL,
    FOREIGN KEY (produto_id) REFERENCES produtos(id),
    FOREIGN KEY (venda_id) REFERENCES vendas(id)
);

CREATE TABLE item_compra (
    id INT PRIMARY KEY AUTO_INCREMENT,
    produto_id INT NOT NULL,
    quantidade INT NOT NULL,
    custo_unitario DECIMAL(10,2) NOT NULL,
    sub_total DECIMAL(10,2) NOT NULL,
    compra_id INT NOT NULL,
    FOREIGN KEY (produto_id) REFERENCES produtos(id),
    FOREIGN KEY (compra_id) REFERENCES compras(id)
);

/* inserts */

INSERT INTO categorias (nome)
VALUES ('Placa de vídeo');

INSERT INTO fornecedores (nome, cnpj, telefone, email)
VALUES ('Terabyte', '11.518.346/0001-00', '+55 (31) 94463-2271', 'terabyte@gmail.com');

INSERT INTO produtos (nome, marca, categoria_id, preco, quantidade_estoque, fornecedor_id)
VALUES ('RX6600', 'AMD', 1, 1200.00, 20, 1);

/* consultas */

SHOW TABLES;

SELECT * FROM produtos;
SELECT * FROM categorias;
SELECT * FROM produtos WHERE preco > 1000;

SELECT *
FROM produtos p
JOIN categorias c ON p.categoria_id = c.id;

SELECT p.nome AS produto, p.marca, p.preco, c.nome AS categoria
FROM produtos p
JOIN categorias c ON p.categoria_id = c.id;

SELECT SUM(valor_total) AS total_vendido
FROM vendas;

SELECT c.nome, SUM(v.valor_total) AS total_gasto
FROM clientes c
JOIN vendas v ON c.id = v.cliente_id
GROUP BY c.nome;

SELECT version();

/* simular venda */

INSERT INTO clientes (nome, cpf, telefone, email)
VALUES ('Gustavo Bomfim', '831.616.070-66', '+55 (41) 95984-4915', 'gustavo@gmail.com');

INSERT INTO vendas (cliente_id, data_venda, valor_total)
VALUES (1, NOW(), 2400.00);

INSERT INTO item_venda (produto_id, quantidade, preco_unitario, sub_total, venda_id)
VALUES (1, 2, 1200.00, 2400.00, 1);

SELECT c.nome AS cliente, p.nome AS produto, iv.quantidade, iv.preco_unitario, v.valor_total
FROM vendas v
JOIN clientes c ON v.cliente_id = c.id
JOIN item_venda iv ON v.id = iv.venda_id
JOIN produtos p ON iv.produto_id = p.id;

SELECT * FROM produtos;

/* teste de update de estoque */

UPDATE produtos
SET quantidade_estoque = quantidade_estoque - 2
WHERE id = 1;

/* drops */

DROP TABLE item_venda;
DROP TABLE item_compra;
DROP TABLE produtos;
DROP TABLE vendas;
DROP TABLE compras;
DROP TABLE categorias;
DROP TABLE fornecedores;
DROP TABLE clientes;