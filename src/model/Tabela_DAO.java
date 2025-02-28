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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gabriel
 */
public class Tabela_DAO {
    // Variáveis
    private static int rm;
    private static int tamanhoArray;
    private static Connection conexaoDB;
    public static void criarTabela() {
        if(alunoTemEstatistica()) {
            
            Object[][] dadosArray = new Object[tamanhoArray][5];
            Object[] colunasArray = {"Partidas Jogadas", "Data", "Melhor Tempo", "Horas Praticadas", "Nome Treinamento"};
            int linha = 0;
            String nomeAluno;
            try {
                String sql = "SELECT partidas_jogadas, data, melhor_tempo, horas_praticadas, treinamento_nome FROM estatistica WHERE aluno_rm = " + rm;
                PreparedStatement stm = (PreparedStatement) conexaoDB.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();
                while(rs.next()) {
                    dadosArray[linha][0] = rs.getString("partidas_jogadas");
                    dadosArray[linha][1] = rs.getString("data");
                    dadosArray[linha][2] = rs.getString("melhor_tempo");
                    dadosArray[linha][3] = rs.getString("horas_praticadas");
                    dadosArray[linha][4] = rs.getString("treinamento_nome");
                    linha++;
                }
                
                sql = "SELECT nome FROM aluno WHERE rm = " + rm;
                
                stm.close();
                rs.close();
                
                stm = (PreparedStatement) conexaoDB.prepareStatement(sql);
                rs = stm.executeQuery();
                rs.next();
                nomeAluno = rs.getString("nome");
                new view.Tabela_GUI().setVisible(true);
                DefaultTableModel modelo = new DefaultTableModel(dadosArray, colunasArray);
                view.Tabela_GUI.estatistica_tbl.setModel(modelo);
                view.Tabela_GUI.nomeAluno_txt.setText(nomeAluno);
            }
            catch(Exception e) {
                JOptionPane.showMessageDialog(null, "Erro na busca");
                e.printStackTrace();
            }
        }
    }
    
    
    public static boolean alunoTemEstatistica() {
        conexaoDB = controller.TesteConexao_DB.testarConexao();
        if(conexaoDB == null) { return false; }
        
        String temp = JOptionPane.showInputDialog(null, "Digite o RM do aluno desejado:");
        int rmAluno = 0;
        if(!FuncoesGerais_DAO.conferirNumero(rmAluno, temp)) { return false; }
        rmAluno = Integer.parseInt(temp);
        try {
            String sql = "SELECT COUNT(*) FROM estatistica WHERE aluno_rm = " + rmAluno;
            PreparedStatement stm = (PreparedStatement) conexaoDB.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            if(rs.next()) {
                rm = rmAluno;
                tamanhoArray = rs.getInt(1);
                return true;
            }
            else {
                JOptionPane.showMessageDialog(null, "Aluno selecionado não realizou nenhum treinamento");
                return false;
            }
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na consulta");
            return false;
        }
        
    }
}
