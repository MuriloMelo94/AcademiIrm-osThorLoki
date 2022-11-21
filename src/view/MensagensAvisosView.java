package view;

import javax.swing.JOptionPane;

public class MensagensAvisosView {
    //monta o menu
    public String montarMenu(){
        //opções do menu
        String menu = "1. Cadastrar Cliente\n"
                    + "2. Buscar Cliente\n"
                    + "3. Editar Cliente\n"
                    + "4. Excluir Cliente\n"
                    + "0. Sair\n\n";
        
        return JOptionPane.showInputDialog(
                null,
                menu, //mensagem
                ":: CONTROLE DE CLIENTES ::", //título
                -1);
    } //fecha o método montarMenu
    
    // mostra o resultado
    public void mostrarMensagem(String mensagem, String titulo, int icone){
        
        JOptionPane.showMessageDialog(
            null,
            mensagem,
            titulo,
            icone);
    } // fecha o método mostrarMensagem
    
    // mostra a tela de confirmação
    public int confirmarSaida(String mensagem, String titulo, int icone){
        
       return JOptionPane.showConfirmDialog(
                null,
                mensagem,
                titulo,
                JOptionPane.YES_NO_OPTION,
                icone);  

    } // fecha o método confirmarSaida
}
