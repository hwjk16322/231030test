package org.example.post.postService;

import org.example.post.entity.Post;
import org.example.post.postRepository.PostRepository;

import java.util.List;

public class PostService {
    PostRepository postRepository = new PostRepository();

    public int write(String title, String content, String userId) {

        return postRepository.write(title, content, userId);
    }

    public List<Post> postList() {
        return postRepository.postList();
    }

    public void modify(String newTitle, String newContent, int id) {
        postRepository.modify(newTitle, newContent, id);
    }

    public void remove(int id) {
        postRepository.remove(id);
    }
}
