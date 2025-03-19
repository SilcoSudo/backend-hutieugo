import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;
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