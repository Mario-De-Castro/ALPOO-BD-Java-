package alpoo_bd;

/**
Mario de Castro Neto
Eric Yamamura
*/ 

import BDDAO.ManipulaBanco;
import BDDAO.MetodosUtilizacao;
import DatabaseJDBC.connectDatabase;
import DatabaseJDBC.manipulacaoDatabase;
import java.util.Scanner;

public class ALPOO_BD {
    
    public static void main(String[] args) {
        System.out.println("Digite 1 para Utilizar por JDBC ou 2 para Utilizar o DAO");
        Scanner myObj = new Scanner(System.in);
        int y = myObj.nextInt();
        if (y == 1){
            connectDatabase db = new connectDatabase();
            manipulacaoDatabase ins = new manipulacaoDatabase();
            boolean Param = ins.conferir();
            if (Param == false){
                ins.insertandoDados();
            }
            int x = 1;

            while (x != 0){
                System.out.println("\nSegue abaixo as opções de Select:\n"
                        + "Digite 1: Listagem de Clientes sem E-mail\n"
                        + "Digite 2: Listagem de Produtos que estão vencidos na data atual\n"
                        + "Digite 3: Quantidades de venda realizada no ano de 2020 (Agrupadas por Cliente)\n"
                        + "Digite 4: Listagem de Vendas (contendo o valor da mesma)\n"
                        + "Digite 0: Para Finalizar" + "\n");
                x = myObj.nextInt();
                if (x == 1){
                    ins.selectsemail();
                }
                if (x == 2){
                    ins.selectValidade();
                }
                if (x == 3){
                    ins.selectAnoVenda();
                }
                if (x == 4){
                    ins.selectVenda();
                }
            }
        }
        if (y == 2){
            ManipulaBanco db = new MetodosUtilizacao();
            boolean Parametro = db.conferir();
            if (Parametro == false){
                db.insertando();
            }
            int x = 1;

            while (x != 0){
                System.out.println("\nSegue abaixo as opções de Select:\n"
                        + "Digite 1: Listagem de Clientes sem E-mail\n"
                        + "Digite 2: Listagem de Produtos que estão vencidos na data atual\n"
                        + "Digite 3: Quantidades de venda realizada no ano de 2020 (Agrupadas por Cliente)\n"
                        + "Digite 4: Listagem de Vendas (contendo o valor da mesma)\n"
                        + "Digite 0: Para Finalizar" + "\n");
                x = myObj.nextInt();
                if (x == 1){
                    db.selectsemail();
                }
                if (x == 2){
                    db.selectValidade();
                }
                if (x == 3){
                    db.selectAnoVenda();
                }
                if (x == 4){
                    db.selectVenda();
                }
            }
        }
    }
}
