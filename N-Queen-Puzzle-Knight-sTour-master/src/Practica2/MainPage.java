/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica2;

import Practica2.Knights.Knight;
import Practica2.Knights.Knight3;
import Practica2.Knights.Knight2;
import Practica2.Knights.Knight1;
import java.awt.*;
import javax.swing.*;

public class MainPage extends javax.swing.JFrame {
   
    private static String msg1 = "No se puede encontrar solución, por favor prueba otra vez "
            + "\nNo existe solución para n = 1,2,3,4"
            + "\nSi introduces una n muy grande, el cálculo tarda mucho. \n"
            + "Por consiguiente el programa puede decir que no hay solución, \n"
            + "en este caso prueba otra vez con la misma n\n";
            //+ "\nif chess board doesn't appear when you click the button that means you should try next time";
    private static String msg2 = "El programa funciona solo para números naturales, \n"
            + "para n mayor que 14 tardará bastante\n"
            + "No hay solución para n= 1,2 o 3";
    
    private static String msg3 = "No hay solución para la casilla seleccionada"
            + "\nPrueba otra casilla";
    
    public MainPage() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        this.setLocation(new Point(screenWidth/2-120, screenHeight/2-90));
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TextDimension = new javax.swing.JTextField();
        radBtn1 = new javax.swing.JRadioButton();
        radBtn2 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cellCombo = new javax.swing.JComboBox<>();
        jText_posx = new javax.swing.JTextField();
        jText_posy = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Tamaño tablero nxn: ");

        TextDimension.setText("8");
        TextDimension.setToolTipText("");
        TextDimension.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                TextDimensionInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        TextDimension.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextDimensionActionPerformed(evt);
            }
        });

        radBtn1.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        radBtn1.setSelected(true);
        radBtn1.setText("Movimientos Caballo");
        radBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radBtn1ActionPerformed(evt);
            }
        });

        radBtn2.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        radBtn2.setText("N Reinas");
        radBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radBtn2ActionPerformed(evt);
            }
        });

        jButton1.setText("Empezar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Selecciona un modo:");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/info.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel3MousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel4.setText("Tamaño casilla:");

        cellCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "20", "25", "30", "35", "40", "45", "50", "55", "60", "65", "70", "75", "80" }));

        jText_posx.setText("1");
        jText_posx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jText_posxActionPerformed(evt);
            }
        });

        jText_posy.setText("1");

        jLabel5.setText("FILA");

        jLabel6.setText("COLUMNA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jText_posx, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jText_posy, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(radBtn2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(TextDimension, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cellCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(radBtn1))
                                .addGap(38, 38, 38))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(50, 50, 50))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TextDimension, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(radBtn1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radBtn2)
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cellCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jText_posx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jText_posy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TextDimensionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextDimensionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextDimensionActionPerformed

    private void radBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radBtn1ActionPerformed
        radBtn1.setSelected(true);
        radBtn2.setSelected(false);
    }//GEN-LAST:event_radBtn1ActionPerformed

    private void radBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radBtn2ActionPerformed
        radBtn2.setSelected(true);
        radBtn1.setSelected(false);
    }//GEN-LAST:event_radBtn2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String[] arr = new String[4];
        
        arr[0] = TextDimension.getText();
        arr[1] = cellCombo.getSelectedItem().toString();
        arr[2] = jText_posx.getText();
        arr[3] = jText_posy.getText();
        //arr[2] = (marginSet.isSelected()) ? "1" : "0";
        //JOptionPane.showMessageDialog(this, "cellSize = " + arr[1]);
        try{
        int dim = Integer.parseInt(arr[0]);
        
        if(radBtn2.isSelected()){
            if(dim > 14 || dim < 1){
                JOptionPane.showMessageDialog(this, msg2);
            }
            else {
                
                int contador = Queen.main(arr);
                if (dim < 4 && dim >1){
                    Queen.frame.setVisible(false);
                    JOptionPane.showMessageDialog(this, msg2);
                }else if (contador != dim){
                    Queen.frame.setVisible(false);
                    JOptionPane.showMessageDialog(this, msg3);
                }else{
                    Queen.frame.setVisible(true);
                }
            }
            
        }else{
            if(dim == 1 || dim == 2 || dim == 3 || dim == 4){
                JOptionPane.showMessageDialog(this, msg1);
            }else{
                Knight.main(arr);
                 Knight1.main(arr);
                 Knight2.main(arr);
                 Knight3.main(arr);

                
            }
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Por favor, introduce un número natural:");
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        if(radBtn2.isSelected())
            JOptionPane.showMessageDialog(this, msg2);
        else
            JOptionPane.showMessageDialog(this, msg1);

    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed
        if(radBtn2.isSelected())
            JOptionPane.showMessageDialog(this, msg2);
        else
            JOptionPane.showMessageDialog(this, msg1);

    }//GEN-LAST:event_jLabel3MousePressed

    private void TextDimensionInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_TextDimensionInputMethodTextChanged
        
    }//GEN-LAST:event_TextDimensionInputMethodTextChanged

    private void jText_posxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jText_posxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jText_posxActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TextDimension;
    private javax.swing.JComboBox<String> cellCombo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jText_posx;
    private javax.swing.JTextField jText_posy;
    private javax.swing.JRadioButton radBtn1;
    private javax.swing.JRadioButton radBtn2;
    // End of variables declaration//GEN-END:variables
}
