package tools;

import java.util.Scanner;

public class LeitorTecladoIntTools {
    private int valorDigitado;

    public int teclado() {
        Scanner entrada = new Scanner(System.in);

        valorDigitado = entrada.nextInt();
        return valorDigitado;
    }
}
