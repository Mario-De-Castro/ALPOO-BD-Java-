create table Clientes (

cod_cli int primary key IDENTITY(1,1),
nome varchar(80) not null,
data_nasc date not null,
endereco varchar(80) not null,
telefone varchar(12) not null,
e_mail varchar(50)
)

create table Vendas (

cod_venda  int primary key IDENTITY(1,1),
DataHora datetime,
total int,
cod_cli int
)

create table Distribuidores (

cod_dist int primary key IDENTITY(1,1),
nome_fantasia varchar(120) not null,
razao_social varchar(120) not null,
telefone varchar(12) DEFAULT 'NÃO INFORMADO',
email varchar(80) DEFAULT 'NÃO INFORMADO'
)

create table Produtos (

cod_prod int primary key IDENTITY(1,1),
preco_venda NUMERIC(10,2) not null,
descricao varchar(60),
data_validade date not null,
preco_custo NUMERIC(10,2) not null,
estoque int not null
)

create table Itens_Vendas (

quantidade int not null,
subtotal int not null,
cod_vendas int
)

------------------- Alteração das Foreign Key --------------

ALTER TABLE Vendas     
	ADD CONSTRAINT FK_VendaCliente FOREIGN KEY (cod_cli)     
		REFERENCES Clientes (cod_cli)
		ON DELETE CASCADE
		ON UPDATE CASCADE

Alter table Itens_Vendas
	ADD CONSTRAINT FK_ItensProdutos FOREIGN KEY (cod_prod)
	REFERENCES Produtos (cod_prod)
	ON DELETE CASCADE
	ON UPDATE CASCADE

Alter table Itens_Vendas
	ADD CONSTRAINT FK_ItensPorVenda FOREIGN KEY (cod_Venda)
	REFERENCES Vendas (cod_venda)
	ON DELETE CASCADE
	ON UPDATE CASCADE


---------------------- Inserts ---------------------------

----Distribuidores

INSERT INTO dbo.Distribuidores(nome_fantasia,razao_social,telefone,email)
VALUES
('CEDIS LTDA', 'Celio Distribuidora LTDA', '1140028922', 'comercial@cedis.com.br')

---- Produtos

INSERT INTO dbo.Produtos(preco_venda,descricao,data_validade,preco_custo,estoque)
VALUES
(50.00, 'Camiseta Azul Tommi', '2030-09-29', 25.00, 50)

INSERT INTO dbo.Produtos(preco_venda,descricao,data_validade,preco_custo,estoque)
VALUES
(120.00, 'Calça Jeans Chile Beans', '2030-09-29', 63.20, 120)

INSERT INTO dbo.Produtos(preco_venda,descricao,data_validade,preco_custo,estoque)
VALUES
(50.00, 'Camiseta Vermelha Larcoste', '2030-09-29', 23.00, 34)

INSERT INTO dbo.Produtos(preco_venda,descricao,data_validade,preco_custo,estoque)
VALUES
(30.00, 'Short Tecktel Oclei', '2030-09-29', 11.00, 50)

INSERT INTO dbo.Produtos(preco_venda,descricao,data_validade,preco_custo,estoque)
VALUES
(70.00, 'Blusa de Frio Ardidas', '2021-09-29', 30.00, 20)

INSERT INTO dbo.Produtos(preco_venda,descricao,data_validade,preco_custo,estoque)
VALUES
(50.00, 'Bermuda Jeans Chile Beans', '2030-09-29', 25.00, 30)

INSERT INTO dbo.Produtos(preco_venda,descricao,data_validade,preco_custo,estoque)
VALUES
(100.00, 'Calça Sarja', '2030-09-29', 40.00, 120)

INSERT INTO dbo.Produtos(preco_venda,descricao,data_validade,preco_custo,estoque)
VALUES
(80.00, 'Camiseta Polo Larcoste Cinza', '2030-09-29', 30.00, 20)

INSERT INTO dbo.Produtos(preco_venda,descricao,data_validade,preco_custo,estoque)
VALUES
(50.00, 'Camiseta Preta Basica Oclei', '2030-09-29', 11.00, 30)

INSERT INTO dbo.Produtos(preco_venda,descricao,data_validade,preco_custo,estoque)
VALUES
(50.00, 'Camiseta Cinza Basica Larcoste', '2030-09-29', 25.00, 50)


-----Clientes

INSERT INTO dbo.Clientes(nome,data_nasc,endereco,telefone,e_mail)
VALUES
('Adailson Pereira', '1987-06-05', 'Rua das armelias 80 - Bosque Industrial - SJC', '12981526345','adailsonper@gmail.com')

INSERT INTO dbo.Clientes(nome,data_nasc,endereco,telefone,e_mail)
VALUES
('Ednaldo Pereira', '1993-07-21', 'Avenida Matarato 50 - Jardim Catalao - SJC', '12983647156','ednaldoPereira@gmail.com')

