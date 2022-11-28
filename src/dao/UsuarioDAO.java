package dao;

import java.sql.Connection;
import model.Usuario;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
    
    public void update (Usuario usuario) {
        try {
            String sql = "UPDATE usuario SET usuario = ?, senha = ? WHERE id = ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            
            // adicionando validação de dados para evitar SQL injection no banco de dados
            stm.setString(1, usuario.getUsuario().toUpperCase());
            stm.setString(2, usuario.getSenha());
            stm.setInt(3, usuario.getId());
            stm.execute();
            
        } catch (SQLException e){
            throw new RuntimeException("Houve um erro ao atualizar o novo usuário!", e);
        }
    }
    
    public void delete(Usuario usuario) {
        try {
            String sql = "DELETE FROM usuario WHERE id = ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            
            // adicionando validação de dados para evitar SQL injection no banco de dados
            stm.setInt(1, usuario.getId());
            stm.execute();
            
        } catch (SQLException e){
            throw new RuntimeException("Houve um erro ao deletar o novo usuário!", e);
        }
    }
    
    public ArrayList<Usuario> selectAll(){
        try {
            String sql = "SELECT * FROM usuario";
            PreparedStatement stm = connection.prepareStatement(sql);
            
            return pesquisaListaUsuarios(stm);
            
        } catch (SQLException e){
            throw new RuntimeException("Houve um erro ao trazer a tabela de usuários!", e);
        }
    }

    private ArrayList<Usuario> pesquisaListaUsuarios(PreparedStatement stm) throws SQLException {
        // criando o arraylist de usuários
        ArrayList<Usuario> usuarios = new ArrayList<>();
        
        //executa o statement e traz o resultado da execução do comando sql, guardando na variável resultset
        stm.execute();
        ResultSet resultSet = stm.getResultSet();
        
        // laço enquanto tiver novas linhas do resultado da tebala usuarios, ele trará cada elemento tupla
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String usuario = resultSet.getString("usuario");
            
            Usuario usuarioComDadosDoBanco = new Usuario(id, usuario);
            usuarios.add(usuarioComDadosDoBanco);
        }
        
        return usuarios;
    }
    
    public Usuario selectPorId (Usuario usuario){
        try {
            String sql = "SELECT * FROM usuario WHERE id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, usuario.getId());
            
            return pesquisaListaUsuarios(stm).get(0);
            
        } catch (SQLException e){
            throw new RuntimeException("Houve na pesquisa de usuários!", e);
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
