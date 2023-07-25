package tools;

import java.util.Scanner;

public class LeitorTecladoDoubleTools {
    private Double valorDigitado;

    public Double teclado() {
        Scanner entrada = new Scanner(System.in);

        valorDigitado = entrada.nextDouble();
        return valorDigitado;
    }
}
