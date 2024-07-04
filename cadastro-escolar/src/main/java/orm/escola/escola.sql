CREATE DATABASE escola;
USE escola;

CREATE TABLE aluno (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    data_nascimento DATE NOT NULL,
    naturalidade VARCHAR(255) NOT NULL,
    endereco VARCHAR(255) NOT NULL
);