INSERT INTO dbo.Clientes(nome,data_nasc,endereco,telefone,e_mail)
VALUES
('Didjei Azeitona', '1999-06-06', 'Rua das bicicletas - Jardim Sao Paulista - São Paulo', '11981114562','')

INSERT INTO dbo.Clientes(nome,data_nasc,endereco,telefone,e_mail)
VALUES
('Derek Augusto', '1997-02-01', 'Rua das robelias 80 - Bosque Satelite - SJC', '12982631542','DerekAug@hotmail.com')

INSERT INTO dbo.Clientes(nome,data_nasc,endereco,telefone,e_mail)
VALUES
('Leonardo diCaprio', '1989-01-03', 'Rua dos Peixes 93 - Bosque Aquarius - SJC', '12982365412','leodiCaprio@hotmail.com')


---Itens por Venda

---Itens da Venda 1 do Adailson Pereira
INSERT INTO dbo.Itens_Vendas(quantidade,subtotal, cod_prod, cod_Venda)
VALUES
(1, 50, 1, 1)
INSERT INTO dbo.Itens_Vendas(quantidade,subtotal, cod_prod, cod_Venda)
VALUES
(1, 120, 2, 1)
INSERT INTO dbo.Itens_Vendas(quantidade,subtotal, cod_prod, cod_Venda)
VALUES
(1, 50, 3, 1)

---Itens da Venda 2 do Adailson Pereira

INSERT INTO dbo.Itens_Vendas(quantidade,subtotal, cod_prod, cod_Venda)
VALUES
(1, 30, 4, 2)
INSERT INTO dbo.Itens_Vendas(quantidade,subtotal, cod_prod, cod_Venda)
VALUES
(1, 120, 2, 2)
INSERT INTO dbo.Itens_Vendas(quantidade,subtotal, cod_prod, cod_Venda)
VALUES
(1, 100, 7, 2)

---Itens da Venda 3 do Ednaldo Pereira

INSERT INTO dbo.Itens_Vendas(quantidade,subtotal, cod_prod, cod_Venda)
VALUES
(1, 30, 4, 3)
INSERT INTO dbo.Itens_Vendas(quantidade,subtotal, cod_prod, cod_Venda)
VALUES
(1, 120, 8, 3)
INSERT INTO dbo.Itens_Vendas(quantidade,subtotal, cod_prod, cod_Venda)
VALUES
(1, 100, 9, 3)

---Itens da Venda 4 do Ednaldo Pereira

INSERT INTO dbo.Itens_Vendas(quantidade,subtotal, cod_prod, cod_Venda)
VALUES
(1, 50, 3, 4)
INSERT INTO dbo.Itens_Vendas(quantidade,subtotal, cod_prod, cod_Venda)
VALUES
(1, 50, 9, 4)
INSERT INTO dbo.Itens_Vendas(quantidade,subtotal, cod_prod, cod_Venda)
VALUES
(1, 50, 10, 4)

---Itens da Venda 5 do Didjei Azeitona

INSERT INTO dbo.Itens_Vendas(quantidade,subtotal, cod_prod, cod_Venda)
VALUES
(1, 50, 7, 5)
INSERT INTO dbo.Itens_Vendas(quantidade,subtotal, cod_prod, cod_Venda)
VALUES
(1, 50, 5, 5)
INSERT INTO dbo.Itens_Vendas(quantidade,subtotal, cod_prod, cod_Venda)
VALUES
(1, 50, 9, 5)

---Itens da Venda 6 do Didjei Azeitona

INSERT INTO dbo.Itens_Vendas(quantidade,subtotal, cod_prod, cod_Venda)
VALUES
(2, 240, 7, 6)
INSERT INTO dbo.Itens_Vendas(quantidade,subtotal, cod_prod, cod_Venda)
VALUES
(1, 50, 9, 6)

---Itens da Venda 7 do Derek Augusto

INSERT INTO dbo.Itens_Vendas(quantidade,subtotal, cod_prod, cod_Venda)
VALUES
(2, 240, 7, 7)
INSERT INTO dbo.Itens_Vendas(quantidade,subtotal, cod_prod, cod_Venda)
VALUES
(1, 50, 9, 7)
INSERT INTO dbo.Itens_Vendas(quantidade,subtotal, cod_prod, cod_Venda)
VALUES
(1, 50, 6, 7)

---Itens da Venda 8 do Derek Augusto

INSERT INTO dbo.Itens_Vendas(quantidade,subtotal, cod_prod, cod_Venda)
VALUES
(2, 240, 1, 8)
INSERT INTO dbo.Itens_Vendas(quantidade,subtotal, cod_prod, cod_Venda)
VALUES
(1, 50, 3, 8)
INSERT INTO dbo.Itens_Vendas(quantidade,subtotal, cod_prod, cod_Venda)
VALUES
(1, 50, 10, 8)

