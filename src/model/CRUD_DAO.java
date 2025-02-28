/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel
 */
public class CRUD_DAO {
    // funcoes
    public static void cadastrarAluno() {
        int rm = 0;
        if(!FuncoesGerais_DAO.conferirNumero(rm, view.Aluno_GUI.rm_txt.getText())) { return; }
        rm = Integer.parseInt(view.Aluno_GUI.rm_txt.getText());
        String nome = view.Aluno_GUI.nome_txt.getText();
        String turma = view.Aluno_GUI.turma_txt.getText();
        
        Connection conexaoDB = controller.TesteConexao_DB.testarConexao();
        if(conexaoDB == null) { return; }
        try{
            String sql = "INSERT INTO aluno(rm, nome, turma) VALUES('"+rm+"', '"+nome+"', '"+turma+"')";
            PreparedStatement inserir = (PreparedStatement) conexaoDB.prepareStatement(sql);
            inserir.execute();
            JOptionPane.showMessageDialog(null, "Inserção realizada com sucesso");
            FuncoesGerais_DAO.limparCamposAluno();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na inserção!");
        }
    }
    
    
    public static void consultarAluno() {
        int rm = 0;
        if(!FuncoesGerais_DAO.conferirNumero(rm, view.Aluno_GUI.rm_txt.getText())) { return; }
        rm = Integer.parseInt(view.Aluno_GUI.rm_txt.getText());
        
        Connection conexaoDB = controller.TesteConexao_DB.testarConexao();
        if(conexaoDB == null) { return; }
        try {
            String sql = "SELECT rm, nome, turma FROM aluno WHERE rm = " + rm;
            PreparedStatement stm = (PreparedStatement) conexaoDB.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            if(rs.next()) {
                view.Aluno_GUI.nome_txt.setText(rs.getString("nome"));
                view.Aluno_GUI.turma_txt.setText(rs.getString("turma"));
            }
            else {
                JOptionPane.showMessageDialog(null, "Aluno não encontrado");
                FuncoesGerais_DAO.limparCamposAluno();
            }
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na busca");
        }
    }
    
    
    public static void alterarALuno() {
        int rm = 0;
        if(!FuncoesGerais_DAO.conferirNumero(rm, view.Aluno_GUI.rm_txt.getText())) { return; }
        rm = Integer.parseInt(view.Aluno_GUI.rm_txt.getText());
        
        Connection conexaoDB = controller.TesteConexao_DB.testarConexao();
        if(conexaoDB == null) { return; }
        
        String nome = view.Aluno_GUI.nome_txt.getText();
        String turma = view.Aluno_GUI.turma_txt.getText();
        try {
            String sql = "UPDATE aluno SET nome = '"+nome+"', turma = '"+turma+"' WHERE rm = '"+rm+"'";
            PreparedStatement inserir = (PreparedStatement) conexaoDB.prepareStatement(sql);
            int tabelaAfetada = inserir.executeUpdate();
            if(tabelaAfetada == 0) {                
                JOptionPane.showMessageDialog(null, "Aluno não encontrado");
            }
            else {
                JOptionPane.showMessageDialog(null, "Update realizado com sucesso!");
            }
            FuncoesGerais_DAO.limparCamposAluno();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no update");
        }
    }
    
    
    public static void excluirAluno() {
        int rm = 0;
        if(!FuncoesGerais_DAO.conferirNumero(rm, view.Aluno_GUI.rm_txt.getText())) { return; }
        rm = Integer.parseInt(view.Aluno_GUI.rm_txt.getText());
        
        Connection conexaoDB = controller.TesteConexao_DB.testarConexao();
        if(conexaoDB == null) { return; }
        
        try {
            String sql = "DELETE FROM aluno WHERE rm = " + rm;
            PreparedStatement inserir = (PreparedStatement) conexaoDB.prepareStatement(sql);
            int tabelaAfetada = inserir.executeUpdate();
            if(tabelaAfetada == 0) {                
                JOptionPane.showMessageDialog(null, "Aluno não encontrado");
            }
            else {
                JOptionPane.showMessageDialog(null, "Delete realizado com sucesso!");
            }
            FuncoesGerais_DAO.limparCamposAluno();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar a exclusão!");
        }
    }
    
    
    public static void cadastrarFeedback() {
        int rmAluno = 0;
        if(!FuncoesGerais_DAO.conferirNumero(rmAluno, view.Feedback_GUI.rmAluno_txt.getText())) { return; }
        int pfTutor = 0;
        if(!FuncoesGerais_DAO.conferirNumero(pfTutor, view.Feedback_GUI.pfTutor_txt.getText())) { return; }
        
        Connection conexaoDB = controller.TesteConexao_DB.testarConexao();
        if(conexaoDB == null) { return; }
        rmAluno = Integer.parseInt(view.Feedback_GUI.rmAluno_txt.getText());
        pfTutor = Integer.parseInt(view.Feedback_GUI.pfTutor_txt.getText());
        String status = (String) view.Feedback_GUI.aprovado_cBox.getSelectedItem();
        String comentario = view.Feedback_GUI.comentario_txt.getText();
        
        try{
            String sql = "INSERT INTO feedback(comentario, status, aluno_rm, tutor_pf) VALUES('"+comentario+"', '"+status+"', '"+rmAluno+"', '"+pfTutor+"')";
            PreparedStatement inserir = (PreparedStatement) conexaoDB.prepareStatement(sql);
            inserir.executeUpdate();
            JOptionPane.showMessageDialog(null, "Inserção realizada com sucesso");
            FuncoesGerais_DAO.limparCamposFeedback();
        }
        catch(SQLIntegrityConstraintViolationException e) {
            int codigoErro = e.getErrorCode();
            if(codigoErro == 1062 || codigoErro == 23505) {
             JOptionPane.showMessageDialog(null, "Erro: Violação de restrição de unicidade. O registro já existe.");   
            }
            else if(codigoErro == 1452 || codigoErro == 23505) {
                JOptionPane.showMessageDialog(null, "RM do aluno ou PF do professor incorretos");
            }
        }
        catch(Exception e2) {
            JOptionPane.showMessageDialog(null, "Erro na inserção!");
        }
    }
    
    
    public static void consultarFeedback() {
        int rmAluno = 0;
        if(!FuncoesGerais_DAO.conferirNumero(rmAluno, view.Feedback_GUI.rmAluno_txt.getText())) { return; }
        
        Connection conexaoDB = controller.TesteConexao_DB.testarConexao();
        if(conexaoDB == null) { return; }
        rmAluno = Integer.parseInt(view.Feedback_GUI.rmAluno_txt.getText());
        try {
            String sql = "SELECT comentario, status, aluno_rm, tutor_pf FROM feedback WHERE aluno_rm = " + rmAluno;
            PreparedStatement stm = (PreparedStatement) conexaoDB.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            if(rs.next()) {
                view.Feedback_GUI.comentario_txt.setText(rs.getString("comentario"));
                view.Feedback_GUI.aprovado_cBox.setSelectedItem(rs.getString("status"));
                view.Feedback_GUI.pfTutor_txt.setText(rs.getString("tutor_pf"));
            }
            else {
                JOptionPane.showMessageDialog(null, "Nenhum registro encontrado para o RM digitado");
                FuncoesGerais_DAO.limparCamposFeedback();
            }
        }
        catch(Exception e2) {
            JOptionPane.showMessageDialog(null, "Erro na consulta");
        }
    }
    
    
    public static void alterarFeedback() {
        int pfTutor = 0;
        if(!FuncoesGerais_DAO.conferirNumero(pfTutor, view.Feedback_GUI.pfTutor_txt.getText())) { return; }
        int rmAluno = 0;
        if(!FuncoesGerais_DAO.conferirNumero(rmAluno, view.Feedback_GUI.rmAluno_txt.getText())) { return; }
        Connection conexaoDB = controller.TesteConexao_DB.testarConexao();
        if(conexaoDB == null) { return; }
        rmAluno = Integer.parseInt(view.Feedback_GUI.rmAluno_txt.getText());
        pfTutor = Integer.parseInt(view.Feedback_GUI.pfTutor_txt.getText());
        String status = (String) view.Feedback_GUI.aprovado_cBox.getSelectedItem();
        String comentario = view.Feedback_GUI.comentario_txt.getText();
        
        try{
            String sql = "UPDATE feedback SET comentario = '"+comentario+"', status = '"+status+"', tutor_pf = '"+pfTutor+"' WHERE aluno_rm = '"+rmAluno+"'";
            PreparedStatement inserir = (PreparedStatement) conexaoDB.prepareStatement(sql);
            int tabelaAlterada = inserir.executeUpdate();
            if(tabelaAlterada == 0) {
                JOptionPane.showMessageDialog(null, "RM do aluno ou PF do professor incorretos");
                
            }
            else {
                JOptionPane.showMessageDialog(null, "Inserção realizada com sucesso");
                FuncoesGerais_DAO.limparCamposFeedback();
            }
        }
        catch(SQLIntegrityConstraintViolationException e) {
            int codigoErro = e.getErrorCode();
            if(codigoErro == 1062 || codigoErro == 23505) {
             JOptionPane.showMessageDialog(null, "Erro: Violação de restrição de unicidade. O registro já existe.");   
            }
            else if(codigoErro == 1452 || codigoErro == 23505) {
                JOptionPane.showMessageDialog(null, "RM do aluno ou PF do professor incorretos");
            }
        }
        catch(Exception e2) {
            JOptionPane.showMessageDialog(null, "Erro na inserção!");
        }
    }
    
    public static void excluirFeedback() {
        int rmAluno = 0;
        if(!FuncoesGerais_DAO.conferirNumero(rmAluno, view.Feedback_GUI.rmAluno_txt.getText())) { return; }
        
        Connection conexaoDB = controller.TesteConexao_DB.testarConexao();
        if(conexaoDB == null) { return; }
        rmAluno = Integer.parseInt(view.Feedback_GUI.rmAluno_txt.getText());
        try {
            String sql = "DELETE FROM feedback WHERE aluno_rm = " + rmAluno;
            PreparedStatement inserir = (PreparedStatement) conexaoDB.prepareStatement(sql);
            int tabelaAfetada = inserir.executeUpdate();
            if(tabelaAfetada == 0) {                
                JOptionPane.showMessageDialog(null, "RM não encontrado");
            }
            else {
                JOptionPane.showMessageDialog(null, "Delete realizado com sucesso!");
            }
            FuncoesGerais_DAO.limparCamposFeedback();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar a exclusão!");
            e.printStackTrace();
        }
    }
}
