/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import DAO.DAOKhoa;
import DataBase.JDBCConnector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Khoa;

/**
 *
 * @author Admin
 */
public class KhoaJFrame extends javax.swing.JFrame {

    /**
     * Creates new form Khỏaame
     */
    
    
    public KhoaJFrame() {
        initComponents();
        loadData();
        
    }
    public ArrayList<Khoa> dsKhoa(){
        ArrayList<Khoa> dsKhoa = new ArrayList<>();
        Connection con = JDBCConnector.getConnection();
        Statement st;
        ResultSet rs;
        String sql = "SELECT * FROM khoa";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                Khoa k = new Khoa(rs.getInt("khoaid"),rs.getNString("khoaname"));
                dsKhoa.add(k);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsKhoa;
    }
    public void loadData(){
        ArrayList<Khoa> list = dsKhoa();
        DefaultTableModel dtl = (DefaultTableModel) jTable1.getModel();
        for (Khoa khoa : list) {
            Vector v = new Vector();
            v.add(khoa.getIdkhoa());
            v.add(khoa.getTenkhoa());
            dtl.addRow(v);
        }
    }
    public void thucthi(String sql,String message){
        Connection con = JDBCConnector.getConnection();
        Statement st;
        try {
            st = con.createStatement();
            if(st.executeUpdate(sql) == 1){
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);
                        
                JOptionPane.showMessageDialog(rootPane, message + "Thành Công");
            }
            else{
                JOptionPane.showMessageDialog(rootPane,message+ "Thất Bại");
            }
        } catch (Exception e) {
            e.printStackTrace();
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
        xemdanhsach = new javax.swing.JButton();
        updateKhoabtn = new javax.swing.JButton();
        AddKhoabtn = new javax.swing.JButton();
        DeleteKhoabtn = new javax.swing.JButton();
        returnbtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        idkhoatxt = new javax.swing.JTextField();
        khoanametxt = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Danh Sách Khoa");

        xemdanhsach.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        xemdanhsach.setText("Xem Danh Sách Lớp Thuộc Khoa");
        xemdanhsach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xemdanhsachActionPerformed(evt);
            }
        });

        updateKhoabtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        updateKhoabtn.setText("Sửa Thông Tin Khoa");
        updateKhoabtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateKhoabtnActionPerformed(evt);
            }
        });

        AddKhoabtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        AddKhoabtn.setText("Thêm Khoa");
        AddKhoabtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddKhoabtnActionPerformed(evt);
            }
        });

        DeleteKhoabtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        DeleteKhoabtn.setText("Xóa Khoa");
        DeleteKhoabtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteKhoabtnActionPerformed(evt);
            }
        });

        returnbtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        returnbtn.setText("Quay Lại");
        returnbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnbtnActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Thông Tin Chi Tiết");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Mã Khoa");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Tên Khoa");

        idkhoatxt.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        khoanametxt.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jScrollPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane2MouseClicked(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Khoa", "Tên Khoa"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 953, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(352, 352, 352)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(49, 49, 49)
                                .addComponent(idkhoatxt, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jLabel4)
                                .addGap(53, 53, 53)
                                .addComponent(khoanametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(xemdanhsach)
                        .addGap(55, 55, 55)
                        .addComponent(updateKhoabtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AddKhoabtn)
                        .addGap(59, 59, 59)
                        .addComponent(DeleteKhoabtn)
                        .addGap(49, 49, 49)
                        .addComponent(returnbtn)))
                .addGap(44, 44, 44))
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 847, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(idkhoatxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(khoanametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(xemdanhsach, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateKhoabtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddKhoabtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteKhoabtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(returnbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void xemdanhsachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xemdanhsachActionPerformed
        int chose = jTable1.getSelectedRow();
        Khoa k = dsKhoa().get(chose);
        idkhoatxt.setText(k.getIdkhoa()+"");
        khoanametxt.setText(k.getTenkhoa());
        this.dispose();
        LopJFrame jframe = new LopJFrame(idkhoatxt.getText());
        jframe.setVisible(true);
        
    }//GEN-LAST:event_xemdanhsachActionPerformed

    private void updateKhoabtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateKhoabtnActionPerformed
        String sql = "UPDATE khoa set khoaname = '"+khoanametxt.getText()+"' WHERE khoaid = '"+idkhoatxt.getText()+"'";
        thucthi(sql, "");
        loadData();
    }//GEN-LAST:event_updateKhoabtnActionPerformed

    private void AddKhoabtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddKhoabtnActionPerformed
        String sql = "INSERT INTO khoa(khoaid,khoaname) VALUES('"+idkhoatxt.getText()+"','"+khoanametxt.getText()+"')";
        thucthi(sql, "Thêm");
        loadData();
    }//GEN-LAST:event_AddKhoabtnActionPerformed

    private void DeleteKhoabtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteKhoabtnActionPerformed
        String sql = "DELETE FROM khoa WHERE khoaid = '"+idkhoatxt.getText()+"'";
        thucthi(sql, "Xóa");
        loadData();
    }//GEN-LAST:event_DeleteKhoabtnActionPerformed

    private void returnbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnbtnActionPerformed
        TrangChuFrame frame  = new TrangChuFrame();
        frame.setVisible(true);
    }//GEN-LAST:event_returnbtnActionPerformed

    private void jScrollPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane2MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int i = jTable1.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
       idkhoatxt.setText(model.getValueAt(i, 0).toString());
       khoanametxt.setText(model.getValueAt(i, 1).toString());
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(KhoaJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KhoaJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KhoaJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KhoaJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KhoaJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddKhoabtn;
    private javax.swing.JButton DeleteKhoabtn;
    private javax.swing.JTextField idkhoatxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField khoanametxt;
    private javax.swing.JButton returnbtn;
    private javax.swing.JButton updateKhoabtn;
    private javax.swing.JButton xemdanhsach;
    // End of variables declaration//GEN-END:variables
}
