package dao;

import java.sql.Connection;
import model.Usuario;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class UsuarioDAO {
    
    private final Connection connection;
    
    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }
    
    public void insert(Usuario usuario){
        try {
            String sql = "INSERT INTO usuario (usuario,senha) values('"+usuario.getUsuario()+"','"+usuario.getSenha()+"'); ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.execute();
            connection.close();
            
        } catch (SQLException e){
            throw new RuntimeException("Houve um erro ao cadastrar o novo usuário!", e);
        }
    }
}
