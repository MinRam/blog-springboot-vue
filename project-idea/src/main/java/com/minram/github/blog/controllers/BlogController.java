package com.minram.github.blog.controllers;

import com.minram.github.blog.entities.Post;
import com.minram.github.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Date;

@RestController
public class BlogController {
    @Autowired
    private PostService postService;

    @GetMapping(value = "/")
    public String index(){
        return "index";
    }

    @GetMapping(value = "/posts")
    public List<Post>  posts(){
        return postService.getAllPosts();
    }

    @PostMapping(value =  "/post")
    public void publicPost(@RequestBody Post post){
        if(post.getDate() == null){
            post.setDate(new Date());
        }
        postService.insert(post);
    }
}
