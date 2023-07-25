package connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;

public class CarroEntradaConnection {
    private String sql;
    private Connection conexao;
    public void estacionaCarro(int db, int id){
        sql = "INSERT INTO tb_estacionamento (carroid, entrada, valorpago) " +
                "VALUES ('" + id + "', '" + LocalTime.now() + "', '10')";

        //Abrindo conexão
        if(db == 1) {
            conexao= ConexaoLocalConnection.getConnection();
        }else {
            conexao = ConexaoAwsConnection.getConnection();
        }

        //Primeira inserção de dados
        try{
            if(conexao != null) {
                Statement statement = conexao.createStatement();

                statement.executeUpdate(sql);

                System.out.println("Hora de permanência iniciada com sucesso na base de dados!");
            }

        }catch (SQLException e) {
            System.out.println("Não foi possível inserir a hora que o carro estacionou. Veja o motivo a seguir:");

            e.printStackTrace();
        }

    }
}
