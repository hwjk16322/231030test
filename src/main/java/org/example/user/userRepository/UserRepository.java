package org.example.user.userRepository;

import org.example.user.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    List<User> userList = new ArrayList<>();

    public boolean canUseId(String userId) {
        for (int i = 0; i < userList.size(); i++) {
            if (userId.equals(userList.get(i).getUserId())) {
                return true;
            }
        }
        return false;
    }

    public void newUser(String userId, String userPW) {
        User newUser = new User(userId,userPW);
        userList.add(newUser);
    }

    public User login(String id, String PW) {
        for (int i = 0; i< userList.size(); i++){
            if(id.equals(userList.get(i).getUserId()) && PW.equals(userList.get(i).getUserPW())){
                return userList.get(i);
            }

        }
        return null;
    }
}
