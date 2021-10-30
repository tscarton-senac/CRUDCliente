CREATE TABLE usuario (
   id INT not null primary key
        GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
   nome VARCHAR(255),
   usuario VARCHAR(255),
   senha VARCHAR(255),
   perfil VARCHAR(255)
);

insert into usuario (nome, usuario, senha, perfil) values  ('Administrator', 'admin', '1234', 'admin');
insert into usuario (nome, usuario, senha, perfil) values  ('Mike Wilson', 'mike', '1234', 'vendedor');