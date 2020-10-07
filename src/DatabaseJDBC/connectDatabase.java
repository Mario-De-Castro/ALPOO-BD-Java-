package DatabaseJDBC;

/**
Mario de Castro Neto
Eric Yamamura
*/

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class connectDatabase {
    
    final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    final String DATABASE_URL = "jdbc:sqlserver://localhost:1433;databaseName=master";
    
    private String eDatabase = "IF NOT EXISTS(SELECT 1 FROM sys.databases WHERE name='Loja') " +
                                "BEGIN " +
                                    "CREATE DATABASE Loja " +
                                "END;";
    
    private String UseDatabase = "USE Loja";
    
    private String tClientes = "if not exists (SELECT * FROM sysobjects where name='Clientes' and xtype='U')" +
                                " BEGIN "+
                                    "create table Clientes (" +
                                        "cod_cli int primary key IDENTITY(1,1)," +
                                        "nome varchar(80) not null," +
                                        "data_nasc date not null," +
                                        "endereco varchar(80) not null," +
                                        "telefone varchar(12) not null," +
                                        "e_mail varchar(50) not null" +
                                    ")"+
                                " END";
    
    private String tVendas = "if not exists (SELECT * FROM sysobjects where name='Vendas' and xtype='U')" +
                                " BEGIN"+
                                    " create table Vendas (" +
                                        "cod_venda  int primary key IDENTITY(1,1)," +
                                        "DataHora datetime,\n" +
                                        "total int,"+
                                        "cod_cli int not null"+
                                    ")"+
                                " END";
    
    private String tDistribuidores = "if not exists (SELECT * FROM sysobjects where name='Distribuidores' and xtype='U')" +
                                " BEGIN"+
                                    " create table Distribuidores (" +
                                        "cod_dist int primary key IDENTITY(1,1),"+
                                        "nome_fantasia varchar(120) not null,"+
                                        "razao_social varchar(120) not null,"+
                                        "telefone varchar(12) DEFAULT 'NÃO INFORMADO',"+
                                        "email varchar(80) DEFAULT 'NÃO INFORMADO'"+
                                    ")"+
                                " END";

    private String tProdutos = "if not exists (SELECT * FROM sysobjects where name='Produtos' and xtype='U')" +
                                " BEGIN"+
                                    " create table Produtos (" +
                                        "cod_prod int primary key IDENTITY(1,1),"+
                                        "preco_venda NUMERIC(10,2) not null,"+
                                        "descricao varchar(60),"+
                                        "data_validade date not null,"+
                                        "preco_custo NUMERIC(10,2) not null,"+
                                        "estoque int not null"+
                                    ")"+
                                " END";
    
    private String tItensVenda = "if not exists (SELECT * FROM sysobjects where name='Itens_Vendas' and xtype='U')" +
                                " BEGIN"+
                                    " create table Itens_Vendas (" +
                                        "quantidade int not null,"+
                                        "subtotal int not null,"+
                                        "cod_prod int not null,"+
                                        "cod_Venda int not null"+
                                    ")"+
                                " END";
    
    private String Constraint = "ALTER TABLE Vendas     \n" +
                                "	ADD CONSTRAINT FK_VendaCliente FOREIGN KEY (cod_cli)     \n" +
                                "		REFERENCES Clientes (cod_cli)\n" +
                                "		ON DELETE CASCADE\n" +
                                "		ON UPDATE CASCADE\n" +
                                "\n" +
                                "Alter table Itens_Vendas\n" +
                                "	ADD CONSTRAINT FK_ItensProdutos FOREIGN KEY (cod_prod)\n" +
                                "	REFERENCES Produtos (cod_prod)\n" +
                                "	ON DELETE CASCADE\n" +
                                "	ON UPDATE CASCADE\n" +
                                "\n" +
                                "Alter table Itens_Vendas\n" +
                                "	ADD CONSTRAINT FK_ItensPorVenda FOREIGN KEY (cod_Venda)\n" +
                                "	REFERENCES Vendas (cod_venda)\n" +
                                "	ON DELETE CASCADE\n" +
                                "	ON UPDATE CASCADE";

    Connection conn = null;
    
    public connectDatabase() {
        Statement CriandoDatabase = null;
        try {
            Class.forName(DRIVER); // Carrega o Driver
            // Obtém a conexão com a base de dados
            conn = DriverManager.getConnection(DATABASE_URL, "sa", "Maah1553");
            CriandoDatabase = conn.createStatement();
            CriandoDatabase.executeUpdate(eDatabase);
            CriandoDatabase.executeUpdate(UseDatabase);
            CriandoDatabase.executeUpdate(tClientes);
            CriandoDatabase.executeUpdate(tVendas);
            CriandoDatabase.executeUpdate(tDistribuidores);
            CriandoDatabase.executeUpdate(tProdutos);
            CriandoDatabase.executeUpdate(tItensVenda);
            CriandoDatabase.executeUpdate(Constraint);
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
    }
}