package org.example;

import org.example.db.DBConnection;
import org.example.post.entity.Post;
import org.example.post.postController.PostController;
import org.example.system.systemController.SystemController;
import org.example.user.userController.UserController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class App {
    public App() {
        DBConnection.DB_NAME = "proj1031";
        DBConnection.DB_USER = "root";
        DBConnection.DB_PORT = 3306;
        DBConnection.DB_PASSWORD = "";
        Container.getDBconnection().connect();
//        Container.getDBconnection().insert("INSERT INTO post \n SET id = 5 ,\n title = \"555\",\n content = \"555\",\n userId = 3;");
//        Container.getDBconnection().delete("DELETE FROM post \n" +
//                "WHERE userId = 3;");
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("SELECT * FROM post;"));

        List<Post> postList = new ArrayList<>();
        List<Map<String,Object>> rows = Container.getDBconnection().selectRows(sb.toString());
//        System.out.println(rows);

        for (Map<String,Object> row : rows){
            System.out.println(row);
        }

//        for (Map<String,Object> row : rows){
//            postList.add(new Post(row));
//        }
    }

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
