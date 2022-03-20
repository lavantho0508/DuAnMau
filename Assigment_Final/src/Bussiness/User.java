
package Bussiness;
public class User {
    private String user;
    private String pass;
    private String hoten;
    private int role;

    public User() {
    }

    public User(String user, String pass, String hoten, int role) {
        this.user = user;
        this.pass = pass;
        this.hoten = hoten;
        this.role = role;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
public String getRole(int role){
    if(role==0){
        return "Truongphong";
    }
    return "Nhanvien";
}
   

}
