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
            String sql = "INSERT INTO usuario (usuario,senha) values('"+usuario.getUsuario().toUpperCase()+"','"+usuario.getSenha()+"'); ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.execute();
            
        } catch (SQLException e){
            throw new RuntimeException("Houve um erro ao cadastrar o novo usuário!", e);
        }
    }
    
    public boolean existeNoBancoPorUsuarioESenha(Usuario usuario){
        try {
            String sql = "SELECT * FROM usuario WHERE usuario = '"+usuario.getUsuario().toUpperCase()+"' AND senha = '"+usuario.getSenha()+"'";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.execute();
            ResultSet resultSet = stm.getResultSet();
            
            return resultSet.next();
            
        } catch (SQLException e){
            throw new RuntimeException("Houve um erro ao cadastrar o novo usuário!", e);
        }
    }
    
        public boolean existeNoBancoSomentePorUsuario(Usuario usuario){
        try {
            String sql = "SELECT * FROM usuario WHERE usuario = '"+usuario.getUsuario().toUpperCase()+"'";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.execute();
            ResultSet resultSet = stm.getResultSet();
            
            return resultSet.next();
            
        } catch (SQLException e){
            throw new RuntimeException("Houve um erro ao cadastrar o novo usuário!", e);
        }
    }
}
