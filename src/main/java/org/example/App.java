package org.example;

import org.example.post.postController.PostController;
import org.example.system.systemService.SystemController;
import org.example.user.userController.UserController;

public class App {
    public void run() {
        PostController postController = new PostController();
        UserController userController = new UserController();
        SystemController systemController = new SystemController();

        System.out.println("=== 텍스트 게시판 ===");
        while (true) {
            System.out.println("명령어 : 등록, 목록, 수정, 삭제, 회원가입, 로그인, 로그아웃, 종료");
            System.out.print("명령 ) ");
            String command = Container.getSc().nextLine();

            switch (command) {
                case "등록":

                    postController.write();
                    break;

                case "목록":
                    postController.list();
                    break;


                case "수정":
                    postController.modify();
                    break;


                case "삭제":
                    postController.remove();
                    break;


                case "회원가입":
                    userController.sign();
                    break;


                case "로그인":
                    userController.login();
                    break;


                case "로그아웃":
                    userController.logout();
                    break;


                case "종료":
                    systemController.close();
                    return;


            }
        }
    }
}
