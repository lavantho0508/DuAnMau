/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD;
import ConnectSQLServer.Connect;
import GUI.QLNhanVien;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JRadioButton;
/**
 *
 * @author DELL
 */
public class CRUD_NhanVien {
    static{
        try {
            Connect.Connect();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(CRUD_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    public static int add(String manv,String matkhau,String hoten) throws SQLServerException, SQLException{
        Connect.con=Connect.data.getConnection();
        PreparedStatement pre=Connect.con.prepareStatement("insert into nhanvien values(?,?,?,?) ");
        pre.setString(1, manv);
        pre.setString(2, matkhau);
        pre.setString(3, hoten);
        pre.setInt(4, QLNhanVien.role);
        return pre.executeUpdate();
      
    }
    public static int Update(String pass,String manv) throws SQLServerException, SQLException{
           Connect.con=Connect.data.getConnection();
           PreparedStatement pre= Connect.con.prepareStatement("update nhanvien set matkhau=? where manv=?");
           pre.setString(1, pass);
           pre.setString(2, manv);
           return pre.executeUpdate();
           
    }
}
