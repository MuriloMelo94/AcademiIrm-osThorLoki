package controller;

import dao.ConnectionFactory;
import dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import model.Usuario;
import view.LoginView;
import view.MensagensAvisosView;
import view.MenuView;

public class LoginController {
    private LoginView view;

    public LoginController(LoginView view) {
        this.view = view;
    }

    public void autenticar() throws SQLException {
        //captura um usuário da view
        
        String usuarioDigitadoLogin = view.getCampoLoginUsuario().getText();
        String senhaDigitadaLogin = view.getCampoSenhaLogin().getText();
        Usuario usuarioAutenticavel = new Usuario (usuarioDigitadoLogin, senhaDigitadaLogin);
        
        //verifica se existe no BD
        
        Connection conexao = new ConnectionFactory().connectionPostgreSQL();
        UsuarioDAO usuarioAutenticando = new UsuarioDAO(conexao);

        boolean existeUsuarioNoBD = usuarioAutenticando.existeNoBancoPorUsuarioESenha(usuarioAutenticavel);
        
        conexao.close();
        //se existir direcina para menu
        if (existeUsuarioNoBD) {
            MenuView telaDeMenu = new MenuView();
            telaDeMenu.setVisible(true);
            
        } else {
            MensagensAvisosView telaUsuarioInvalido = new MensagensAvisosView();
            telaUsuarioInvalido.mostrarMensagem("Usuário ou senha inválidos!", "Falha no Login", 2);
        }
        
    }
    
    
}
