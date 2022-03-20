/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussiness;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class ServiceHocVien {
 public static List<HocVien>list=new LinkedList<>();
 static String query="select mahv,nguoihoc.manh,hoten,diem from NGUOIHOC join HOCVIEN\n" +
"on NGUOIHOC.MANH=HOCVIEN.MANH join KHOAHOC on HOCVIEN.MAKH=KHOAHOC.MAKH\n" +
"where macd=?";


 }