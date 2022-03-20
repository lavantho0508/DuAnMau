/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD;
import ConnectSQLServer.Connect;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author DELL
 */
public class CRUD_Nguoihoc {
    static{
        try {
            ConnectSQLServer.Connect.Connect();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(CRUD_Nguoihoc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static int insertToDB(String manh,String hoten,String ngaysinh,int gioitinh,String dienthoai,String email,String ghichu,String manv,String ngaydk) throws SQLServerException, SQLException{
        Connect.con=Connect.data.getConnection();
        String query="insert into Nguoihoc values (?,?,?,?,?,?,?,?,?)";
        PreparedStatement pre=Connect.con.prepareStatement(query);
        pre.setString(1, manh);
        pre.setString(2, hoten);
        pre.setString(3, ngaysinh);
        pre.setInt(4, gioitinh);
        pre.setString(5, dienthoai);
        pre.setString(6, email);
        pre.setString(7, ghichu);
        pre.setString(8,manv);
        pre.setString(9, ngaydk);
        return pre.executeUpdate();
       
    }
    public static int delete(String manh) throws SQLException{
       
        PreparedStatement pre1=Connect.con.prepareStatement("delete from nguoihoc where manh=?");
        pre1.setString(1, manh);
        return pre1.executeUpdate();
    
}
    public static int Update(String manh,String hoten,String ngaysinh,int gioitinh,String dienthoai,String email,String ghichu) throws SQLException{
        String query="update NGUOIHOC\n" +
"set HOTEN=?,NGAYSINH=?,GIOITINH=?,\n" +
"    DIENTHOAI=?,EMAIL=?,GHICHU=? where manh=? ";
        PreparedStatement pre=Connect.con.prepareStatement(query);
        pre.setString(1,hoten);
        pre.setString(2,ngaysinh);
        pre.setInt(3,gioitinh);
        pre.setString(4,dienthoai);
        pre.setString(5,email);
        pre.setString(6,ghichu);
        pre.setString(7,manh);
       
        return pre.executeUpdate();
        
    }
}
