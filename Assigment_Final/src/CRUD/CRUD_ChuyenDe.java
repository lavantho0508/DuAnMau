/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD;

import ConnectSQLServer.Connect;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class CRUD_ChuyenDe {
     static{
        try {
            Connect.Connect();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(CRUD_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public static int insertToDB(String macd,String tencd,double hocphi,int thoiluong,String hinh,String mota) throws SQLException{
         PreparedStatement pre=ConnectSQLServer.Connect.con.prepareStatement("Insert into chuyende values(?,?,?,?,?,?)");
         pre.setString(1,macd);
         pre.setString(2,tencd);
         pre.setDouble(3,hocphi);
         pre.setInt(4,thoiluong);
         pre.setString(5,hinh);
         pre.setString(6,mota);
         return pre.executeUpdate();
         
     }
     public static int deleteToDB(String macd) throws SQLException{
         PreparedStatement pre=ConnectSQLServer.Connect.con.prepareStatement("delete from chuyende where macd=?");
         pre.setString(1, macd);
         return pre.executeUpdate();
     }
     public static int updateToDB(String macd,String tencd,double hocphi,int thoiluong,String hinh,String mota) throws SQLException{
          PreparedStatement pre=ConnectSQLServer.Connect.con.prepareStatement("update chuyende set tencd=?,hocphi=?,thoiluong=?,hinh=?,mota=? where macd=?");
           
         pre.setString(1,tencd);
         pre.setDouble(2,hocphi);
         pre.setInt(3,thoiluong);
         pre.setString(4,hinh);
         pre.setString(5,mota);
         pre.setString(6,macd);
          return pre.executeUpdate();
     }
}
