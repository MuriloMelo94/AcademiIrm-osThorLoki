package dao;

import java.sql.*;

public class ConnectionFactory {
    private static Connection conexao_PostgreSQL = null;
    private static String localBD = "localhost";
    private static String LINK1 = "jdbc:postgresql://"+localBD+":5432/banco_A3";
    private static final String usuario = "postgres";
    private static final String senha = "123";
    
    public static Connection connectionPostgreSQL(){
        
        try {
            conexao_PostgreSQL = DriverManager.getConnection(LINK1, usuario, senha);
            System.out.println("Teste: Conexão com o BD aberta com sucesso!");
        } catch (SQLException e){
            throw new RuntimeException("Ocorreu um problema ao conectar com o Banco de Dados", e);
        }
        
        return conexao_PostgreSQL;
    }
    
    public static void closeConnectionPostgreSQL(){
        try {
            if (conexao_PostgreSQL != null){
                conexao_PostgreSQL.close();
                System.out.println("Teste: Conexão com o BD fechada com sucesso.");
            }
        } catch (SQLException e){
            throw new RuntimeException("Ocorreu um problema ao encerrar a conexão com o Banco de Dados. ", e);
        }
    }
}
