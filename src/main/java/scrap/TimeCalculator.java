package scrap;

import java.sql.Time;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.time.temporal.Temporal;

//Testando função para fazer cálculos com horas
public class TimeCalculator {
    public static void main(String[] args) {
        String horaDb = "19:53:08";

        LocalTime horaInicial = LocalTime.parse(horaDb);
        LocalTime horaAtual = LocalTime.now();

        Duration duracao = (Duration.between(horaInicial, horaAtual));



        System.out.println(Math.abs(duracao.toHours()) + " horas e " + Math.abs(duracao.toMinutesPart()) + " minutos");
        System.out.println(Math.abs(duracao.toMinutes()) + " minutos");

        //Fazendo comparações
        if (Math.abs(duracao.toMinutes()) < 60) {
            System.out.println("Ainda não passou de 1h estacionado");
        }else {
            System.out.println("Passou de 1h estacionado");
        }

        //Comparações pela tabela de valores
        System.out.println((Math.abs(duracao.toMinutes()/60)-1));
    }

}
