/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel
 */
public class Login_DAO {
    public static boolean conferirUsuario() {
        Connection conexaoDB = controller.TesteConexao_DB.testarConexao();
        int pf;
        String senha = view.Login_GUI.senhaLogin_txt.getText();
        try {
            pf = Integer.parseInt(view.Login_GUI.pfLogin_txt.getText());
        }
        catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, digite os dados corretamente");
            return false;
        }
        
        if(conexaoDB == null) {
            JOptionPane.showMessageDialog(null, "Falha ao se conectar com o banco de dados! Não é possível realizar login no momento.");
            return false;
        }
        try {
            String sql = "SELECT(senha) FROM tutor WHERE pf = " + pf;
            PreparedStatement stm = (PreparedStatement) conexaoDB.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            if(rs.next()) {
                if(senha.equals(rs.getString("senha"))) {
                    return true;
                }
                JOptionPane.showMessageDialog(null, "Login ou senha incorretos");
                return false;
            }
            else {
                JOptionPane.showMessageDialog(null, "Tutor não cadastrado");
            }
            return false;
        }
        catch(Exception e2) {
            JOptionPane.showMessageDialog(null, "Erro na busca!");
            return false;
        }
    }
}