---Itens da Venda 9 do Leonardo diCaprio

INSERT INTO dbo.Itens_Vendas(quantidade,subtotal, cod_prod, cod_Venda)
VALUES
(1, 50, 1, 9)
INSERT INTO dbo.Itens_Vendas(quantidade,subtotal, cod_prod, cod_Venda)
VALUES
(1, 50, 3, 9)
INSERT INTO dbo.Itens_Vendas(quantidade,subtotal, cod_prod, cod_Venda)
VALUES
(1, 50, 10, 9)

---Itens da Venda 10 do Leonardo diCaprio

INSERT INTO dbo.Itens_Vendas(quantidade,subtotal, cod_prod, cod_Venda)
VALUES
(1, 50, 1, 10)
INSERT INTO dbo.Itens_Vendas(quantidade,subtotal, cod_prod, cod_Venda)
VALUES
(1, 120, 2, 10)
INSERT INTO dbo.Itens_Vendas(quantidade,subtotal, cod_prod, cod_Venda)
VALUES
(1, 50, 3, 10)


----- Vendas

----- Venda 1 -----
--Adailson Pereira
--Camisa azul Tommi , Calça Jeans Chile Beans, Camiseta Vermelha Larcoste, 50+50+120 = 220

INSERT INTO dbo.Vendas (DataHora,total,cod_cli)
Values
(CURRENT_TIMESTAMP, 220,1)

--Venda 2 ------
--Adailson Pereira
--Short Teckel Oclei , Calça Jeans Chile Beans, Calça Sarja , 30+120+100 = 250

INSERT INTO dbo.Vendas (DataHora,total,cod_cli)
Values
(CURRENT_TIMESTAMP, 250,1)

--Venda 3 ------
--Ednaldo Pereira
--Short Teckel Oclei , Camiseta Polo Larcoste Cinza, Camiseta Basica Oclei , 30+80+50 = 160

INSERT INTO dbo.Vendas (DataHora,total,cod_cli)
Values
(CURRENT_TIMESTAMP, 160,2)

--Venda 4 ------
--Ednaldo Pereira
--Camiseta Cinza Basica Larcoste , Camiseta Vermelha Larcoste, Camiseta Basica Oclei , 50+50+50 = 150

INSERT INTO dbo.Vendas (DataHora,total,cod_cli)
Values
(CURRENT_TIMESTAMP, 150,2)

--Venda 5 ------
--Didjei Azeitona
--Calça Sarja, Blusa de Frio Ardidas, Camiseta Basica Oclei , 100+70+50 = 220

INSERT INTO dbo.Vendas (DataHora,total,cod_cli)
Values
(CURRENT_TIMESTAMP, 220,3)

--Venda 6 ------
--Didjei Azeitona
-- Calça jeans Chile Beans 2 unidades, Camiseta Basica Oclei , (120*2)+50 = 290

INSERT INTO dbo.Vendas (DataHora,total,cod_cli)
Values
(CURRENT_TIMESTAMP, 290,3)

--Venda 7 ------
--Derek Augusto
-- Calça Sarja, Camiseta Basica Oclei , Bermuda Jeans Chile Beans 100+50+50 = 200

INSERT INTO dbo.Vendas (DataHora,total,cod_cli)
Values
(CURRENT_TIMESTAMP, 200,4)

--Venda 8 ------
--Derek Augusto
-- Camise Azul Tommi, Camiseta Vermelha Larcoste, Camiseta Cinza Larcoste , 50+50+50=150

INSERT INTO dbo.Vendas (DataHora,total,cod_cli)
Values
(CURRENT_TIMESTAMP, 150,4)

--Venda 9 ------
--Leonardo diCaprio
-- Camise Azul Tommi, Camiseta Vermelha Larcoste, Camiseta Cinza Larcoste , 50+50+50=150

INSERT INTO dbo.Vendas (DataHora,total,cod_cli)
Values
(CURRENT_TIMESTAMP, 150,5)

--Venda 10 ------
--Leonardo diCaprio
-- Camisa azul Tommi , Calça Jeans Chile Beans, Camiseta Vermelha Larcoste, 50+50+120 = 220

INSERT INTO dbo.Vendas (DataHora,total,cod_cli)
Values
(CURRENT_TIMESTAMP, 220,5)

SELECT * FROM Vendas

SELECT Vendas.cod_cli as Codigo_Cliente, count(cod_venda) as qtdVendas FROM dbo.Vendas
WHERE YEAR(DataHora) = YEAR('2020')
GROUP BY Vendas.cod_cli

SELECT cod_venda,DataHora,total FROM Vendas
