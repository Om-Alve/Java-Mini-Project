/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author omalv
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
public class ViewEntry extends javax.swing.JFrame {

    /**
     * Creates new form ViewEntry
     */
    private int uid;
    public ViewEntry(int uid,String date, String entryText) {
        initComponents();
        jTextArea1.setText(entryText);
        this.uid = uid;

        setTitle(date);
        jLabel1.setText("Date: " + date);

        String entryDate = date;

        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (updateEntry(date, jTextArea1.getText())) {
                    JOptionPane.showMessageDialog(ViewEntry.this, "Update Successful", "Success", JOptionPane.INFORMATION_MESSAGE);
                    home homeFrame = new home(uid);
                    homeFrame.initializeAndShow();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(ViewEntry.this, "Update Failed", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (deleteEntry(date)) {
                    JOptionPane.showMessageDialog(ViewEntry.this, "Delete Successful", "Success", JOptionPane.INFORMATION_MESSAGE);
                    home homeFrame = new home(uid);
                    homeFrame.initializeAndShow();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(ViewEntry.this, "Delete Failed", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        jTextArea1.setText(entryText);
        // Set the title of the frame as the date or any other information you want to display.
        setTitle(date);
    }
    private boolean deleteEntry(String date) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fx_ediary", "root", "1234");
            String query = "DELETE FROM entries WHERE entry_date = ?";
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, date);

            int deletedRows = stmt.executeUpdate();

            stmt.close();
            conn.close();

            return deletedRows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
        
    private boolean updateEntry(String date, String newText) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fx_ediary", "root", "1234");
            String query = "UPDATE entries SET entry_text = ? WHERE entry_date = ?";
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, newText);
            stmt.setString(2, date);

            int updatedRows = stmt.executeUpdate();

            stmt.close();
            conn.close();

            return updatedRows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 150, 940, 430));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 240, 50));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 650, -1, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 650, -1, -1));

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton3.setText("Cancel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 650, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/space.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        home homeFrame = new home(uid);
        homeFrame.initializeAndShow();dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
