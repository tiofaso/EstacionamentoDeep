package tools;

import Engine.InsereCarroEngine;
import connection.AtualizarHoraConnection;
import connection.CarroSaidaConnection;
import connection.MostraCarrosEstacionadosConnection;

public class ExecutarMenuTools {
    LeitorTecladoIntTools entrada = new LeitorTecladoIntTools();

    public void executarEscolhas(int db,int menu){
        switch (menu){
            case 1: //Inserir carros
                System.out.println("> ENTRADA DE CARRO");

                InsereCarroEngine novo = new InsereCarroEngine();
                novo.inserirCarro(db);
                break;
            case 2: //Atualizar comanda
                System.out.println("> ATUALIZAR TICKET");

                System.out.println("Selecione um carro para atualizar o valor a ser pago");
                MostraCarrosEstacionadosConnection qualMudar = new MostraCarrosEstacionadosConnection();
                qualMudar.listaCarrosEstacionados(db);


                int idCarroMuda = entrada.teclado();

                AtualizarHoraConnection novoValor = new AtualizarHoraConnection();
                novoValor.atualizaTicket(db,idCarroMuda);
                break;
            case 3: //Baixa na comanda
                System.out.println("> SAÍDA DE CARRO");

                System.out.println("Selecione um carro para dar baixa");
                MostraCarrosEstacionadosConnection qualSair = new MostraCarrosEstacionadosConnection();
                qualSair.listaCarrosEstacionados(db);

                int idCarroSai = entrada.teclado();

                CarroSaidaConnection saida = new CarroSaidaConnection();
                saida.finalizaTicket(db, idCarroSai);
                break;
            case 4: //Mostra carros (estacionados)
                System.out.println("> CARROS ESTACIONADOS");

                MostraCarrosEstacionadosConnection show = new MostraCarrosEstacionadosConnection();
                show.listaCarrosEstacionados(db);
                break;
        }//end switch
    }
}
