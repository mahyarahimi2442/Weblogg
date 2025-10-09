package ir.ac.weblogg.controller;

import ir.ac.weblogg.customExeption.RuleException;
import ir.ac.weblogg.dto.SaveDto;
import ir.ac.weblogg.dto.post.PostDto;
import ir.ac.weblogg.dto.post.PostSaveDto;
import ir.ac.weblogg.model.Category;
import ir.ac.weblogg.model.Post;
import ir.ac.weblogg.service.Category.CategoryService;
import ir.ac.weblogg.service.Post.PostService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/posts")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class PostController {

    private final PostService postService;
    private final CategoryService categoryService;

    public PostController(PostService postService, CategoryService categoryService) {
        this.postService = postService;
        this.categoryService = categoryService;
    }

    // ایجاد پست جدید
    @PostMapping
    public ResponseEntity<SaveDto> save(@Valid @RequestBody PostSaveDto postSaveDto) {
        Category category = categoryService.findById(postSaveDto.getCategoryId());

        Post post = postSaveDto.convertToPost(category);
        postService.save(post);
        return ResponseEntity.ok(new SaveDto(post.getId()));
    }

    // دریافت همه پست‌ها
    @GetMapping
    public ResponseEntity<List<PostDto>> findAll() {
        List<Post> posts = postService.findAll();
        List<PostDto> postDtos = posts.stream()
                .map(PostDto::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(postDtos);
    }

    // دریافت پست بر اساس آیدی
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> findById(@PathVariable int id) {
        Post post = postService.findById(id);
        PostDto postDto = PostDto.convertToDto(post);
        return ResponseEntity.ok(postDto);
    }

    // حذف پست
    @DeleteMapping("/{id}")
    public ResponseEntity<SaveDto> delete(@PathVariable int id) {
        postService.delete(id);
        return ResponseEntity.ok(new SaveDto(id));
    }

    // ویرایش پست
    @PutMapping("/{id}")
    public ResponseEntity<SaveDto> update(@PathVariable int id,
                                          @Valid @RequestBody PostSaveDto postSaveDto) {
        Category category = categoryService.findById(postSaveDto.getCategoryId());


        Post updatedPost = postSaveDto.convertToPost(category);
        postService.update(id, updatedPost);
        return ResponseEntity.ok(new SaveDto(id));
    }
}
