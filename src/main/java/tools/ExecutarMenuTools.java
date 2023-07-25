package tools;

import Engine.InsereCarroEngine;
import connection.AtualizarHoraConnection;
import connection.MostraCarrosEstacionadosConnection;

public class ExecutarMenuTools {
    public void executarEscolhas(int db,int menu){
        switch (menu){
            case 1: //Inserir carros
                InsereCarroEngine novo = new InsereCarroEngine();
                novo.inserirCarro(db);
                break;
            case 2: //Atualizar comanda
                System.out.println("Selecione um carro para atualizar o valor a ser pago");
                MostraCarrosEstacionadosConnection qualMudar = new MostraCarrosEstacionadosConnection();
                qualMudar.listaCarrosEstacionados(db);

                LeitorTecladoIntTools entrada = new LeitorTecladoIntTools();
                int idCarroMuda = entrada.teclado();

                AtualizarHoraConnection novoValor = new AtualizarHoraConnection();
                novoValor.atualizaTicket(db,idCarroMuda);
                break;
            case 3: //Baixa na comanda
                break;
            case 4: //Mostra carros (estacionados)
                MostraCarrosEstacionadosConnection show = new MostraCarrosEstacionadosConnection();
                show.listaCarrosEstacionados(db);
                break;
            case 5: //Mostra carros (do sistema)
                break;


        }//end switch
    }
}
