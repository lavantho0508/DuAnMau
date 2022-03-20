/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author DELL
 */
public class Regex {

    public static boolean checkMail(String mail) {
        Pattern p = Pattern.compile("^(.+)@(.+)$");
        Matcher math = p.matcher(mail);
        return math.find();
    }

    public static boolean checkSDT(String sdt) {
        Pattern p = Pattern.compile("^[0-9]{9,10}+$");
        Matcher m = p.matcher(sdt);
        return m.find();
    }

    public static boolean iSNaN(String number) {
        Pattern p = Pattern.compile("^[0-9]+$");
        Matcher m = p.matcher(number);
        return m.find();
    }
    public static void main(String[] args) {
        String regex="^[a-zA-Z0-9]+[!-@-#-$-%-^&]$";
        if("hell312jjdasdsa$".matches(regex)==false){
            System.out.println("hello");
                    
        }
    }
   
}
