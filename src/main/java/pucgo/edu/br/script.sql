create database swing_login;

CREATE TABLE estudante
( id int NOT NULL,
  nome varchar(250) NOT NULL,
  senha varchar(250)
);

INSERT INTO estudante (id, nome, senha)
VALUES (1, 'XPTO', 'Puc@123');

