package tools;

import java.util.HashMap;
import java.util.Map;

public class MenuBaseTools {
    private final Map<Integer, String> menuBase = new HashMap<Integer, String>();

    public void mostraMenuDb() {//Menu padrão do programa

        menuBase.put(1, "Base local");
        menuBase.put(2, "Base AWS");

        System.out.println("Escolha uma das opções abaixo:");
        for (Integer key : menuBase.keySet()) {
            System.out.println(key + " - " + menuBase.get(key));
        }
    }
}
