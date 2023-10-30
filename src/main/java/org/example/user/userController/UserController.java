package org.example.user.userController;


import org.example.Container;
import org.example.user.entity.User;
import org.example.user.userService.UserService;

import java.util.Scanner;

public class UserController {
    UserService userService = new UserService();


    Scanner sc = Container.getSc();

    public void sign() {
        if (Container.getLoginuser() != null) {
            System.out.println("이미 로그인되어 있습니다.");
            return;
        }
        String userId;
        String userPW;
        String userPWCheck;
        while (true) {
            System.out.println("사용하실 아이디를 입력해주세요");
            System.out.print("입력 ) ");
            userId = sc.nextLine();
            if (userService.canUseId(userId)) {
                break;
            } else {
                System.out.println("이미 사용중인 아이디입니다. 다시 시도해주세요");
            }
        }
        System.out.println("사용하실 비밀번호를 입력해주세요");
        while (true) {
            System.out.print("입력 ) ");
            userPW = sc.nextLine();
            System.out.println("비밀번호를 확인해주세요");
            System.out.print("입력 ) ");
            userPWCheck = sc.nextLine();
            if (userPW.equals(userPWCheck)) {
                break;
            } else {
                System.out.println("비밀번호가 다릅니다. 다시 입력해주세요");
            }
        }

        userService.newUser(userId, userPW);
        System.out.println("회원가입이 완료되었습니다.");
    }

    public void login() {

        if (Container.getLoginuser() != null) {
            System.out.println("이미 로그인되어 있습니다.");
            return;
        }

        System.out.println("아이디를 입력해주세요");
        System.out.print("입력 ) ");
        String id = sc.nextLine();
        System.out.println("비밀번호를 입력해주세요");
        System.out.print("입력 ) ");
        String PW = sc.nextLine();


        User user = userService.login(id, PW);
        if (user == null) {
            System.out.println("회원정보가 일치하지 않습니다.");
            return;
        }

        Container.setLoginuser(user);
        System.out.println("로그인이 완료되었습니다. " + Container.getLoginuser().getUserId() + " 님 안녕하세요!");

    }


    public void logout() {
        if (Container.getLoginuser() == null) {
            System.out.println("로그인 상태가 아닙니다.");
        } else {
            System.out.println("로그아웃 되었습니다.");
            Container.setLoginuser(null);
        }
    }

}
