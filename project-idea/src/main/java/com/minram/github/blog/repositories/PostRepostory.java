package com.minram.github.blog.repositories;

import com.minram.github.blog.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepostory extends JpaRepository<Post,Long> {

}
