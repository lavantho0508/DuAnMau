/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import CRUD.CRUD_Nguoihoc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */

public class Standardized_char {
    public static boolean checkInput_NguoiHoc(String manh,String hoten,String dienthoai,String email,String ghichu,String manv){
        if(manh.length()>10||hoten.length()>50||dienthoai.length()>50||email.length()>50||ghichu.length()>50||manv.length()>10){
            return false;
        }
        return true;
    }
     static{
        try {
            ConnectSQLServer.Connect.Connect();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(CRUD_Nguoihoc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static boolean checkInput_ChuyenDe(String macd,String tencd){
        if(macd.length()>10||tencd.length()>50){
            return false;
        }
        return true;
    }
    public static boolean checkInput_KhoaHoc(String macd,String manv){
        if(macd.length()>10||manv.length()>10){
            return false;
        }
        return true;
    }
    public static boolean checkInput_HocVien(String manh){
        if(manh.length()>10){
            return false;
        }
        return true;
    }
   
}
