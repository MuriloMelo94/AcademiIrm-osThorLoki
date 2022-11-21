package controller;

import dao.ConnectionFactory;

public class Main {

    public static void main(String[] args) {
        
        Controle controle = new Controle();
        ConnectionFactory.connectionPostgreSQL();
        ConnectionFactory.closeConnectionPostgreSQL();
        controle.iniciarSistema();
    }
    
}
