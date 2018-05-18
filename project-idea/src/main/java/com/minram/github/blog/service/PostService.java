package com.minram.github.blog.service;

import com.minram.github.blog.entities.Post;
import com.minram.github.blog.repositories.PostRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepostory postRepostory;

    public List<Post> getAllPosts(){
        return postRepostory.findAll();
    }

    public void insert(Post post) {
        postRepostory.save(post);
    }
}
