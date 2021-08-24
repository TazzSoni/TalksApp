/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.DadosConexao;
import Control.ClientController;

import javax.swing.*;
import java.io.IOException;

/**
 *
 * @author Rodrigo
 */
public class ViewChat extends javax.swing.JFrame {

    private ClientController controller;

    /**
     * Creates new form ViewChat
     */
    public ViewChat(DadosConexao cliente) throws IOException {
        initComponents();
        this.setLocationRelativeTo(null);
        this.controller = new ClientController(cliente, this);
        this.controller.conectar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtaChat = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaMensagem = new javax.swing.JTextArea();
        jbSend = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtaChat.setColumns(20);
        jtaChat.setRows(5);
        jScrollPane1.setViewportView(jtaChat);

        jtaMensagem.setColumns(20);
        jtaMensagem.setRows(5);
        jScrollPane2.setViewportView(jtaMensagem);

        jbSend.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbSend.setText("Enviar");
        jbSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbSend, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jbSend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSendActionPerformed
        try {
            if (!this.jtaMensagem.getText().trim().equals("")) {
                this.jtaChat.setText(this.jtaChat.getText() + "\n" + "eu: " + this.jtaMensagem.getText());
                this.controller.enviaMensagem(this.jtaMensagem.getText());
            }
            this.jtaMensagem.setText("");
        } catch (IOException e) {
                e.printStackTrace();
        }
    }//GEN-LAST:event_jbSendActionPerformed


    public JTextArea getChat() {
        return this.jtaChat;
    }


    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbSend;
    private javax.swing.JTextArea jtaChat;
    private javax.swing.JTextArea jtaMensagem;
    // End of variables declaration//GEN-END:variables
}
