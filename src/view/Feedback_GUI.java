/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Gabriel
 */
public class Feedback_GUI extends javax.swing.JFrame {

    /**
     * Creates new form Feedback_GUI
     */
    public Feedback_GUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        sair_btn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        rmAluno_txt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        comentario_txt = new javax.swing.JTextField();
        aprovado_cBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pfTutor_txt = new javax.swing.JTextField();
        cadastrar_btn = new javax.swing.JButton();
        consultar_btn = new javax.swing.JButton();
        alterar_btn = new javax.swing.JButton();
        excluir_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("FEEDBACK");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(300, 30, 390, 30);

        sair_btn.setBackground(new java.awt.Color(255, 255, 255));
        sair_btn.setText("x");
        sair_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sair_btnActionPerformed(evt);
            }
        });
        jPanel1.add(sair_btn);
        sair_btn.setBounds(700, 10, 90, 60);

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setText("PF TUTOR:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(180, 330, 100, 30);
        jPanel1.add(rmAluno_txt);
        rmAluno_txt.setBounds(290, 100, 290, 50);

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("RM ALUNO:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(100, 110, 180, 30);
        jPanel1.add(comentario_txt);
        comentario_txt.setBounds(290, 240, 290, 50);

        aprovado_cBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Aprovado", "Reprovado" }));
        aprovado_cBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aprovado_cBoxActionPerformed(evt);
            }
        });
        jPanel1.add(aprovado_cBox);
        aprovado_cBox.setBounds(290, 180, 120, 30);

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel4.setText("APROVADO:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(180, 180, 110, 30);

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel5.setText("COMENTÁRIO:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(150, 250, 130, 30);
        jPanel1.add(pfTutor_txt);
        pfTutor_txt.setBounds(290, 320, 290, 50);

        cadastrar_btn.setBackground(new java.awt.Color(255, 255, 255));
        cadastrar_btn.setText("CADASTRAR");
        cadastrar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrar_btnActionPerformed(evt);
            }
        });
        jPanel1.add(cadastrar_btn);
        cadastrar_btn.setBounds(90, 400, 140, 70);

        consultar_btn.setBackground(new java.awt.Color(255, 255, 255));
        consultar_btn.setText("CONSULTAR");
        consultar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultar_btnActionPerformed(evt);
            }
        });
        jPanel1.add(consultar_btn);
        consultar_btn.setBounds(270, 400, 140, 70);

        alterar_btn.setBackground(new java.awt.Color(255, 255, 255));
        alterar_btn.setText("ALTERAR");
        alterar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterar_btnActionPerformed(evt);
            }
        });
        jPanel1.add(alterar_btn);
        alterar_btn.setBounds(450, 400, 140, 70);

        excluir_btn.setBackground(new java.awt.Color(255, 255, 255));
        excluir_btn.setText("EXCLUIR");
        excluir_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluir_btnActionPerformed(evt);
            }
        });
        jPanel1.add(excluir_btn);
        excluir_btn.setBounds(620, 400, 140, 70);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(800, 500));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void aprovado_cBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aprovado_cBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aprovado_cBoxActionPerformed

    private void cadastrar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrar_btnActionPerformed
        model.CRUD_DAO.cadastrarFeedback();
    }//GEN-LAST:event_cadastrar_btnActionPerformed

    private void sair_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sair_btnActionPerformed
        dispose();
    }//GEN-LAST:event_sair_btnActionPerformed

    private void consultar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultar_btnActionPerformed
        model.CRUD_DAO.consultarFeedback();
    }//GEN-LAST:event_consultar_btnActionPerformed

    private void alterar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterar_btnActionPerformed
        model.CRUD_DAO.alterarFeedback();
    }//GEN-LAST:event_alterar_btnActionPerformed

    private void excluir_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluir_btnActionPerformed
        model.CRUD_DAO.excluirFeedback();
    }//GEN-LAST:event_excluir_btnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Feedback_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Feedback_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Feedback_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Feedback_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Feedback_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alterar_btn;
    public static javax.swing.JComboBox aprovado_cBox;
    private javax.swing.JButton cadastrar_btn;
    public static javax.swing.JTextField comentario_txt;
    private javax.swing.JButton consultar_btn;
    private javax.swing.JButton excluir_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JTextField pfTutor_txt;
    public static javax.swing.JTextField rmAluno_txt;
    private javax.swing.JButton sair_btn;
    // End of variables declaration//GEN-END:variables
}
