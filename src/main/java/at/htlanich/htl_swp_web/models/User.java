package at.htlanich.htl_swp_web.models;

import java.util.Objects;

public class User {
    private String email;
    private String foreName;
    private String lastName;
    private String userName;
    private String password;

    public User(String email, String uName, String fName, String lName, String pwd) {
        super();
        this.email = email;
        userName = uName;
        foreName = fName;
        lastName = lName;
        password = pwd;
    }

    public User(String username, String password) {
        this("", username, "", "", password);
    }

    public User(){
        this("", "");
    }

    public String getEmail() {
        return email;
    }

    public String getForename() {
        return foreName;
    }

    public String getLastname() {
        return lastName;
    }

    public String getUsername() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setForeName(String foreName) {
        this.foreName = foreName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email) && Objects.equals(foreName, user.foreName) && Objects.equals(lastName, user.lastName) && Objects.equals(userName, user.userName) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, foreName, lastName, userName, password);
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", foreName='" + foreName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
