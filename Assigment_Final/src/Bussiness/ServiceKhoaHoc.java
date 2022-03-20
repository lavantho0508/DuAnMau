/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussiness;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class ServiceKhoaHoc {
     public static  List<KhoaHoc>list=new LinkedList<>();
    public static void addToList() throws SQLException{
        Statement sta=ConnectSQLServer.Connect.con.createStatement();
        ResultSet rs=sta.executeQuery("select*from nguoihoc");
        while (rs.next()) {            
            KhoaHoc kh=new KhoaHoc(rs.getString(1),rs.getString(2), rs.getString(3), rs.getInt(4),rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
            list.add(kh);
        }
    }
    public static boolean checkKhoaphu(String macd){
        for (KhoaHoc x: list) {
            if(macd.equals(x.getMacd())){
                return false;
            }
        }
       return true; 
}
   
}
