package Engine;

import connection.InserirCarroConnection;
import tools.LeitorTecladoStringTools;

public class InsereCarroEngine {
    private String nomeDono;
    private String marcaCarro;
    private String placa;

    public void inserirCarro(int db){
        LeitorTecladoStringTools entrada = new LeitorTecladoStringTools();

        System.out.println("Digite o nome do dono:");
        nomeDono = entrada.teclado();

        System.out.println("Digite a marca do carro:");
        marcaCarro = entrada.teclado();

        System.out.println("Digite a placa do carro:");
        placa = entrada.teclado();

        InserirCarroConnection novoCarro = new InserirCarroConnection();
        novoCarro.insereCarroDb(nomeDono, marcaCarro, placa, db);

    }
}
