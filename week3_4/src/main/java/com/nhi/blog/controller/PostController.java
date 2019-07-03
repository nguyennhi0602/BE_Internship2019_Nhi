package com.nhi.blog.controller;

import com.nhi.blog.model.Post;
import com.nhi.blog.respositories.PostResppository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {

    private PostResppository postResppository;

    @GetMapping
    Iterable<Post> get(){
        return postResppository.findAll();
    }

    @PostMapping("/create")
    void 
}
