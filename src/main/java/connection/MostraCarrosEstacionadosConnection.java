package connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MostraCarrosEstacionadosConnection {
    private Connection conexao;
    private String sql;
    public void listaCarrosEstacionados(int db){
        String sql = "SELECT tb_carro.id, tb_carro.nomedono , tb_carro.marcacarro , tb_carro.placa, " +
                    " tb_carro.estado , tb_estacionamento.carroid, tb_estacionamento.entrada, tb_estacionamento.valorpago" +
                    " FROM tb_carro INNER JOIN tb_estacionamento ON tb_carro.id = tb_estacionamento.carroid " +
                    "WHERE tb_carro.estado = 'true' ORDER BY tb_carro.id";

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
                        System.out.println("ID: " + resultSet.getLong("carroid") + " | " + "NOME DO DONO: " + resultSet.getString("nomedono") +
                                " | " + "MARCA: " + resultSet.getString("marcacarro") + " | " + "ENTRADA: " + resultSet.getString("entrada") +
                                " | " + "VALOR ATUAL: R$" + resultSet.getDouble("valorpago"));
                        System.out.println("------`---------------------------------------------------------------------");
                }

            }

        }catch (SQLException e) {
            System.out.println("Não foi possível mostrar o conteúdo do Rebelde selecionado. Veja o motivo a seguir:");

            e.printStackTrace();
        }

    }
}
