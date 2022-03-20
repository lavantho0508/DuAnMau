/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD;

import Bussiness.HocVien;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class CRUD_HocVien {
  public static int update(double diem,int mahv) throws SQLException{
    String query="update hocvien set diem=? where mahv=?";
      PreparedStatement pre=ConnectSQLServer.Connect.con.prepareStatement(query);
      pre.setDouble(1, diem);
      pre.setInt(2, mahv);
      return pre.executeUpdate();
}
    
}
