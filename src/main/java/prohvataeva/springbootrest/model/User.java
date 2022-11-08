package prohvataeva.springbootrest.model;

import javax.validation.constraints.*;

public class User {
    @NotBlank(message = "User name or password is empty")
//    @Pattern(regexp = "[a-zA-Z]")
    @Size(min=5, max=15)

    String user;
    @Size(min=5, max=15)

    String password;

    public User() {
    }

    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
