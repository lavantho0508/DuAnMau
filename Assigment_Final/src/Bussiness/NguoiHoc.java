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
public class NguoiHoc {
    private String manh;
    private String hoten;
    private String ngaysinh;
    private int gioitinh;
    private String diẹnthoai;
    private String email;
    private String ghichu;
    private String manv;
    private String ngaydk;

    public NguoiHoc() {
    }

    public NguoiHoc(String manh, String hoten, String ngaysinh, int gioitinh, String diẹnthoai, String email, String ghichu, String manv, String ngaydk) {
        this.manh = manh;
        this.hoten = hoten;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.diẹnthoai = diẹnthoai;
        this.email = email;
        this.ghichu = ghichu;
        this.manv = manv;
        this.ngaydk = ngaydk;
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

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public int getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(int gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getDiẹnthoai() {
        return diẹnthoai;
    }

    public void setDiẹnthoai(String diẹnthoai) {
        this.diẹnthoai = diẹnthoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getNgaydk() {
        return ngaydk;
    }

    public void setNgaydk(String ngaydk) {
        this.ngaydk = ngaydk;
    }
    
    
}
