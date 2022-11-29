package controller;

import dao.ConnectionFactory;
import dao.FuncionarioDAO;
import static java.lang.Float.parseFloat;
import static java.lang.Long.parseLong;
import java.sql.Connection;
import java.sql.SQLException;
import model.Funcionario;
import view.FormCadastroFuncionarioView;
import view.MensagensAvisosView;

public class FormCadastroFuncionarioController {
    
    private FormCadastroFuncionarioView view;
    
    public FormCadastroFuncionarioController(FormCadastroFuncionarioView view){
        this.view = view;
    }

    public void salvaNovoFuncionario() throws SQLException{
        
        // recebe o que foi digitado na Tela de Cadastramento
        String nomeNovoFuncionario = view.getCampoNomeNovoFuncionario().getText();
        String funcaoNovoFuncionario = view.getCampoFuncaoNovoFuncionario().getText();
        float salarioNovoFuncionario = parseFloat(view.getCampoSalarioNovoFuncionario().getText());
        String enderecoNovoFuncionario = view.getCampoEnderecoNovoFuncionario().getText();
        long telefoneNovoFuncionario = parseLong(view.getCampoTelefoneNovoFuncionario().getText());
        
        // guardar o que foi digitado num objeto do tipo usuario
        Funcionario novoFuncionarioCadastrado = new Funcionario(nomeNovoFuncionario, funcaoNovoFuncionario, salarioNovoFuncionario, enderecoNovoFuncionario, telefoneNovoFuncionario);
        
        // cria uma conexão com o banco de dados
        Connection conexao = new ConnectionFactory().connectionPostgreSQL();
        
        //cria um usuárioDAO pra chamar a função de verificar se existe no BD através do "If Else" e dps inserir(insert)
        //passa a conexao como parametro para que o usuarioDAO crie um objeto com aquela conexão única
        FuncionarioDAO funcionarios = new FuncionarioDAO(conexao);
        
        if (funcionarios.existeNoBancoSomentePorNome(novoFuncionarioCadastrado)){
            MensagensAvisosView telaAvisoUsuarioCadastradoJaExiste = new MensagensAvisosView();
            telaAvisoUsuarioCadastradoJaExiste.mostrarMensagem("Funcionário já existe no Banco de dados", "Funcionário Existente", 1);
            conexao.close();
        } else {
            //insere o usuario no banco
            funcionarios.insert(novoFuncionarioCadastrado);
            
            //fecha a conexão e avisa que o cadastro deu certo
            conexao.close();
            MensagensAvisosView telaAvisoUsuarioCadastradoSucesso = new MensagensAvisosView();
            telaAvisoUsuarioCadastradoSucesso.mostrarMensagem("Funcionário cadastrado com sucesso", "Novo Funcionário", 1);
        }
    }
}
