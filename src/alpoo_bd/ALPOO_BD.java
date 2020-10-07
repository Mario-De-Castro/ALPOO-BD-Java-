package alpoo_bd;

/**
Mario de Castro Neto
Eric Yamamura
*/ 

import DatabaseJDBC.connectDatabase;
import DatabaseJDBC.manipulacaoDatabase;
import java.util.Scanner;

public class ALPOO_BD {
    
    public static void main(String[] args) {
        connectDatabase db = new connectDatabase();
        manipulacaoDatabase ins = new manipulacaoDatabase();
        boolean Param = ins.conferir();
        if (Param == false){
            ins.insertandoDados();
        }
        int x = 1;
        Scanner myObj = new Scanner(System.in);
        while (x != 0){
            System.out.println("Segue abaixo as opções de Select:\n"
                    + "Digite 1: Listagem de Clientes sem E-mail\n"
                    + "Digite 2: Listagem de Produtos que estão vencidos na data atual\n"
                    + "Digite 3: Quantidades de venda realizada no ano de 2020 (Agrupadas por Cliente)\n"
                    + "Digite 4: Listagem de Vendas (contendo o valor da mesma)" + "\n");
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
    
}
