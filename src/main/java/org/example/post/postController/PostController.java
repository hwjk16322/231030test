package org.example.post.postController;

import org.example.Container;
import org.example.post.entity.Post;
import org.example.post.postService.PostService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PostController {
    Scanner sc = Container.getSc();
    PostService postService = new PostService();

    public void write() {
        if (Container.getLoginuser() == null) {
            System.out.println("로그인해야 등록할 수 있습니다.");
            return;
        }
        System.out.println("제목을 입력해주세요");
        System.out.print("입력 ) ");
        String title = sc.nextLine();
        System.out.println("내용을 입력해주세요");
        System.out.print("입력 ) ");
        String content = sc.nextLine();
        postService.write(title, content, Container.getLoginuser().getUserId());
        System.out.println("등록이 완료되었습니다.");
    }

    public void list() {
        List<Post> postList = postService.postList();
        if (postList.size() == 0) {
            System.out.println("등록된 게시물이 없습니다.");
            return;
        }
        System.out.println("번호 / 제목 / 내용 / 글쓴이");
        for (int i = 0; i < postList.size(); i++) {
            System.out.printf("%d / %s / %s / %s \n", postList.get(i).getId(), postList.get(i).getTitle(), postList.get(i).getContent(), postList.get(i).getUserName());
        }

    }

    public void modify() {
        if (Container.getLoginuser() == null) {
            System.out.println("로그인해야 수정할 수 있습니다.");
            return;
        }
        try {
            System.out.println("수정하실 게시물 번호를 입력해주세요");
            System.out.print("입력 ) ");
            int id = Integer.parseInt(sc.nextLine());
            Post post = postService.postList().get(id-1);
            if (post.getUserName().equals(Container.getLoginuser().getUserId())) {
                System.out.println("기존 제목 : " + post.getTitle());
                System.out.println("수정할 제목을 입력해주세요");
                System.out.print("입력 ) ");
                String newTitle = sc.nextLine();
                System.out.println("기존 내용 : " + post.getContent());
                System.out.println("수정할 제목을 입력해주세요");
                System.out.print("입력 ) ");
                String newContent = sc.nextLine();

                postService.modify(newTitle, newContent, id-1);

                System.out.println("수정이 완료되었습니다.");

            } else {
                System.out.println("작성하신 글만 수정할 수 있습니다.");
            }
        } catch (Exception e) {
            System.out.println("숫자만 입력해주세요");
        }


    }

    public void remove() {
        if (Container.getLoginuser() == null) {
            System.out.println("로그인해야 삭제할 수 있습니다.");
            return;
        }
        try {
            System.out.println("삭제하실 게시물 번호를 입력해주세요");
            System.out.print("입력 ) ");
            int id = Integer.parseInt(sc.nextLine());
            Post post = postService.postList().get(id-1);

            if (post.getUserName().equals(Container.getLoginuser().getUserId())) {
                postService.remove(id-1);
                System.out.println("삭제가 완료되었습니다.");

            } else {
                System.out.println("작성하신 글만 삭제할 수 있습니다.");
            }
        } catch (Exception e) {
            System.out.println("오류가 발생했습니다. 다시 시도해주세요");
        }


    }
}
