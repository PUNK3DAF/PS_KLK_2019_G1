/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.Controller;

/**
 *
 * @author vldmrk
 */
public class Zadatak2Forma extends javax.swing.JFrame {

    private Controller controller = Controller.getInstance();

    /**
     * Creates new form GlavnaForma
     */
    public Zadatak2Forma() {
        initComponents();
        popuniTabelu();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProfesori = new javax.swing.JTable();
        jButtonIzmeni = new javax.swing.JButton();
        jButtonOdustani = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTableProfesori.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableProfesori);

        jButtonIzmeni.setText("IZMENI");
        jButtonIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIzmeniActionPerformed(evt);
            }
        });

        jButtonOdustani.setText("ODUSTANI");
        jButtonOdustani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOdustaniActionPerformed(evt);
            }
        });
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonOdustani, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonIzmeni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jButtonIzmeni)
                        .addGap(48, 48, 48)
                        .addComponent(jButtonOdustani)))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOdustaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOdustaniActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonOdustaniActionPerformed

    private void jButtonIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIzmeniActionPerformed

    }//GEN-LAST:event_jButtonIzmeniActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonIzmeni;
    private javax.swing.JButton jButtonOdustani;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProfesori;
    // End of variables declaration//GEN-END:variables

    private void popuniTabelu() {
        ModelTabeleProfesori mtp = new ModelTabeleProfesori(controller.ucitajListu());
        jTableProfesori.setModel(mtp);
    }
}
