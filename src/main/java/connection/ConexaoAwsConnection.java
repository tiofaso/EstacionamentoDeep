package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoAwsConnection {
    public static Connection getConnection(){//Conexão com a DB
        try{
            Connection connection = DriverManager.getConnection("jdbc:postgresql://estacionamento-aws.cek2nmi2tmwz.sa-east-1.rds.amazonaws.com/estacionamentodeep",
                    "postgres", "root1234");
            return connection;
        }catch (SQLException e){
            System.out.println("Deu ruim aqui na conexão ao AWS! :/");
            e.printStackTrace();
            return null;
        }
    }
}
