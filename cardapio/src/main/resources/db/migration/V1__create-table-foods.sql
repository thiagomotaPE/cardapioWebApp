/*
aqui estou apprendendo sobre flyway migrations. que serve para faser o vercionamento do banco de dados
e criar o banco pela IDE.
neste caso estou usando o postgreSQL, mas pode ser qualquer banco.
instalei as dependencias: JPA, POSTGRES DRIVER E FLYWAY
*/
/*
nesta versão o flyway só criou a tabela foods
*/

CREATE TABLE foods (
    id SERIAL PRIMARY KEY,
    title TEXT NOT NULL,
    price INTEGER NOT NULL,
    image TEXT
);