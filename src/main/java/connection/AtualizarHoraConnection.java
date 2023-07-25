package connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.time.LocalTime;

public class AtualizarHoraConnection {
    private Connection conexao;
    private double valorAtualizado;
    private double valorInicial;
    private String horaEntrada;

    private String permanencia;

    private Duration duracao;
    public void atualizaTicket(int db, int id){
        String sql = "SELECT carroid, entrada , valorpago " +
                " FROM tb_estacionamento WHERE carroid = '" + id + "'";

        //Abrindo conexão
        if(db == 1) {
            conexao= ConexaoLocalConnection.getConnection();
        }else {
            conexao = ConexaoAwsConnection.getConnection();
        }

        try{
            if(conexao != null) {
                Statement statement = conexao.createStatement();

                ResultSet resultSet = statement.executeQuery(sql);

                while (resultSet.next()) {
                    horaEntrada = resultSet.getString("entrada");
                    valorInicial = resultSet.getDouble("valorpago");
                }

            }

        }catch (SQLException e) {
            System.out.println("Não foi possível mostrar o carro selecionado. Veja o motivo a seguir:");

            e.printStackTrace();
        }

        //Fazendo os cálculos tempo estacionado
        //Fazendo comparações
        LocalTime horaInicial = LocalTime.parse(horaEntrada);
        LocalTime horaAtual = LocalTime.now();

        duracao = Duration.between(horaInicial, horaAtual);

        if (duracao.toMinutes() < 60) { //Menos de uma hora estacionado
            valorAtualizado =  valorInicial;
        }else if(duracao.toMinutes() >= 720) {//Passou de 12h estacionado
            valorAtualizado = 90;
        }else {//Cobrança por meia hora adicional a partir de 1h estacionado
            valorAtualizado = (duracao.toMinutes()/30); //Removendo uma hora do tempo estacionado
            valorAtualizado = valorAtualizado * 2; //Multipliocando o tempo excedente por R$2
            valorAtualizado = valorAtualizado + 10; //Adicionando o valor da primeira hora
        }

        permanencia = String.valueOf(duracao.toMinutes());

        //Atualizando base
        sql = "UPDATE tb_estacionamento SET valorpago = '"+ valorAtualizado +"' , "+
                " permanencia = '" + permanencia + "' WHERE carroid = '" + id + "'";

        try{

            if(conexao != null) {
                Statement statement = conexao.createStatement();

                statement.executeUpdate(sql);

                System.out.println("Ticket atualizado com sucesso na base de dados!");
            }

        }catch (SQLException e) {
            System.out.println("Não foi possível atualizar o ticket na base de dados. Veja o motivo a seguir:");

            e.printStackTrace();
        }

    }

}
