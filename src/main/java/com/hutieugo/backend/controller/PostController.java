package com.hutieugo.backend.controller;
import com.hutieugo.backend.model.Post;
import com.hutieugo.backend.repository.PostRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins = "https://hutieugo.id.vn")
public class PostController {
    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postRepository.save(post);
    }

    @GetMapping
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }
}