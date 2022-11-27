package dao;

import java.sql.Connection;
import model.Usuario;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {
    
    private final Connection connection;
    
    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }
    
    public void insert(Usuario usuario){
        try {
            String sql = "INSERT INTO usuario (usuario,senha) values(?,?); ";
            PreparedStatement stm = connection.prepareStatement(sql);
            
            // adicionando validação de dados para evitar SQL injection no banco de dados
            stm.setString(1, usuario.getUsuario().toUpperCase());
            stm.setString(2, usuario.getSenha());
            stm.execute();
            
        } catch (SQLException e){
            throw new RuntimeException("Houve um erro ao cadastrar o novo usuário!", e);
        }
    }
    
    public boolean existeNoBancoPorUsuarioESenha(Usuario usuario){
        try {
            String sql = "SELECT * FROM usuario WHERE usuario = ? AND senha = ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            
            // adicionando validação de dados para evitar SQL injection no banco de dados
            stm.setString(1, usuario.getUsuario().toUpperCase());
            stm.setString(2, usuario.getSenha());
            stm.execute();
            ResultSet resultSet = stm.getResultSet();
            
            return resultSet.next();
            
        } catch (SQLException e){
            throw new RuntimeException("Houve um erro ao cadastrar o novo usuário!", e);
        }
    }
    
        public boolean existeNoBancoSomentePorUsuario(Usuario usuario){
        try {
            String sql = "SELECT * FROM usuario WHERE usuario = ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            
            // adicionando validação de dados para evitar SQL injection no banco de dados
            stm.setString(1, usuario.getUsuario().toUpperCase());
            stm.execute();
            ResultSet resultSet = stm.getResultSet();
            
            return resultSet.next();
            
        } catch (SQLException e){
            throw new RuntimeException("Houve um erro ao cadastrar o novo usuário!", e);
        }
    }
}
