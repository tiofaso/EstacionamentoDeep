package Engine;

import connection.ConexaoLocalConnection;
import tools.ExecutarMenuTools;
import tools.LeitorTecladoIntTools;
import tools.MenuTools;

public class MainEngine {
    private int menuEscolhido;
    private boolean escolhaMenu;
    private int baseEscolhida;
    public void showMain(int db) { //Motor principal do aplicativo
        LeitorTecladoIntTools tecladoInt = new LeitorTecladoIntTools();

        MenuTools menu = new MenuTools();
        menu.mostraMenu();

        escolhaMenu = false;

        while (escolhaMenu == false){
            menuEscolhido = tecladoInt.teclado();
            if(menuEscolhido < 1 || menuEscolhido > 5) {
                System.out.println("\nAVISO > É preciso escolher uma opção para continuar!\n");
                escolhaMenu = false;
                menu.mostraMenu();

            }else { escolhaMenu = true; }
        }

        //Conectando a base de dados
        baseEscolhida = db;  //1 - base loca e 2 - base aws

        ExecutarMenuTools novaAcao = new ExecutarMenuTools();
        novaAcao.executarEscolhas(baseEscolhida, menuEscolhido);
    }//end showMain
}
