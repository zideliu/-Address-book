package entity;

public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String youbian;
    private String pic;
    private String address;


    public User() {
        super();
    }
    public User(String username, String password, String email, String phone, String youbian) {
        super();
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.youbian = youbian;
    }
    public User(int id, String username, String password, String email, String phone, String youbian) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.youbian = youbian;
    }

    public User(String username, String password, String email, String phone, String youbian, String pic,
                String address) {
        super();
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.youbian = youbian;
        this.pic = pic;
        this.address = address;
    }

    public User(int id, String username, String password, String email, String phone, String youbian, String pic,
                String address) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.youbian = youbian;
        this.pic = pic;
        this.address = address;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getYoubian() {
        return youbian;
    }

    public void setYoubian(String youbian) {
        this.youbian = youbian;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", phone="
                + phone + ", youbian=" + youbian + ", pic=" + pic + ", address=" + address + "]";
    }

}
