package dao;

import java.sql.Connection;
import model.Funcionario;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FuncionarioDAO {
    
    private final Connection connection;
    
    public FuncionarioDAO(Connection connection) {
        this.connection = connection;
    }
    
    public void insert(Funcionario funcionario){
        try {
            String sql = "INSERT INTO funcionario (nome,funcao,salario,endereco,telefone) VALUES(?,?,?,?,?); ";
            PreparedStatement stm = connection.prepareStatement(sql);
            
            // adicionando validação de dados para evitar SQL injection no banco de dados
            stm.setString(1, funcionario.getNome().toUpperCase());
            stm.setString(2, funcionario.getFuncao());
            stm.setFloat(3, funcionario.getSalario());
            stm.setString(4, funcionario.getEndereco());
            stm.setLong(5, funcionario.getTelefone());
            stm.execute();
            
        } catch (SQLException e){
            throw new RuntimeException("Houve um erro ao cadastrar o novo funcionário!", e);
        }
    }
    
    public void update (Funcionario funcionario) {
        try {
            String sql = "UPDATE funcionario SET nome = ?, funcao = ?, salario = ?, endereco = ?, telefone = ? WHERE id = ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            
            // adicionando validação de dados para evitar SQL injection no banco de dados
            stm.setString(1, funcionario.getNome().toUpperCase());
            stm.setString(2, funcionario.getFuncao());
            stm.setFloat(3, funcionario.getSalario());
            stm.setString(4, funcionario.getEndereco());
            stm.setLong(5, funcionario.getTelefone());
            stm.setInt(6, funcionario.getId());
            stm.execute();
            
        } catch (SQLException e){
            throw new RuntimeException("Houve um erro ao atualizar o funcionario!", e);
        }
    }
    
    public void delete(Funcionario funcionario) {
        try {
            String sql = "DELETE FROM funcionario WHERE id = ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            
            // adicionando validação de dados para evitar SQL injection no banco de dados
            stm.setInt(1, funcionario.getId());
            stm.execute();
            
        } catch (SQLException e){
            throw new RuntimeException("Houve um erro ao deletar o funcionario!", e);
        }
    }
    
    public ArrayList<Funcionario> selectAll(){
        try {
            String sql = "SELECT * FROM funcionario";
            PreparedStatement stm = connection.prepareStatement(sql);
            
            return pesquisaListaFuncionarios(stm);
            
        } catch (SQLException e){
            throw new RuntimeException("Houve um erro ao trazer a tabela de funcionarios!", e);
        }
    }

    private ArrayList<Funcionario> pesquisaListaFuncionarios(PreparedStatement stm) throws SQLException {
        // criando o arraylist de usuários
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        
        //executa o statement e traz o resultado da execução do comando sql, guardando na variável resultset
        stm.execute();
        ResultSet resultSet = stm.getResultSet();
        
        // laço enquanto tiver novas linhas do resultado da tebala usuarios, ele trará cada elemento tupla
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String nome = resultSet.getString("nome");
            String funcao = resultSet.getString("funcao");
            float salario = resultSet.getFloat("salario");
            String endereco = resultSet.getString("endereco");
            int telefone = resultSet.getInt("telefone");
            
            Funcionario funcionarioComDadosDoBanco = new Funcionario(id, nome, funcao, salario, endereco, telefone);
            funcionarios.add(funcionarioComDadosDoBanco);
        }
        
        return funcionarios;
    }
    
    public Funcionario selectPorId (Funcionario funcionario){
        try {
            String sql = "SELECT * FROM funcionario WHERE id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, funcionario.getId());
            
            return pesquisaListaFuncionarios(stm).get(0);
            
        } catch (SQLException e){
            throw new RuntimeException("Houve um erro na pesquisa de funcionarios!", e);
        }
    }
    
        public boolean existeNoBancoPorNomeEFuncao(Funcionario funcionario){
        try {
            String sql = "SELECT * FROM funcionario WHERE nome = ? AND funcao = ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            
            // adicionando validação de dados para evitar SQL injection no banco de dados
            stm.setString(1, funcionario.getNome().toUpperCase());
            stm.setString(2, funcionario.getFuncao());
            stm.execute();
            ResultSet resultSet = stm.getResultSet();
            
            return resultSet.next();
            
        } catch (SQLException e){
            throw new RuntimeException("Houve um erro ao cadastrar o novo funcionario!", e);
        }
    }
    
        public boolean existeNoBancoSomentePorNome(Funcionario funcionario){
        try {
            String sql = "SELECT * FROM funcionario WHERE nome = ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            
            // adicionando validação de dados para evitar SQL injection no banco de dados
            stm.setString(1, funcionario.getNome().toUpperCase());
            stm.execute();
            ResultSet resultSet = stm.getResultSet();
            
            return resultSet.next();
            
        } catch (SQLException e){
            throw new RuntimeException("Houve um erro ao cadastrar o novo funcionario!", e);
        }
    }
    
}
