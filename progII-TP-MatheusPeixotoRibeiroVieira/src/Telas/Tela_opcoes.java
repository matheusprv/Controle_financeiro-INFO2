/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import Objetos.Usuario;

/**
 *
 * @author Matheus
 */
public class Tela_opcoes extends javax.swing.JFrame {
    Usuario u;
    /**
     * Creates new form Tela_opcoes
     */
    public Tela_opcoes(Usuario usuario) {
        initComponents();
        u= usuario;
    }

    private Tela_opcoes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bAbrirObjetivos = new javax.swing.JButton();
        bAbrirMovimentacoes = new javax.swing.JButton();
        bVoltar = new javax.swing.JButton();
        tNomeUsuario = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lSaldo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Opções");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        bAbrirObjetivos.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        bAbrirObjetivos.setText("Objetivos");
        bAbrirObjetivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAbrirObjetivosActionPerformed(evt);
            }
        });

        bAbrirMovimentacoes.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        bAbrirMovimentacoes.setText("Movimentacoes");
        bAbrirMovimentacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAbrirMovimentacoesActionPerformed(evt);
            }
        });

        bVoltar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        bVoltar.setText("Voltar");
        bVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVoltarActionPerformed(evt);
            }
        });

        tNomeUsuario.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tNomeUsuario.setText("Olá! Nome_do_usuário");

        jButton1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton1.setText("Perfil do Usuário");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lSaldo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lSaldo.setText("Seu saldo R$: xxxx,xx");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(bAbrirObjetivos, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bAbrirMovimentacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bVoltar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lSaldo)
                    .addComponent(tNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bVoltar)
                    .addComponent(tNomeUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lSaldo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(bAbrirMovimentacoes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bAbrirObjetivos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bAbrirMovimentacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAbrirMovimentacoesActionPerformed
        Tela_Movimentacoes abrir = new Tela_Movimentacoes(u);
        abrir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bAbrirMovimentacoesActionPerformed

    private void bAbrirObjetivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAbrirObjetivosActionPerformed
        Tela_Objetivos abrir = new Tela_Objetivos(u);
        abrir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bAbrirObjetivosActionPerformed

    private void bVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVoltarActionPerformed
        Tela_Inicial_Login abrir = new Tela_Inicial_Login();
        abrir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bVoltarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        tNomeUsuario.setText("Olá! "+u.getNome()+" "+u.getSobrenome());
        lSaldo.setText("Seu saldo: R$ "+u.getSaldo());
    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Tela_CadastroModificar_Usuario abrir = new Tela_CadastroModificar_Usuario(false, u);
        abrir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Tela_opcoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_opcoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_opcoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_opcoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_opcoes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAbrirMovimentacoes;
    private javax.swing.JButton bAbrirObjetivos;
    private javax.swing.JButton bVoltar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lSaldo;
    private javax.swing.JLabel tNomeUsuario;
    // End of variables declaration//GEN-END:variables
}
