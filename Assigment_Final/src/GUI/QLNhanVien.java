/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import Bussiness.ServiceNhanVien;
import Bussiness.ServiceUser;
import Bussiness.User;
import Utilities.*;
import CRUD.*;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class QLNhanVien extends javax.swing.JDialog {
public static int role;
    DefaultTableModel model;
    int index=0;
 
    public QLNhanVien() throws NoSuchAlgorithmException, SQLException {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("EduSys-Quản Lý Người Học");
        model=(DefaultTableModel)tbl_nhanvien.getModel();
        
        
    if(Login.checkrole==1){
     
        for (User x: ServiceUser.list) {
            model.addRow(new Object[]{
            x.getUser(),SHA_1.getStringFromSHA256(x.getPass()),x.getHoten(),x.getRole(x.getRole())});
        }
          
          Bussiness.ServiceNhanVien.roleNhanVien(btn_them1, btn_sua1, btn_xoa1, btn_moi1);
     }else{
        loadTable();
    }
    rdo_nhanvien1.setSelected(true);
 
    
       
    }
    public void loadTable(){
        model=(DefaultTableModel)tbl_nhanvien.getModel();
        model.setRowCount(0);
        for (User x: ServiceUser.list) {
            model.addRow(new Object[]{
            x.getUser(),x.getPass(),x.getHoten(),x.getRole(x.getRole())});
        }
        
    }
public boolean checkKhoa(){
    for (User x : ServiceUser.list) {
        if(txt_ma1.getText().equals(x.getUser())){
            return false;
        }
      }
    return true;
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_nhanvien = new javax.swing.JTable();
        pl_capnhat = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txt_repass1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        rdo_truongphong1 = new javax.swing.JRadioButton();
        txt_hoten1 = new javax.swing.JTextField();
        rdo_nhanvien1 = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        txt_ma1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_pass1 = new javax.swing.JTextField();
        btn_sua1 = new javax.swing.JButton();
        btn_them1 = new javax.swing.JButton();
        btn_xoa1 = new javax.swing.JButton();
        btn_moi1 = new javax.swing.JButton();
        btn_pre = new javax.swing.JButton();
        btn_pree = new javax.swing.JButton();
        btn_next = new javax.swing.JButton();
        btn_nex2 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("QUẢN LÝ NHÂN VIÊN QUẢN TRỊ");

        tbl_nhanvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã NV", "Mật khẩu", "Họ và Tên", "Vai Trò"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_nhanvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_nhanvienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_nhanvien);
        if (tbl_nhanvien.getColumnModel().getColumnCount() > 0) {
            tbl_nhanvien.getColumnModel().getColumn(0).setResizable(false);
            tbl_nhanvien.getColumnModel().getColumn(1).setResizable(false);
            tbl_nhanvien.getColumnModel().getColumn(2).setResizable(false);
            tbl_nhanvien.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Danh sách", jPanel3);

        jLabel7.setText("Xác nhận mật khẩu");

        jLabel8.setText("Vai trò");

        jLabel9.setText("Họ và Tên");

        buttonGroup1.add(rdo_truongphong1);
        rdo_truongphong1.setText("Trưởng phòng");

        buttonGroup1.add(rdo_nhanvien1);
        rdo_nhanvien1.setText("Nhân viên");

        jLabel10.setText("Mã nhân viên");

        jLabel11.setText("Mật khẩu");

        btn_sua1.setText("Sửa");
        btn_sua1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sua1ActionPerformed(evt);
            }
        });

        btn_them1.setText("Thêm");
        btn_them1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_them1ActionPerformed(evt);
            }
        });

        btn_xoa1.setText("Xóa");
        btn_xoa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoa1ActionPerformed(evt);
            }
        });

        btn_moi1.setText("Mới");
        btn_moi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_moi1ActionPerformed(evt);
            }
        });

        btn_pre.setText("|<");
        btn_pre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_preActionPerformed(evt);
            }
        });

        btn_pree.setText("<<");
        btn_pree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_preeActionPerformed(evt);
            }
        });

        btn_next.setText(">>");
        btn_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextActionPerformed(evt);
            }
        });

        btn_nex2.setText(">|");
        btn_nex2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nex2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pl_capnhatLayout = new javax.swing.GroupLayout(pl_capnhat);
        pl_capnhat.setLayout(pl_capnhatLayout);
        pl_capnhatLayout.setHorizontalGroup(
            pl_capnhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_pass1)
            .addComponent(txt_repass1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_capnhatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_ma1)
                .addContainerGap())
            .addComponent(txt_hoten1)
            .addGroup(pl_capnhatLayout.createSequentialGroup()
                .addGroup(pl_capnhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addGroup(pl_capnhatLayout.createSequentialGroup()
                        .addGroup(pl_capnhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pl_capnhatLayout.createSequentialGroup()
                                .addComponent(btn_them1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_sua1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_xoa1))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pl_capnhatLayout.createSequentialGroup()
                                .addComponent(rdo_truongphong1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdo_nhanvien1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_moi1)
                        .addGap(75, 75, 75)
                        .addComponent(btn_pre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_pree)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_next)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_nex2))
                    .addGroup(pl_capnhatLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(pl_capnhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))))
                .addGap(0, 75, Short.MAX_VALUE))
        );
        pl_capnhatLayout.setVerticalGroup(
            pl_capnhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl_capnhatLayout.createSequentialGroup()
                .addComponent(jLabel10)
                .addGap(4, 4, 4)
                .addComponent(txt_ma1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_pass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_repass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_hoten1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pl_capnhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdo_truongphong1)
                    .addComponent(rdo_nhanvien1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pl_capnhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_them1)
                    .addComponent(btn_sua1)
                    .addComponent(btn_xoa1)
                    .addComponent(btn_moi1)
                    .addComponent(btn_pre)
                    .addComponent(btn_pree)
                    .addComponent(btn_next)
                    .addComponent(btn_nex2))
                .addContainerGap(112, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cập nhật", pl_capnhat);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jTabbedPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void them(){
 if(CheckNull.CheckNull(txt_ma1.getText(),txt_hoten1.getText(), txt_pass1.getText(), txt_repass1.getText())==false){
     JOptionPane.showMessageDialog(this,"Chưa điền đủ thông tin");
     return;
 }
 if(txt_ma1.getText().length()>10){
     JOptionPane.showMessageDialog(this,"Mã nhân viên không được quá 10 ký tự");
     return;
 }
 if(!txt_pass1.getText().equals(txt_repass1.getText())){
     JOptionPane.showMessageDialog(this, "Mật khẩu vừa nhập không khớp");
     return;
 }
   if(checkKhoa()==false){
       JOptionPane.showMessageDialog(this, "Mã nhân viên bị trùng");
       return;
   }
    try {
        
        role=getRole.getRole(rdo_truongphong1, rdo_nhanvien1);
        if(CRUD_NhanVien.add(txt_ma1.getText(), txt_pass1.getText(), txt_hoten1.getText())>0){
            JOptionPane.showMessageDialog(this, "Thêm thành công");        
           ServiceUser.addUser();
     loadTable();
        }
    } catch (SQLException ex) {
        Logger.getLogger(QLNhanVien.class.getName()).log(Level.SEVERE, null, ex);
    }
}

