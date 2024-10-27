package service;

import model.User;

public interface UserService {
    User getUserByEmail(String email);

    User addUser(String email, String password);

    boolean isEmailExists(String email);
}
