package tools;

import java.util.HashMap;
import java.util.Map;

public class MenuTools {
    private final Map<Integer, String> menu = new HashMap<Integer, String>();

    public void mostraMenu() {//Menu padrão do programa

        menu.put(1, "Inserir carros");
        menu.put(2, "Atualizar comanda");
        menu.put(3, "Baixa na comanda");
        menu.put(4, "Mostra carros (estacionados)");

        System.out.println("Escolha uma das opções abaixo:");
        for (Integer key : menu.keySet()) {
            System.out.println(key + " - " + menu.get(key));
        }
    }
}
