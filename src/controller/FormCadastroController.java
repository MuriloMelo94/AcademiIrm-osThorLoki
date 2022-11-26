package controller;

import dao.ConnectionFactory;
import dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import model.Usuario;
import view.FormCadastroView;
import view.MensagensAvisosView;

public class FormCadastroController {
    
    private FormCadastroView view;
    
    public FormCadastroController(FormCadastroView view){
        this.view = view;
    }

    public FormCadastroController() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void salvaNovoUsuario() throws SQLException{
        
        // recebe o que foi digitado na Tela de Cadastramento
        String loginNovoUsuario = view.getCampoTextoNovoUsuario().getText();
        String senhaNovoUsuario = view.getCampoSenhaNovoUsuario().getText();
        
        // guardar o que foi digitado num objeto do tipo usuario
        Usuario novoUsuarioCadastrado = new Usuario(loginNovoUsuario, senhaNovoUsuario);
        
        // cria uma conexão com o banco de dados
        Connection conexao = new ConnectionFactory().connectionPostgreSQL();
        
        //cria um usuárioDAO pra chamar a função de verificar se existe no BD através do "If Else" e dps inserir(insert)
        //passa a conexao como parametro para que o usuarioDAO crie um objeto com aquela conexão única
        UsuarioDAO usuarios = new UsuarioDAO(conexao);
        
        if (usuarios.existeNoBancoSomentePorUsuario(novoUsuarioCadastrado)){
            MensagensAvisosView telaAvisoUsuarioCadastradoJaExiste = new MensagensAvisosView();
            telaAvisoUsuarioCadastradoJaExiste.mostrarMensagem("Usuário já existe no Banco de dados", "Usuário Existente", 1);
            conexao.close();
        } else {
            //insere o usuario no banco
            usuarios.insert(novoUsuarioCadastrado);
            
            //fecha a conexão e avisa que o cadastro deu certo
            conexao.close();
            MensagensAvisosView telaAvisoUsuarioCadastradoSucesso = new MensagensAvisosView();
            telaAvisoUsuarioCadastradoSucesso.mostrarMensagem("Usuário cadastrado com sucesso", "Novo Usuário", 1);
        }
    }
}
