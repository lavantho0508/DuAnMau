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
public class ServiceNguoiHoc {
  public static  List<NguoiHoc>list=new LinkedList<>();
    public static void addToList() throws SQLException{
        Statement sta=ConnectSQLServer.Connect.con.createStatement();
        ResultSet rs=sta.executeQuery("select*from nguoihoc");
        while (rs.next()) {            
            NguoiHoc nguoihoc=new NguoiHoc(rs.getString(1),rs.getString(2), rs.getString(3), rs.getInt(4),rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
            list.add(nguoihoc);
        }
    }
    public static boolean checkKhoaChinh(String manh){
        for (NguoiHoc x: list) {
            if(manh.equals(x.getManh())){
                return false;
            }
        }
       return true; 
}
    public static boolean checkKhoaPhu(String manv){
        for (User nguoiHoc : ServiceUser.list) {
            if(manv.equals(nguoiHoc.getUser())){
                return true;
            }
        }
        return false;
    }
}
