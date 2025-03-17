/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel
 */
public class TesteConexao_DB {
    // Variáveis
    private static final String url = "jdbc:mysql://localhost/treinamento_vr";
    private static final String username = userName;
    private static final String password = passWord;
    
    
    // Funções
    public static Connection testarConexao() {
        try {
            return (Connection) DriverManager.getConnection(url, username, password);
        }
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível estabelecer uma conexão com o banco de dados");
            return null;
        }
    }
}
