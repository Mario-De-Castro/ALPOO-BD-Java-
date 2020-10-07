package DatabaseJDBC;

/**
Mario de Castro Neto
Eric Yamamura
*/

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class manipulacaoDatabase {
    
    final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    final String DATABASE_URL = "jdbc:sqlserver://localhost:1433;databaseName=Loja";
    Connection conn = null;
    
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
    
    
            
            
    public manipulacaoDatabase() {
        Statement CriandoDatabase = null;
        try {
            Class.forName(DRIVER); // Carrega o Driver
            // Obtém a conexão com a base de dados
            conn = DriverManager.getConnection(DATABASE_URL, "sa", "");
            CriandoDatabase = conn.createStatement();
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
    
    }
    
    public void insertandoDados(){
        try{
            Statement statement = null;
            statement = conn.createStatement();
            statement.executeUpdate(insDistrib);
            statement.executeUpdate(insProdutos);
            statement.executeUpdate(insClientes);
            statement.executeUpdate(insVenda);
            statement.executeUpdate(insItensVenda);
        }catch(SQLException ex){
            System.err.println(ex);
        }
    }
    
    public void selectsemail(){
        try{
            Statement select = null;
            select = conn.createStatement();
            ResultSet qr = select.executeQuery("SELECT * FROM Clientes WHERE e_mail = ''");
            while (qr.next()){
                int cod_cli = qr.getInt("cod_cli");
                String nome = qr.getString("nome");
                Date data_nasc = qr.getDate("data_nasc");
                String endereco = qr.getString("endereco");
                String telefone = qr.getString("telefone");
                String email = qr.getString("e_mail");
                
                System.out.print(" Codigo: " + cod_cli);
                System.out.print(", Nome: " + nome);
                System.out.print(", Data de Nascimento: " + data_nasc);
                System.out.println(", Endereço: " + endereco);
                System.out.print(", Telefone: " + telefone);
                System.out.println(", Email: " + email + "\n");
                
            }
        }catch(SQLException ex){
            System.err.println(ex);
        }
    
    
    }
    
    public void selectValidade(){
        try{
            Statement select = null;
            select = conn.createStatement();
            ResultSet qr = select.executeQuery("SELECT * FROM Produtos WHERE data_validade < CURRENT_TIMESTAMP");
            while (qr.next()){
                int cod_prod = qr.getInt("cod_prod");
                int preco_venda = qr.getInt("preco_venda");
                String desc = qr.getString("descricao");
                Date dataValidade = qr.getDate("data_validade");
                int preco_custo = qr.getInt("preco_custo");;
                int estoque = qr.getInt("estoque");
                
                System.out.print(" Codigo do Produto: " + cod_prod);
                System.out.print(", Preço de Venda: " + preco_venda);
                System.out.print(", Descrição: " + desc);
                System.out.println(", Data de Validade: " + dataValidade);
                System.out.print(", Preço de Custo: " + preco_custo);
                System.out.println(", Estoque: " + estoque + "\n");
                
            }
        }catch(SQLException ex){
            System.err.println(ex);
        }
    }
        
    public void selectAnoVenda() {
        try{
            Statement select = null;
            select = conn.createStatement();
            ResultSet qr = select.executeQuery("SELECT Vendas.cod_cli as Codigo_Cliente, count(cod_venda) as qtdVendas FROM dbo.Vendas\n" +
                                "WHERE YEAR(DataHora) = YEAR('2020')\n" +
                                "GROUP BY Vendas.cod_cli");
            
            while (qr.next()){
                int Codigo_Cliente = qr.getInt("Codigo_Cliente");
                int qtdVendas = qr.getInt("qtdVendas");
                
                System.out.print(" Codigo do Cliente: " + Codigo_Cliente);
                System.out.print(", Quantidade de Vendas: " + qtdVendas + "\n");
                
            }
        }catch(SQLException ex){
            System.err.println(ex);
        }
    
    }
    
    public void selectVenda() {
        try{
            Statement select = null;
            select = conn.createStatement();
            ResultSet qr = select.executeQuery("SELECT cod_venda,DataHora,total FROM Vendas");
            
            while (qr.next()){
                int cod_venda = qr.getInt("cod_venda");
                Date datahora = qr.getDate("DataHora");
                int total = qr.getInt("total");
                
                System.out.print(" Codigo da Venda: " + cod_venda);
                System.out.print(", Data e Hora da Venda: " + datahora);
                System.out.print(", Valor da Venda: " + total + "\n");
            }

        }catch(SQLException ex){
            System.err.println(ex);
        }
    }
    
    public boolean conferir(){
        boolean a = false;
        try{
            Statement select = null;
            select = conn.createStatement();
            ResultSet qr = select.executeQuery("SELECT * FROM Vendas, Clientes, Produtos, Itens_Vendas, Distribuidores");
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
    }
    
