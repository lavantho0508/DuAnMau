/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import javax.swing.JRadioButton;

/**
 *
 * @author DELL
 */
public class getRole {
     public static int getRole(JRadioButton rd_truongphong,JRadioButton rd_nhanvien){
        if(rd_truongphong.isSelected()){
            return 0;
        }
        return 1;
    }
}
