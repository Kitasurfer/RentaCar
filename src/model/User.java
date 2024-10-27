package model;

/* Group: 52-1, "AIT Hi-tech team" GMBH
Author: Bogdan Fesenko
Date: 24-10-2024
*/

import utils.MyArrayList;
import utils.MyList;

public class User {
    private final String email;
    private final String password;
    private Role role;
    private final MyList<Car> userCars;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
        this.role = Role.USER;
        this.userCars = new MyArrayList<>();
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", userCars=" + userCars +
                '}';
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public MyList<Car> getUserCars() {
        return userCars;
    }
}
