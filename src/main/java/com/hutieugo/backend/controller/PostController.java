package com.hutieugo.backend.controller;
import com.hutieugo.backend.model.Post;
import com.hutieugo.backend.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins = "http://hutieugo.id.vn")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    // Lấy tất cả bài post
    @GetMapping
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    // Lấy bài post theo ID
    @GetMapping("/{id}")
    public Post getPostById(@PathVariable Long id) {
        return postRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Post not found"));
    }

    // Đăng bài post mới
    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postRepository.save(post);
    }
}