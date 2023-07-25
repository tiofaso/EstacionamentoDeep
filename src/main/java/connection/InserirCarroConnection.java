package connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InserirCarroConnection {
    private String sql;
    private int idCarro;
    private Connection conexao;

    public void insereCarroDb(String nomedono, String marcacarro, String placa, int db){
        sql = "INSERT INTO tb_carro (nomedono, marcacarro, placa, estado, usuario) " +
            "VALUES ('" + nomedono + "', '" + marcacarro + "', '" + placa +  "'," +
            "'true', 'faso')";

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

                System.out.println("Carro inserido com sucesso na base de dados!");
            }

        }catch (SQLException e) {
            System.out.println("Não foi possível inserir o carro na base de dados. Veja o motivo a seguir:");

            e.printStackTrace();
        }

        //Consultando id do carro
        BuscaIdConnection carro = new BuscaIdConnection();
        idCarro = carro.buscaId(db, nomedono);

        //Inseriando a hora que o carro estacionou
        CarroEntradaConnection estacionado = new CarroEntradaConnection();
        estacionado.estacionaCarro(db, idCarro);
    }
}
