/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Bussiness.ChuyenDe;
import Bussiness.ServiceChuyenDe;
import Bussiness.ServiceKhoaHoc;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import Utilities.*;
import java.time.LocalDate;
import java.util.LinkedList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class QLKHoaHoc extends javax.swing.JDialog {

    DefaultTableModel model;
    int index;
    String makh;

    /**
     * Creates new form QLKHoaHoc
     */
   
    public QLKHoaHoc() throws SQLException {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("EduSys- Quản Lý Khóa Học");
        txt_nguoitao.setText(Login.user);
        ServiceChuyenDe.addtoList();
        ServiceKhoaHoc.addToList();
        loadToCB();
        model = (DefaultTableModel) tbl_chuyende.getModel();
        txt_chuyende.setEnabled(false);      
        txt_ngaytao.setEnabled(false);
        txt_nguoitao.setEnabled(false);
        txt_ngaytao.setText(LocalDate.now().toString());
        btn_them.addActionListener((ae) -> {
            try {
                add();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        });
        txt_nguoitao.setText(Login.user);

    }

    public String getMaCD() throws SQLException {
        String query = "select chuyende.macd from chuyende \n"
                + "where TENCD = ?";
        PreparedStatement pre = ConnectSQLServer.Connect.con.prepareStatement(query);
        pre.setString(1, txt_chuyende.getText());
        ResultSet rs = pre.executeQuery();
        while (rs.next()) {
            return rs.getString("macd");
        }
        return null;
    }

    public void loadToCB() {
         
        for (ChuyenDe x : ServiceChuyenDe.list) {
            cbb_chuyende.addItem(x.getTencd());

        }
    }

    public void add() throws SQLException {
        if (CheckNull.CheckNull(txt_Khaigiang.getText(), txt_chuyende.getText(), txt_hocphi.getText(), txt_ngaytao.getText(), txt_nguoitao.getText(), txt_thoiluong.getText(), txt_ghichu.getText()) == false) {
            JOptionPane.showMessageDialog(this, "Bạn chưa điền đủ thông tin");
            return;
        }
        if (Regex.iSNaN(txt_hocphi.getText()) == false) {
            JOptionPane.showMessageDialog(this, "Học phí phải là số");
            return;
        }
        if (Regex.iSNaN(txt_thoiluong.getText()) == false) {
            JOptionPane.showMessageDialog(this, "Thời lượng phải là số");
            return;
        }
        txt_ngaytao.setText(LocalDate.now().toString());
        if (CRUD.CRUD_KhoaHoc.insertToDB(getMaCD(), Double.parseDouble(txt_hocphi.getText()), Integer.valueOf(txt_thoiluong.getText()), txt_Khaigiang.getText(), txt_ghichu.getText(), Login.user, txt_ngaytao.getText()) > 0) {

            ServiceKhoaHoc.addToList();
            JOptionPane.showMessageDialog(this, "Thêm thành công");

            loadTable();

        }

    }

    public void loadTable() {
        String query = "select makh,khoahoc.thoiluong,khoahoc.hocphi,khoahoc.NGAYKG,manv,ngaytao\n"
                + "from KHOAHOC  join CHUYENDE on KHOAHOC.MACD=CHUYENDE.MACD\n"
                + "where  CHUYENDE.macd  = ?";
        model = (DefaultTableModel) tbl_chuyende.getModel();
        model.setRowCount(0);
        txt_chuyende.setText(cbb_chuyende.getSelectedItem().toString());
        try {
            PreparedStatement pre = ConnectSQLServer.Connect.con.prepareStatement(query);
            pre.setString(1, getMaCD());
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString(1), rs.getInt(2), rs.getDouble(3), rs.getDate(4), rs.getString(5), rs.getDate(6)});
            }
            txt_nguoitao.setText(Login.user);
            txt_ngaytao.setText(LocalDate.now().toString());
        } catch (SQLException ex) {
            Logger.getLogger(QLKHoaHoc.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void refresh() {
        txt_Khaigiang.setText(null);
        txt_chuyende.setText(null);
        txt_ghichu.setText(null);
        txt_hocphi.setText(null);
        txt_ngaytao.setText(null);
        txt_nguoitao.setText(null);
        txt_thoiluong.setText(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        cbb_chuyende = new javax.swing.JComboBox<>();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_chuyende = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_chuyende = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_hocphi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_nguoitao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_ghichu = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        txt_Khaigiang = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_thoiluong = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_ngaytao = new javax.swing.JTextField();
        btn_next = new javax.swing.JButton();
        btn_them = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        btn_pre = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("CHUYÊN ĐỀ");

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        cbb_chuyende.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbb_chuyendeItemStateChanged(evt);
            }
        });
        cbb_chuyende.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbb_chuyendeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cbb_chuyende, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbb_chuyende, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tbl_chuyende.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã KH", "Thời lượng", "Học phí", "Khai giảng", "Tạo bởi", "Ngày tạo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_chuyende.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_chuyendeMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_chuyende);
        if (tbl_chuyende.getColumnModel().getColumnCount() > 0) {
            tbl_chuyende.getColumnModel().getColumn(0).setResizable(false);
            tbl_chuyende.getColumnModel().getColumn(1).setResizable(false);
            tbl_chuyende.getColumnModel().getColumn(2).setResizable(false);
            tbl_chuyende.getColumnModel().getColumn(3).setResizable(false);
            tbl_chuyende.getColumnModel().getColumn(4).setResizable(false);
            tbl_chuyende.getColumnModel().getColumn(5).setResizable(false);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Danh sách", jPanel3);

        jLabel2.setText("Chuyên đề");

        txt_chuyende.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_chuyende.setForeground(new java.awt.Color(255, 0, 0));

        jLabel3.setText("Học phí");

        jLabel4.setText("Người tạo");

        jLabel5.setText("Ghi chú");

        txt_ghichu.setColumns(20);
        txt_ghichu.setRows(5);
        jScrollPane1.setViewportView(txt_ghichu);

        jLabel6.setText("Khai giảng");

        jLabel7.setText("Thời lượng");

        jLabel8.setText("Ngày tạo");

        btn_next.setText(">>");
        btn_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextActionPerformed(evt);
            }
        });

        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        jButton2.setText("Sửa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Xóa");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Mới");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("|<");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        btn_pre.setText("<<");
        btn_pre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_preActionPerformed(evt);
            }
        });

        jButton1.setText(">|");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(txt_chuyende)
                            .addComponent(jLabel3)
                            .addComponent(txt_hocphi)
                            .addComponent(jLabel4)
                            .addComponent(txt_nguoitao, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txt_ngaytao)
                            .addComponent(txt_thoiluong)
                            .addComponent(txt_Khaigiang)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(btn_them)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addGap(14, 14, 14)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_pre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_next)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_chuyende, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Khaigiang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_hocphi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_thoiluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nguoitao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ngaytao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton4)
                        .addComponent(jButton3)
                        .addComponent(jButton5)
                        .addComponent(btn_pre)
                        .addComponent(btn_next)
                        .addComponent(jButton1))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(btn_them)))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("cập nhật", jPanel4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1))
        );

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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbb_chuyendeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbb_chuyendeActionPerformed

    }//GEN-LAST:event_cbb_chuyendeActionPerformed

    private void cbb_chuyendeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbb_chuyendeItemStateChanged
        String query = "select makh,khoahoc.thoiluong,khoahoc.hocphi,khoahoc.NGAYKG,manv,ngaytao\n"
                + "from KHOAHOC  join CHUYENDE on KHOAHOC.MACD=CHUYENDE.MACD\n"
                + "where  CHUYENDE.TENCD  = ?";
        model = (DefaultTableModel) tbl_chuyende.getModel();
        model.setRowCount(0);

        txt_chuyende.setText(cbb_chuyende.getSelectedItem().toString());
        try {
            PreparedStatement pre = ConnectSQLServer.Connect.con.prepareStatement(query);
            pre.setString(1, cbb_chuyende.getSelectedItem().toString());
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString(1), rs.getInt(2), rs.getDouble(3), rs.getDate(4), rs.getString(5), rs.getDate(6)});
            }
            txt_nguoitao.setText(Login.user);
            txt_ngaytao.setText(LocalDate.now().toString());
        } catch (SQLException ex) {
            Logger.getLogger(QLKHoaHoc.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_cbb_chuyendeItemStateChanged

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed

    }//GEN-LAST:event_btn_themActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (CheckNull.CheckNull(txt_Khaigiang.getText(), txt_chuyende.getText(), txt_hocphi.getText(), txt_ngaytao.getText(), txt_nguoitao.getText(), txt_thoiluong.getText(), txt_ghichu.getText()) == false) {
            JOptionPane.showMessageDialog(this, "Bạn chưa điền đủ thông tin");
            return;
        }
        if (Regex.iSNaN(txt_hocphi.getText()) == false) {
            JOptionPane.showMessageDialog(this, "Học phí phải là số");
            return;
        }
        if (Regex.iSNaN(txt_thoiluong.getText()) == false) {
            JOptionPane.showMessageDialog(this, "Thời lượng phải là số");
            return;
        }
        try {
            if (CRUD.CRUD_KhoaHoc.updateToDB(txt_Khaigiang.getText(), Integer.parseInt(txt_thoiluong.getText()), Double.parseDouble(txt_hocphi.getText()), txt_ghichu.getText(), makh) > 0) {
                JOptionPane.showMessageDialog(this, "Sửa thành công");
                ServiceKhoaHoc.addToList();
                loadTable();
            }
        } catch (SQLException ex) {
            Logger.getLogger(QLKHoaHoc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    private void clickTable() {
        index = tbl_chuyende.getSelectedRow();
        txt_Khaigiang.setText(tbl_chuyende.getValueAt(index, 3).toString());
        txt_thoiluong.setText(tbl_chuyende.getValueAt(index, 1).toString());
        txt_hocphi.setText(tbl_chuyende.getValueAt(index, 2).toString());
        txt_ngaytao.setText(tbl_chuyende.getValueAt(index, 5).toString());
        makh = tbl_chuyende.getValueAt(index, 0).toString();

    }
    public void next(){
         txt_Khaigiang.setText(tbl_chuyende.getValueAt(index, 3).toString());
        txt_thoiluong.setText(tbl_chuyende.getValueAt(index, 1).toString());
        txt_hocphi.setText(tbl_chuyende.getValueAt(index, 2).toString());
        txt_ngaytao.setText(tbl_chuyende.getValueAt(index, 5).toString());
        makh = tbl_chuyende.getValueAt(index, 0).toString();
    }
    private void tbl_chuyendeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_chuyendeMouseClicked
        clickTable();
    }//GEN-LAST:event_tbl_chuyendeMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
int chon=JOptionPane.showConfirmDialog(this, "bạn muốn xóa không","hỏi",JOptionPane.YES_NO_OPTION);
if(chon==0){
        try {
            if(CRUD.CRUD_KhoaHoc.deleteToDB(makh)>0){
                JOptionPane.showMessageDialog(this, "Xóa thành công");
                ServiceKhoaHoc.addToList();
                loadTable();
                refresh();
            }
                } catch (SQLException ex) {
            Logger.getLogger(QLKHoaHoc.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
index=0;
next();// TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btn_preActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_preActionPerformed
index--;
if(index<=0){index=0;}
next();// TODO add your handling code here:
    }//GEN-LAST:event_btn_preActionPerformed

    private void btn_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextActionPerformed
index++;
if(index>=ServiceKhoaHoc.list.size()-1){index=ServiceKhoaHoc.list.size()-1;}
next();
// TODO add your handling code here:
    }//GEN-LAST:event_btn_nextActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
index=ServiceKhoaHoc.list.size()-1;
next();// TODO add your handling code here:        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
refresh();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_next;
    private javax.swing.JButton btn_pre;
    private javax.swing.JButton btn_them;
    private javax.swing.JComboBox<String> cbb_chuyende;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbl_chuyende;
    private javax.swing.JTextField txt_Khaigiang;
    private javax.swing.JTextField txt_chuyende;
    private javax.swing.JTextArea txt_ghichu;
    private javax.swing.JTextField txt_hocphi;
    private javax.swing.JTextField txt_ngaytao;
    private javax.swing.JTextField txt_nguoitao;
    private javax.swing.JTextField txt_thoiluong;
    // End of variables declaration//GEN-END:variables
}
