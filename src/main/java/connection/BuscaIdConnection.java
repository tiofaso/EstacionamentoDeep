package connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BuscaIdConnection {
    private String sql;
    private Connection conexao;
    private int idCarro;
    public int buscaId(int db, String nomeDono){
        sql = "SELECT id, nomedono FROM tb_carro";


        //Abrindo conexão
        if(db == 1) {
            conexao= ConexaoLocalConnection.getConnection();
        }else {
            conexao = ConexaoAwsConnection.getConnection();
        }

        try {
            if (conexao != null) {
                Statement statement = conexao.createStatement();

                ResultSet resultSet = statement.executeQuery(sql);

                while (resultSet.next()) {
                    idCarro = resultSet.getInt("id");
                }

            }

        } catch (SQLException e) {
            System.out.println("Não foi possível listar os carros. Veja o motivo a seguir:");

            e.printStackTrace();
        }

        return idCarro;

    }
}
