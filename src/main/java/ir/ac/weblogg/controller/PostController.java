package ir.ac.weblogg.controller;

import ir.ac.weblogg.Repasitory.CategoryRepository;
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
    private final CategoryRepository categoryRepository;

    public PostController(PostService postService, CategoryService categoryService, CategoryRepository categoryRepository) {
        this.postService = postService;
        this.categoryService = categoryService;
        this.categoryRepository = categoryRepository;
    }


    @PostMapping
    public ResponseEntity<SaveDto> save(@Valid @RequestBody PostSaveDto postSaveDto) {
        Category category = categoryRepository.findById(postSaveDto.getCategoryId())
                .orElseThrow(() ->
                new RuleException("category.not.found"));
        Post post = postSaveDto.convertToPost(category);
        postService.save(post);
        return ResponseEntity.ok(new SaveDto(post.getId()));
    }


    @GetMapping
    public ResponseEntity<List<PostDto>> findAll() {
        List<Post> posts = postService.findAll();
        List<PostDto> postDtos = posts.stream()
                .map(PostDto::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(postDtos);
    }


    @GetMapping("/{id}")
    public ResponseEntity<PostDto> findById(@PathVariable int id) {
        Post post = postService.findById(id);
        PostDto postDto = PostDto.convertToDto(post);
        return ResponseEntity.ok(postDto);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<SaveDto> delete(@PathVariable int id) {
        postService.delete(id);
        return ResponseEntity.ok(new SaveDto(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<SaveDto> update(@PathVariable int id,
                                          @Valid @RequestBody PostSaveDto postSaveDto) {
        Category category = categoryRepository.findById(postSaveDto.getCategoryId())
                .orElseThrow(() ->
                        new RuleException("category.not.found"));


        Post updatedPost = postSaveDto.convertToPost(category);
        postService.update(id, updatedPost);
        return ResponseEntity.ok(new SaveDto(id));
    }
    @GetMapping("/category/{categoryId}")
    public List<PostDto> findByCategory(@PathVariable int categoryId) {
        return postService.findByCategoryId(categoryId);

    }
}