public void mouseClick(){
  
}
    private void btn_them1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_them1ActionPerformed
     
    them();

    }//GEN-LAST:event_btn_them1ActionPerformed

    private void btn_sua1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sua1ActionPerformed
     if(CheckNull.CheckNull(txt_ma1.getText(),txt_hoten1.getText(), txt_pass1.getText(), txt_repass1.getText())==false){
     JOptionPane.showMessageDialog(this,"Chưa điền đủ thông tin");
     return;
 }
        if(!txt_pass1.getText().equals(txt_repass1.getText())){
     JOptionPane.showMessageDialog(this, "Mật khẩu vừa nhập không khớp");
     return;
     
        }
        try {
            if( CRUD_NhanVien.Update(txt_pass1.getText(), txt_ma1.getText())>0){
                JOptionPane.showMessageDialog(this, "Sửa thành công");
                ServiceUser.addUser();
                loadTable();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_sua1ActionPerformed
public void next(){
     
    
     
     txt_ma1.setText(tbl_nhanvien.getValueAt(index, 0).toString());
     txt_pass1.setText(tbl_nhanvien.getValueAt(index, 1).toString());
     txt_hoten1.setText(tbl_nhanvien.getValueAt(index, 2).toString());
     txt_repass1.setText(tbl_nhanvien.getValueAt(index, 1).toString());
     if(tbl_nhanvien.getValueAt(index, 3).equals("Nhanvien")){
         rdo_nhanvien1.setSelected(true);
     }else{
         rdo_truongphong1.setSelected(true);
     }
}
    private void tbl_nhanvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_nhanvienMouseClicked
     index=tbl_nhanvien.getSelectedRow();
     
     txt_ma1.setText(tbl_nhanvien.getValueAt(index, 0).toString());
     txt_pass1.setText(tbl_nhanvien.getValueAt(index, 1).toString());
     txt_hoten1.setText(tbl_nhanvien.getValueAt(index, 2).toString());
     txt_repass1.setText(tbl_nhanvien.getValueAt(index, 1).toString());
     if(tbl_nhanvien.getValueAt(index, 3).equals("Nhanvien")){
         rdo_nhanvien1.setSelected(true);
     }else{
         rdo_truongphong1.setSelected(true);
     }
     
    }//GEN-LAST:event_tbl_nhanvienMouseClicked

    private void btn_preActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_preActionPerformed
index=0;
next();// TODO add your handling code here:
    }//GEN-LAST:event_btn_preActionPerformed

    private void btn_preeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_preeActionPerformed
