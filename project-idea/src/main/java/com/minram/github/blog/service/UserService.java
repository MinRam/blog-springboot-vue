package com.minram.github.blog.service;

import com.minram.github.blog.entities.User;
import com.minram.github.blog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public User getUser(String username){
        return repo.findByUsername(username);
    }

    public void save(User user){
        user.setPassword(getPasswordEncoder().encode(user.getPassword()));
        repo.save(user);
    }
}
