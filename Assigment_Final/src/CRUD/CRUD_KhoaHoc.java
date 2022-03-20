/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class CRUD_KhoaHoc {
    static{
        try {
            ConnectSQLServer.Connect.Connect();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(CRUD_Nguoihoc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static int insertToDB(String macd,double hocphi,int thoiluong,String ngaykg,String ghichu,String manv,String ngaytao) throws SQLException{
        PreparedStatement pre=ConnectSQLServer.Connect.con.prepareStatement("insert into khoahoc(macd,hocphi,thoiluong,ngaykg,ghichu,manv,ngaytao) values(?,?,?,?,?,?,?)");
        pre.setString(1, macd);
        pre.setDouble(2, hocphi);
        pre.setInt(3, thoiluong);
        pre.setString(4, ngaykg);
        pre.setString(5, ghichu);
        pre.setString(6, manv);
        pre.setString(7, ngaytao);
        return pre.executeUpdate();

    }
    public static int deleteToDB(String makh) throws SQLException{
        PreparedStatement pre=ConnectSQLServer.Connect.con.prepareStatement("delete from khoahoc where makh=?");
        pre.setString(1, makh);
        return pre.executeUpdate();
        
    }
    public static int updateToDB(String khaigiang,int thoiluong,double hocphi,String ghichu,String makh)throws SQLException{
        String query="Update khoahoc set ngaykg=?,thoiluong=?,hocphi=?,ghichu=? where makh=?";
        PreparedStatement pre=ConnectSQLServer.Connect.con.prepareStatement(query);
        pre.setString(1, khaigiang);
        pre.setInt(2, thoiluong);
        pre.setDouble(3, hocphi);
        pre.setString(4, ghichu);
        pre.setString(5,makh);
        return pre.executeUpdate();
    }
}
