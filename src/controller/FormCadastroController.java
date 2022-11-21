package controller;

import dao.ConnectionFactory;
import dao.UsuarioDAO;
import java.sql.Connection;
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
    
    public void salvaNovoUsuario(){
        
        String loginNovoUsuario = view.getCampoTextoNovoUsuario().getText();
        String senhaNovoUsuario = view.getCampoSenhaNovoUsuario().getText();
        
        Usuario novoUsuarioCadastrado = new Usuario(loginNovoUsuario, senhaNovoUsuario);
        
        Connection conexao = new ConnectionFactory().connectionPostgreSQL();
        UsuarioDAO usuarios = new UsuarioDAO(conexao);
        usuarios.insert(novoUsuarioCadastrado);
        MensagensAvisosView telaAvisoUsuarioCadastrado = new MensagensAvisosView();
        telaAvisoUsuarioCadastrado.mostrarMensagem("Usuário cadastrado com sucesso", "Novo Usuário", 1);

    }
}
