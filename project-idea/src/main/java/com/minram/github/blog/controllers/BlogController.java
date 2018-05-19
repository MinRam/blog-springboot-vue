package com.minram.github.blog.controllers;

import com.minram.github.blog.entities.Post;
import com.minram.github.blog.model.CustomUserDetails;
import com.minram.github.blog.service.PostService;
import com.minram.github.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class BlogController {
    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String index(){
        return "index";
    }

    @GetMapping(value = "/posts")
    public List<Post>  posts(){
        return postService.getAllPosts();
    }

    @PostMapping(value =  "/post")
    public String publicPost(@RequestBody Post post){
        CustomUserDetails userDetails  = (CustomUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(post.getDate() == null){
            post.setDate(new Date());
        }
        post.setCreator(userService.getUser(userDetails.getUsername()));
        postService.insert(post);

        return "Post was published!";
    }
}
