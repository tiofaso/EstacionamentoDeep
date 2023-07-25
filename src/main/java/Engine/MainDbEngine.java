package Engine;

import tools.LeitorTecladoIntTools;
import tools.MenuBaseTools;

public class MainDbEngine {
        private int baseEscolhida;
        private boolean escolhaDb;
    public int showMainDb() {//Trata da exibição e escolha da base a ser trabalhada
        LeitorTecladoIntTools tecladoInt = new LeitorTecladoIntTools();

        //Exibindo o menu para escolher a base de dados para operar o exercício
        MenuBaseTools escolheBase = new MenuBaseTools();
        escolheBase.mostraMenuDb();

        escolhaDb = false;

        while((escolhaDb == false)){
            baseEscolhida = tecladoInt.teclado();

            if(baseEscolhida < 1 || baseEscolhida > 2) {
                System.out.println("\nAVISO > É preciso escolher uma base para continuar!\n");
                escolhaDb = false;
                escolheBase.mostraMenuDb();

            }else { escolhaDb = true; }
        };

        return baseEscolhida;
    }//end showMain


}
