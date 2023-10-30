package org.example.post.postRepository;

import org.example.post.entity.Post;

import java.util.ArrayList;
import java.util.List;

public class PostRepository {
    List<Post> postList = new ArrayList<>();
    int postNumber = 0;

    public int write(String title, String content, String userId) {
        postNumber++;
        Post post = new Post(title, content, postNumber, userId);
        postList.add(post);
        return postNumber;
    }

    public List<Post> postList() {
        return this.postList;
    }

    public void modify(String newTitle, String newContent, int id) {
        postList.get(id).setTitle(newTitle);
        postList.get(id).setContent(newContent);
    }


    public void remove(int id) {
        postList.remove(id);
    }
}
