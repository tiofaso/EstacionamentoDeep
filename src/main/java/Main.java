import Engine.MainDbEngine;
import Engine.MainEngine;

public class Main {
    public static void main(String[] args) {
        MainDbEngine base = new MainDbEngine(); //definindo base para trabalhar

        MainEngine sistema = new MainEngine(); //iniciando o sistema
        sistema.showMain(base.showMainDb());
    }//End static

}
