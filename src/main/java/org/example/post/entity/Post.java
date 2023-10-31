package org.example.post.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class Post {
    private String title;
    private String content;
    private int id;
    private String userName;

    public Post(Map<String, Object> row) {
    }
}
