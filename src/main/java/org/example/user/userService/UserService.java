package org.example.user.userService;

import org.example.user.entity.User;
import org.example.user.userRepository.UserRepository;

public class UserService {
    UserRepository userRepository = new UserRepository();

    public boolean canUseId(String userId) {
        return !userRepository.canUseId(userId);
    }
    public void newUser(String userId, String userPW){
        userRepository.newUser(userId,userPW);
    }

    public User login(String id, String PW){
        return userRepository.login(id,PW);
    }
}
