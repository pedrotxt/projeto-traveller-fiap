CREATE TABLE usuario(id_usuario number ,p_nome varchar(50) ,s_nome varchar(100) 
                    ,email varchar(100),celular number(10) ,senha varchar(50))

select * from usuario;

INSERT INTO usuario (id_usuario, p_nome, s_nome, email, celular, senha) VALUES (1, 'Pedro', 'Pinheiro', 'pedro@test.com.br', 199983212, '123');
            
DROP TABLE usuario;
            
CREATE TABLE cidade(id_cidade number ,cidade varchar(100) ,estado varchar(100) 
                    ,sigla_estado varchar(10) ,pais varchar(100) ,sigla_pais varchar(10))

INSERT INTO cidade (id_cidade ,cidade, estado, sigla_estado, pais ,sigla_pais) VALUES (1, 'Belo Horizonte', 'Minas Gerais', 'MG', 'BRASIL', 'BR');
select * from cidade;

