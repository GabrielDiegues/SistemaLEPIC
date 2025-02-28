/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel
 */
public class FuncoesGerais_DAO {
    public static boolean conferirNumero(int num, String inputUsuario) {
        try {
            num = Integer.parseInt(inputUsuario);
            return true;
        }
        catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, insira os dados corretamente");
            return false;
        }
    }
    
    
    public static void limparCamposAluno() {
        view.Aluno_GUI.rm_txt.setText("");
        view.Aluno_GUI.nome_txt.setText("");
        view.Aluno_GUI.turma_txt.setText("");
    }
    
    
    public static void limparCamposFeedback() {
        view.Feedback_GUI.rmAluno_txt.setText("");
        view.Feedback_GUI.comentario_txt.setText("");
        view.Feedback_GUI.pfTutor_txt.setText("");
    }
}
