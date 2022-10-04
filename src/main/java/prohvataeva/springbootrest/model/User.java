package prohvataeva.springbootrest.model;

import javax.validation.constraints.*;

public class User {
    @NotBlank(message = "User name or password is empty")
//    @Pattern(regexp = "[a-zA-Z]")
    @Size(min=5, max=15)

    String name;
    @Size(min=5, max=15)

    String password;

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
