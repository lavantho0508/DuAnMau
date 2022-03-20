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
public class ChuyenDe {
    private String macd;
    private String tencd;
    private double hocphi;
    private int thoiluong;
    private String hinh;
    private String mota;

    public ChuyenDe() {
    }

    public ChuyenDe(String macd, String tencd, double hocphi, int thoiluong, String hinh, String mota) {
        this.macd = macd;
        this.tencd = tencd;
        this.hocphi = hocphi;
        this.thoiluong = thoiluong;
        this.hinh = hinh;
        this.mota = mota;
    }

    public String getMacd() {
        return macd;
    }

    public void setMacd(String macd) {
        this.macd = macd;
    }

    public String getTencd() {
        return tencd;
    }

    public void setTencd(String tencd) {
        this.tencd = tencd;
    }

    public double getHocphi() {
        return hocphi;
    }

    public void setHocphi(double hocphi) {
        this.hocphi = hocphi;
    }

    public int getThoiluong() {
        return thoiluong;
    }

    public void setThoiluong(int thoiluong) {
        this.thoiluong = thoiluong;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
    

}
