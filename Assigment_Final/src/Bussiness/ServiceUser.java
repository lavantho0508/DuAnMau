/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussiness;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.util.LinkedList;
import java.util.List;
import ConnectSQLServer.Connect;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class ServiceUser {
  public static List<User>list=new LinkedList<>();
    static{
       try {
           Connect.Connect();
          addUser();
           
       } catch (SQLException ex) {
           ex.printStackTrace();
           Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    public static void addUser() throws SQLServerException, SQLException{
        Connect.con=Connect.data.getConnection();
        Statement sta=Connect.con.createStatement();
        ResultSet rs=sta.executeQuery("Select*from nhanvien");
        list=new LinkedList<>();
        while (rs.next()) {            
            User user=new User(rs.getString(1),rs.getString(2), rs.getNString(3),rs.getInt(4));
            list.add(user);
        }
      
    }
   
}