index--;
if(index<0){
    index=0;
}
next();// TODO add your handling code here:
    }//GEN-LAST:event_btn_preeActionPerformed

    private void btn_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextActionPerformed
index++;
if(index>ServiceUser.list.size()-1){
    index=ServiceUser.list.size()-1;
}
next();// TODO add your handling code here:
    }//GEN-LAST:event_btn_nextActionPerformed

    private void btn_nex2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nex2ActionPerformed
index=ServiceUser.list.size()-1;
next();// TODO add your handling code here:
    }//GEN-LAST:event_btn_nex2ActionPerformed
public void moi(){
    txt_hoten1.setText(null);
    txt_ma1.setText(null);
    txt_pass1.setText(null);
    txt_repass1.setText(null);
}
    private void btn_moi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_moi1ActionPerformed
moi();
    }//GEN-LAST:event_btn_moi1ActionPerformed

    private void btn_xoa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoa1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_xoa1ActionPerformed
    public static void main(String[] args) throws NoSuchAlgorithmException, SQLException {
        new  QLNhanVien().setVisible(true);
    }
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_moi1;
    private javax.swing.JButton btn_nex2;
    private javax.swing.JButton btn_next;
    private javax.swing.JButton btn_pre;
    private javax.swing.JButton btn_pree;
    private javax.swing.JButton btn_sua1;
    private javax.swing.JButton btn_them1;
    private javax.swing.JButton btn_xoa1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel pl_capnhat;
    private javax.swing.JRadioButton rdo_nhanvien1;
    private javax.swing.JRadioButton rdo_truongphong1;
    private javax.swing.JTable tbl_nhanvien;
    private javax.swing.JTextField txt_hoten1;
    private javax.swing.JTextField txt_ma1;
    private javax.swing.JTextField txt_pass1;
    private javax.swing.JTextField txt_repass1;
    // End of variables declaration//GEN-END:variables
}
