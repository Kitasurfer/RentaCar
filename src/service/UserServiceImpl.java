package service;/* Group: 52-1, "AIT Hi-tech team" GMBH 
Author: Bogdan Fesenko
Date: 27-10-2024
*/

import model.User;
import repository.UserRepository;

/*

 */
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    @Override
    public User addUser(String email, String password) {
        if (userRepository.isEmailExists(email)) {
            return null;
        }
        return userRepository.addUser(email, password);
    }

    @Override
    public boolean isEmailExists(String email) {
        return userRepository.isEmailExists(email);
    }
}
