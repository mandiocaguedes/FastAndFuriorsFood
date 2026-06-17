-- Criação da Base de Dados
CREATE DATABASE IF NOT EXISTS fastfurious_db;
USE fastfurious_db;

-- Tabela de Categorias
CREATE TABLE categorias (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL UNIQUE
);

-- Tabela de Produtos
CREATE TABLE produtos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    preco DECIMAL(10,2) NOT NULL,
    categoria_id BIGINT,
    CONSTRAINT fk_categoria FOREIGN KEY (categoria_id) REFERENCES categorias(id)
);

-- Tabela de Pedidos
CREATE TABLE pedidos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    numero_sequencial INT NOT NULL,
    status ENUM('ABERTO', 'PRONTO', 'ENTREGUE', 'CANCELADO') DEFAULT 'ABERTO',
    data_criacao DATETIME DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Tabela de Itens do Pedido (Relacionamento N:M reduzido a 1:N)
CREATE TABLE itens_pedido (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    pedido_id BIGINT NOT NULL,
    produto_id BIGINT NOT NULL,
    quantidade INT NOT NULL,
    CONSTRAINT fk_pedido FOREIGN KEY (pedido_id) REFERENCES pedidos(id),
    CONSTRAINT fk_produto FOREIGN KEY (produto_id) REFERENCES produtos(id)
);