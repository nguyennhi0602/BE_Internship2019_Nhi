package com.nhi.blog.respositories;

import com.nhi.blog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostResppository extends JpaRepository<Post,Integer> {
}
