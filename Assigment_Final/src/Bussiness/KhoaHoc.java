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
public class KhoaHoc {
    private String makh;
    private String macd;
    private String hocphi;
    private int thoiluong;
    private String ngaykg;
    private String ghichu;
    private String manv;
    private String ngaytao;

    public KhoaHoc() {
    }

    public KhoaHoc(String makh, String macd, String hocphi, int thoiluong, String ngaykg, String ghichu, String manv, String ngaytao) {
        this.makh = makh;
        this.macd = macd;
        this.hocphi = hocphi;
        this.thoiluong = thoiluong;
        this.ngaykg = ngaykg;
        this.ghichu = ghichu;
        this.manv = manv;
        this.ngaytao = ngaytao;
    }

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getMacd() {
        return macd;
    }

    public void setMacd(String macd) {
        this.macd = macd;
    }

    public String getHocphi() {
        return hocphi;
    }

    public void setHocphi(String hocphi) {
        this.hocphi = hocphi;
    }

    public int getThoiluong() {
        return thoiluong;
    }

    public void setThoiluong(int thoiluong) {
        this.thoiluong = thoiluong;
    }

    public String getNgaykg() {
        return ngaykg;
    }

    public void setNgaykg(String ngaykg) {
        this.ngaykg = ngaykg;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(String ngaytao) {
        this.ngaytao = ngaytao;
    }
    
    
}
