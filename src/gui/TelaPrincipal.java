/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import bean.Mensagem;
import dao.MensagemDAO;
import dao.UsuarioDAO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 13151000162
 */
public class TelaPrincipal extends javax.swing.JFrame {
    private int codUsuario;
    private ArrayList<Mensagem> mensagensRec;
    private ArrayList<Mensagem> mensagensEnv;
    /**
     * Creates new form TelaAcoes
     */
    public TelaPrincipal(int codUsuario) {
        initComponents();
        this.codUsuario = codUsuario; 
        this.lista();
    }

    private TelaPrincipal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void lista(){
        this.mensagensRec = new ArrayList();
        MensagemDAO mensagemDAO =  new MensagemDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        this.mensagensRec = mensagemDAO.consultar(this.codUsuario);
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        DefaultTableModel modelo2 = (DefaultTableModel) jTable2.getModel();
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 4; j++){
                try{
                   modelo.setValueAt(null, i, j); 
                }
                catch(ArrayIndexOutOfBoundsException e){
                    System.out.println(e);
                }
            }
            for(int j = 0; j < 3; j++){
                try{
                   modelo2.setValueAt(null, i, j);
                }
                catch(ArrayIndexOutOfBoundsException e){
                    System.out.println(e);
                }
            }
        }
        
        modelo.setNumRows(0);
        for (Mensagem mensagem : this.mensagensRec) {
            Vector linha = new Vector();
            String dataString;
            linha.add(mensagem.getRemetente().getNome());
            dataString = mensagem.getData().get(Calendar.DAY_OF_MONTH) + "/" +
                    (mensagem.getData().get(Calendar.MONTH)+1) + "/" +
                    mensagem.getData().get(Calendar.YEAR) + " " + 
                    mensagem.getData().get(Calendar.HOUR) + ":" +
                    mensagem.getData().get(Calendar.MINUTE) + ":" +
                    mensagem.getData().get(Calendar.SECOND);
            linha.add(dataString);
            linha.add(mensagem.getConteudo());
            linha.add(mensagem.getStatus() ? "Lida" : "Não lida");
            modelo.addRow(linha);
        }
        
        this.mensagensEnv = new ArrayList();
        this.mensagensEnv = mensagemDAO.consultarPropriasMsgs(this.codUsuario);
        modelo2.setNumRows(0);
        for (Mensagem mensagem : this.mensagensEnv) {
            Vector linha = new Vector();
            String dataString;
            linha.add(mensagem.getDestinario().getNome());
            dataString = mensagem.getData().get(Calendar.DAY_OF_MONTH) + "/" +
                    (mensagem.getData().get(Calendar.MONTH)+1) + "/" +
                    mensagem.getData().get(Calendar.YEAR) + " " + 
                    mensagem.getData().get(Calendar.HOUR) + ":" +
                    mensagem.getData().get(Calendar.MINUTE) + ":" +
                    mensagem.getData().get(Calendar.SECOND);
            linha.add(dataString);
            linha.add(mensagem.getConteudo());
            linha.add(mensagem.getStatus() ? "Lida" : "Não lida");
            modelo2.addRow(linha);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonAtt = new javax.swing.JButton();
        buttonMsg = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Caixa de Entrada");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Remetente", "Data", "Mensagem", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(40);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(15);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(20);
        }

        buttonAtt.setText("Atualizar");
        buttonAtt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAttActionPerformed(evt);
            }
        });

        buttonMsg.setText("Escrever Mensagem");
        buttonMsg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMsgActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Destinatário", "Data", "Mensagem"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jLabel2.setText("Recebidas");

        jLabel3.setText("Enviadas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 63, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 977, Short.MAX_VALUE)
                        .addComponent(jScrollPane2))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(281, Short.MAX_VALUE)
                .addComponent(buttonMsg)
                .addGap(96, 96, 96)
                .addComponent(buttonAtt)
                .addGap(459, 459, 459))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAtt)
                    .addComponent(buttonMsg))
                .addContainerGap(176, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonMsgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMsgActionPerformed
        // TODO add your handling code here:
        TelaEnviarMensagem p = new TelaEnviarMensagem(codUsuario);
        p.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonMsgActionPerformed

    private void buttonAttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAttActionPerformed
        // TODO add your handling code here:
        lista();
    }//GEN-LAST:event_buttonAttActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        Vector linha = new Vector();
        MensagemDAO mensagemDAO = new MensagemDAO();
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        int linhaSelec = jTable1.getSelectedRow();
        linha = (Vector) modelo.getDataVector().elementAt(linhaSelec);
        String dest = linha.get(0).toString();
        String txt = linha.get(2).toString();
        if(linha.get(3).toString().equals("Não lida"))  
            mensagemDAO.alterarStatusMensagem(mensagensRec.get(linhaSelec).getCode());
        TelaExibeMensagem p = new TelaExibeMensagem(this.codUsuario, txt, "por " + dest);
        p.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        Vector linha = new Vector();
        DefaultTableModel modelo = (DefaultTableModel) jTable2.getModel();
        int linhaSelec = jTable2.getSelectedRow();
        linha = (Vector) modelo.getDataVector().elementAt(linhaSelec);
        String dest = linha.get(0).toString();
        String txt = linha.get(2).toString();
        TelaExibeMensagem p = new TelaExibeMensagem(this.codUsuario, txt, "para " + dest);
        p.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jTable2MouseClicked

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAtt;
    private javax.swing.JButton buttonMsg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
