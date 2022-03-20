/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussiness;

import static Bussiness.ServiceNguoiHoc.list;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public  class ServiceChuyenDe {
 public static   List<ChuyenDe>list=new LinkedList<>();
    public static void addtoList() throws SQLException{
        Statement sta=ConnectSQLServer.Connect.con.createStatement();
        ResultSet rs=sta.executeQuery("select*from chuyende");
        while (rs.next()) {
ChuyenDe cd=new ChuyenDe(rs.getString(1),rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getString(5), rs.getString(6));
list.add(cd);

            
        }
    }
      public static boolean checkKhoaChinh(String macd){
        for (ChuyenDe x: list) {
            if(macd.equals(x.getMacd()))return false;
        }
       return true; 
}
    
}
