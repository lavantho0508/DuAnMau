/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author DELL
 */
public class SHA_1 {
     public static final char[] hex = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

public static String byteArray2Hex(byte[] bytes) {
    StringBuffer sb = new StringBuffer(bytes.length * 2);
    for(final byte b : bytes) {
        sb.append(hex[(b & 0xF0) >> 4]);
        sb.append(hex[b & 0x0F]);
    }
    return sb.toString();
}

public static String getStringFromSHA256(String stringToEncrypt) throws NoSuchAlgorithmException {
    MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
    messageDigest.update(stringToEncrypt.getBytes());
    return byteArray2Hex(messageDigest.digest());
}
    public static void main(String[] args) {
        System.out.println("");
    }
}
