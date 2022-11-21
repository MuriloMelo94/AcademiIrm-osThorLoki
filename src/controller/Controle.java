package controller;

import view.MensagensAvisosView;

public class Controle {
    
    // método usado para iniciar o sistema
    public void iniciarSistema(){
        
        //cria os objetos
        MensagensAvisosView tela = new MensagensAvisosView();
        
        
        //ativa o sistema
        boolean menuPrincipal = true;
        
        while (menuPrincipal == true){
            
            String opcaoEscolhida = tela.montarMenu();
            
            switch (opcaoEscolhida){
                case "0":
                    menuPrincipal = confirmarSair(tela); // passando o objeto para o outro método
                break;
  
            }
        }
    } // fecha o método iniciar o sistema
    
    // confirmar o encerramento do sistema
    private Boolean confirmarSair(MensagensAvisosView _tela){ // recebendo o objeto do outro método
        
        int sair = _tela.confirmarSaida("Tem certeza?", "Encerrando o Sistema", 3);
            
            if(sair == 0){ // 0 é o sim do menu 
                _tela.mostrarMensagem("Encerrando o sistema", "Encerrando", 1);
                return false;
            }
        return true;
    } // fecha o método confirmarSair
}
