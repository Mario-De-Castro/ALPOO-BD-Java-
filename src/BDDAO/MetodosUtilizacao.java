package BDDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MetodosUtilizacao implements ManipulaBanco{
    
    public Connection connection = null;
    public Statement smt;
    
    private String insDistrib = "INSERT INTO dbo.Distribuidores(nome_fantasia,razao_social,telefone,email)\n" +
                     "VALUES\n" +
                     "('CEDIS LTDA', 'Celio Distribuidora LTDA', '1140028922', 'comercial@cedis.com.br')";
    
    private String insClientes = "INSERT INTO dbo.Clientes(nome,data_nasc,endereco,telefone,e_mail)\n" +
                                "VALUES\n" +
                                "('Adailson Pereira', '1987-06-05', 'Rua das armelias 80 - Bosque Industrial - SJC', '12981526345','adailsonper@gmail.com')\n" +
                                "\n" +
                                "INSERT INTO dbo.Clientes(nome,data_nasc,endereco,telefone,e_mail)\n" +
                                "VALUES\n" +
                                "('Ednaldo Pereira', '1993-07-21', 'Avenida Matarato 50 - Jardim Catalao - SJC', '12983647156','ednaldoPereira@gmail.com')\n" +
                                "\n" +
                                "INSERT INTO dbo.Clientes(nome,data_nasc,endereco,telefone,e_mail)\n" +
                                "VALUES\n" +
                                "('Didjei Azeitona', '1999-06-06', 'Rua das bicicletas - Jardim Sao Paulista - São Paulo', '11981114562','')\n" +
                                "\n" +
                                "INSERT INTO dbo.Clientes(nome,data_nasc,endereco,telefone,e_mail)\n" +
                                "VALUES\n" +
                                "('Derek Augusto', '1997-02-01', 'Rua das robelias 80 - Bosque Satelite - SJC', '12982631542','DerekAug@hotmail.com')\n" +
                                "\n" +
                                "INSERT INTO dbo.Clientes(nome,data_nasc,endereco,telefone,e_mail)\n" +
                                "VALUES\n" +
                                "('Leonardo diCaprio', '1989-01-03', 'Rua dos Peixes 93 - Bosque Aquarius - SJC', '12982365412','leodiCaprio@hotmail.com')";
    
    private String insProdutos = "INSERT INTO dbo.Produtos(preco_venda,descricao,data_validade,preco_custo,estoque)\n" +
                                "VALUES\n" +
                                "(50.00, 'Camiseta Azul Tommi', '2030-09-29', 25.00, 50)\n" +
                                "\n" +
                                "INSERT INTO dbo.Produtos(preco_venda,descricao,data_validade,preco_custo,estoque)\n" +
                                "VALUES\n" +
                                "(120.00, 'Calça Jeans Chile Beans', '2030-09-29', 63.20, 120)\n" +
                                "\n" +
                                "INSERT INTO dbo.Produtos(preco_venda,descricao,data_validade,preco_custo,estoque)\n" +
                                "VALUES\n" +
                                "(50.00, 'Camiseta Vermelha Larcoste', '2030-09-29', 23.00, 34)\n" +
                                "\n" +
                                "INSERT INTO dbo.Produtos(preco_venda,descricao,data_validade,preco_custo,estoque)\n" +
                                "VALUES\n" +
                                "(30.00, 'Short Tecktel Oclei', '2030-09-29', 11.00, 50)\n" +
                                "\n" +
                                "INSERT INTO dbo.Produtos(preco_venda,descricao,data_validade,preco_custo,estoque)\n" +
                                "VALUES\n" +
                                "(70.00, 'Blusa de Frio Ardidas', '2019-09-29', 30.00, 20)\n" +
                                "\n" +
                                "INSERT INTO dbo.Produtos(preco_venda,descricao,data_validade,preco_custo,estoque)\n" +
                                "VALUES\n" +
                                "(50.00, 'Bermuda Jeans Chile Beans', '2030-09-29', 25.00, 30)\n" +
                                "\n" +
                                "INSERT INTO dbo.Produtos(preco_venda,descricao,data_validade,preco_custo,estoque)\n" +
                                "VALUES\n" +
                                "(100.00, 'Calça Sarja', '2030-09-29', 40.00, 120)\n" +
                                "\n" +
                                "INSERT INTO dbo.Produtos(preco_venda,descricao,data_validade,preco_custo,estoque)\n" +
                                "VALUES\n" +
                                "(80.00, 'Camiseta Polo Larcoste Cinza', '2030-09-29', 30.00, 20)\n" +
                                "\n" +
                                "INSERT INTO dbo.Produtos(preco_venda,descricao,data_validade,preco_custo,estoque)\n" +
                                "VALUES\n" +
                                "(50.00, 'Camiseta Preta Basica Oclei', '2030-09-29', 11.00, 30)\n" +
                                "\n" +
                                "INSERT INTO dbo.Produtos(preco_venda,descricao,data_validade,preco_custo,estoque)\n" +
                                "VALUES\n" +
                                "(50.00, 'Camiseta Cinza Basica Larcoste', '2030-09-29', 25.00, 50)";
    
    private String insVenda = "INSERT INTO dbo.Vendas (DataHora,total,cod_cli)\n" +
                            "Values\n" +
                            "(CURRENT_TIMESTAMP, 220,1)\n" +
                            "INSERT INTO dbo.Vendas (DataHora,total,cod_cli)\n" +
                            "Values\n" +
                            "(CURRENT_TIMESTAMP, 250,1)\n" +
                            "INSERT INTO dbo.Vendas (DataHora,total,cod_cli)\n" +
                            "Values\n" +
                            "(CURRENT_TIMESTAMP, 160,2)\n" +
                            "INSERT INTO dbo.Vendas (DataHora,total,cod_cli)\n" +
                            "Values\n" +
                            "(CURRENT_TIMESTAMP, 150,2)\n" +
                            "INSERT INTO dbo.Vendas (DataHora,total,cod_cli)\n" +
                            "Values\n" +
                            "(CURRENT_TIMESTAMP, 220,3)\n" +
                            "INSERT INTO dbo.Vendas (DataHora,total,cod_cli)\n" +
                            "Values\n" +
                            "(CURRENT_TIMESTAMP, 290,3)\n" +
                            "INSERT INTO dbo.Vendas (DataHora,total,cod_cli)\n" +
                            "Values\n" +
                            "(CURRENT_TIMESTAMP, 200,4)\n" +
                            "INSERT INTO dbo.Vendas (DataHora,total,cod_cli)\n" +
                            "Values\n" +
                            "(CURRENT_TIMESTAMP, 150,4)\n" +
                            "INSERT INTO dbo.Vendas (DataHora,total,cod_cli)\n" +
                            "Values\n" +
                            "(CURRENT_TIMESTAMP, 150,5)\n" +
                            "INSERT INTO dbo.Vendas (DataHora,total,cod_cli)\n" +
                            "Values\n" +
                            "(CURRENT_TIMESTAMP, 220,5)";
    
    private String insItensVenda = "INSERT INTO dbo.Itens_Vendas(quantidade,subtotal, cod_prod, cod_Venda)\n" +
                                    "VALUES\n" +
                                    "(1, 50, 1, 1)\n" +
                                    "INSERT INTO dbo.Itens_Vendas(quantidade,subtotal, cod_prod, cod_Venda)\n" +
                                    "VALUES\n" +
                                    "(1, 120, 2, 1)\n" +
                                    "INSERT INTO dbo.Itens_Vendas(quantidade,subtotal, cod_prod, cod_Venda)\n" +
                                    "VALUES\n" +
                                    "(1, 50, 3, 1)\n" +
                                    "INSERT INTO dbo.Itens_Vendas(quantidade,subtotal, cod_prod, cod_Venda)\n" +
                                    "VALUES\n" +
                                    "(1, 30, 4, 2)\n" +
                                    "INSERT INTO dbo.Itens_Vendas(quantidade,subtotal, cod_prod, cod_Venda)\n" +
                                    "VALUES\n" +
                                    "(1, 120, 2, 2)\n" +
                                    "INSERT INTO dbo.Itens_Vendas(quantidade,subtotal, cod_prod, cod_Venda)\n" +
                                    "VALUES\n" +
                                    "(1, 100, 7, 2)\n" +
                                    "INSERT INTO dbo.Itens_Vendas(quantidade,subtotal, cod_prod, cod_Venda)\n" +
                                    "VALUES\n" +
                                    "(1, 30, 4, 3)\n" +
                                    "INSERT INTO dbo.Itens_Vendas(quantidade,subtotal, cod_prod, cod_Venda)\n" +
                                    "VALUES\n" +
                                    "(1, 120, 8, 3)\n" +
                                    "INSERT INTO dbo.Itens_Vendas(quantidade,subtotal, cod_prod, cod_Venda)\n" +
                                    "VALUES\n" +
                                    "(1, 100, 9, 3)\n" +
                                    "INSERT INTO dbo.Itens_Vendas(quantidade,subtotal, cod_prod, cod_Venda)\n" +
                                    "VALUES\n" +
                                    "(1, 50, 3, 4)\n" +
                                    "INSERT INTO dbo.Itens_Vendas(quantidade,subtotal, cod_prod, cod_Venda)\n" +
                                    "VALUES\n" +
                                    "(1, 50, 9, 4)\n" +
                                    "INSERT INTO dbo.Itens_Vendas(quantidade,subtotal, cod_prod, cod_Venda)\n" +
                                    "VALUES\n" +
                                    "(1, 50, 10, 4)\n" +
                                    "INSERT INTO dbo.Itens_Vendas(quantidade,subtotal, cod_prod, cod_Venda)\n" +
                                    "VALUES\n" +
                                    "(1, 50, 7, 5)\n" +
                                    "INSERT INTO dbo.Itens_Vendas(quantidade,subtotal, cod_prod, cod_Venda)\n" +
                                    "VALUES\n" +
                                    "(1, 50, 5, 5)\n" +
                                    "INSERT INTO dbo.Itens_Vendas(quantidade,subtotal, cod_prod, cod_Venda)\n" +
                                    "VALUES\n" +
                                    "(1, 50, 9, 5)\n" +
                                    "INSERT INTO dbo.Itens_Vendas(quantidade,subtotal, cod_prod, cod_Venda)\n" +
                                    "VALUES\n" +
                                    "(1, 100, 7, 6)\n" +
                                    "INSERT INTO dbo.Itens_Vendas(quantidade,subtotal, cod_prod, cod_Venda)\n" +
                                    "VALUES\n" +
                                    "(1, 50, 9, 6)\n" +
                                    "INSERT INTO dbo.Itens_Vendas(quantidade,subtotal, cod_prod, cod_Venda)\n" +
                                    "VALUES\n" +
                                    "(1, 100, 7, 7)\n" +
                                    "INSERT INTO dbo.Itens_Vendas(quantidade,subtotal, cod_prod, cod_Venda)\n" +
                                    "VALUES\n" +
                                    "(1, 50, 9, 7)\n" +
                                    "INSERT INTO dbo.Itens_Vendas(quantidade,subtotal, cod_prod, cod_Venda)\n" +
                                    "VALUES\n" +
                                    "(1, 50, 6, 7)\n" +
                                    "INSERT INTO dbo.Itens_Vendas(quantidade,subtotal, cod_prod, cod_Venda)\n" +
                                    "VALUES\n" +
                                    "(2, 240, 1, 8)\n" +
                                    "INSERT INTO dbo.Itens_Vendas(quantidade,subtotal, cod_prod, cod_Venda)\n" +
                                    "VALUES\n" +
                                    "(1, 50, 3, 8)\n" +
                                    "INSERT INTO dbo.Itens_Vendas(quantidade,subtotal, cod_prod, cod_Venda)\n" +
                                    "VALUES\n" +
                                    "(1, 50, 10, 8)\n" +
                                    "INSERT INTO dbo.Itens_Vendas(quantidade,subtotal, cod_prod, cod_Venda)\n" +
                                    "VALUES\n" +
                                    "(1, 50, 1, 9)\n" +
                                    "INSERT INTO dbo.Itens_Vendas(quantidade,subtotal, cod_prod, cod_Venda)\n" +
                                    "VALUES\n" +
                                    "(1, 50, 3, 9)\n" +
                                    "INSERT INTO dbo.Itens_Vendas(quantidade,subtotal, cod_prod, cod_Venda)\n" +
                                    "VALUES\n" +
                                    "(1, 50, 10, 9)\n" +
                                    "INSERT INTO dbo.Itens_Vendas(quantidade,subtotal, cod_prod, cod_Venda)\n" +
                                    "VALUES\n" +
                                    "(1, 50, 1, 10)\n" +
                                    "INSERT INTO dbo.Itens_Vendas(quantidade,subtotal, cod_prod, cod_Venda)\n" +
                                    "VALUES\n" +
                                    "(1, 120, 2, 10)\n" +
                                    "INSERT INTO dbo.Itens_Vendas(quantidade,subtotal, cod_prod, cod_Venda)\n" +
                                    "VALUES\n" +
                                    "(1, 50, 3, 10)";
    
     public MetodosUtilizacao()
    {
        String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String DATABASE_URL = "jdbc:sqlserver://localhost:1433;databaseName=Loja";
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(DATABASE_URL, "sa", "Maah1553");
            smt = connection.createStatement();
        } catch (SQLException|ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }  
    }

    @Override
    public void selectsemail() {
        try{
        //Statement smt = connection.createStatement();
        ResultSet qr= smt.executeQuery("SELECT * FROM Clientes WHERE e_mail = ''");
        while (qr.next()){
                Clientes c = new Clientes();
                c.cod_cli = qr.getInt("cod_cli");
                c.nome = qr.getString("nome");
                c.data_nasc = qr.getDate("data_nasc");
                c.endereco = qr.getString("endereco");
                c.telefone = qr.getString("telefone");
                c.e_mail = qr.getString("e_mail");
                
                System.out.print(" Codigo: " + c.cod_cli);
                System.out.print(", Nome: " + c.nome);
                System.out.print(", Data de Nascimento: " + c.data_nasc);
                System.out.println(", Endereço: " + c.endereco);
                System.out.print(", Telefone: " + c.telefone);
                System.out.println(", Email: " + c.e_mail + "\n");
                
        }
        }catch(SQLException ex)
        {
          System.err.println(ex.getMessage());  
        }
    }

    @Override
    public void selectValidade() {
        try{
            ResultSet qr = smt.executeQuery("SELECT * FROM Produtos WHERE data_validade < CURRENT_TIMESTAMP");
            while (qr.next()){
                Produtos p = new Produtos();
                p.cod_prod = qr.getInt("cod_prod");
                p.preco_venda = qr.getInt("preco_venda");
                p.descricao = qr.getString("descricao");
                p.data_validade = qr.getDate("data_validade");
                p.preco_custo = qr.getInt("preco_custo");;
                p.estoque = qr.getInt("estoque");
                
                System.out.print(" Codigo do Produto: " + p.cod_prod);
                System.out.print(", Preço de Venda: " + p.preco_venda);
                System.out.print(", Descrição: " + p.descricao);
                System.out.println(", Data de Validade: " + p.data_validade);
                System.out.print(", Preço de Custo: " + p.preco_custo);
                System.out.println(", Estoque: " + p.estoque + "\n");
            }
        }catch(SQLException ex){
            System.err.println(ex);
        }
    }

    @Override
    public void selectAnoVenda() {
            try{
            ResultSet qr = smt.executeQuery("SELECT Vendas.cod_cli as Codigo_Cliente, count(cod_venda) as qtdVendas FROM dbo.Vendas\n" +
                                "WHERE YEAR(DataHora) = YEAR('2020')\n" +
                                "GROUP BY Vendas.cod_cli");
            
            while (qr.next()){
                Vendas v = new Vendas();
                v.cod_cli = qr.getInt("Codigo_Cliente");
                v.cod_venda = qr.getInt("qtdVendas");
                System.out.print(" Codigo do Cliente: " + v.cod_cli);
                System.out.print(", Quantidade de Vendas: " + v.cod_venda + "\n");
            }
        }catch(SQLException ex){
            System.err.println(ex);
        }
    }

    @Override
    public void selectVenda() {
            try{
            ResultSet qr = smt.executeQuery("SELECT cod_venda,DataHora,total FROM Vendas");
            while (qr.next()){
                Vendas v = new Vendas();
                v.cod_venda = qr.getInt("cod_venda");
                v.DataHora = qr.getDate("DataHora");
                v.total = qr.getInt("total");
                System.out.print(" Codigo da Venda: " + v.cod_venda);
                System.out.print(", Data e Hora da Venda: " + v.DataHora);
                System.out.print(", Valor da Venda: " + v.total + "\n");
            }
        }catch(SQLException ex){
            System.err.println(ex);
        }
    }
    
    @Override
    public boolean conferir() {
        boolean a = false;
        try{
            ResultSet qr = smt.executeQuery("SELECT * FROM Vendas, Clientes, Produtos, Itens_Vendas, Distribuidores");
            if (qr.next() == true){
                a = true;
            } else {
                a = false;
            }
            System.out.println(a);
            }catch(SQLException ex){
            System.err.println(ex);
        }
        return a;
    }
    
    @Override
    public void insertando(){
        try{
            smt.executeUpdate(insDistrib);
            smt.executeUpdate(insProdutos);
            smt.executeUpdate(insClientes);
            smt.executeUpdate(insVenda);
            smt.executeUpdate(insItensVenda);
        }catch(SQLException ex){
            System.err.println(ex);
        }
    }
}
