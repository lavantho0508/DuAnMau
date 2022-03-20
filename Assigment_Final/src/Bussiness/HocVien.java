/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussiness;

/**
 *
 * @author DELL
 */
public class HocVien {
    private int mahv;
    private String manh;
    private String hoten;
    private double diem;

    public HocVien() {
    }

    public HocVien(int mahv, String manh, String hoten, double diem) {
        this.mahv = mahv;
        this.manh = manh;
        this.hoten = hoten;
        this.diem = diem;
    }

    public int getMahv() {
        return mahv;
    }

    public void setMahv(int mahv) {
        this.mahv = mahv;
    }

    public String getManh() {
        return manh;
    }

    public void setManh(String manh) {
        this.manh = manh;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public double getDiem() {
        return diem;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }
    
}
