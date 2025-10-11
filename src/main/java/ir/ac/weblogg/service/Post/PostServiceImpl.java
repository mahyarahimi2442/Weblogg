package ir.ac.weblogg.service.Post;

import ir.ac.weblogg.Repasitory.PostRepository;
import ir.ac.weblogg.customExeption.RuleException;
import ir.ac.weblogg.dto.post.PostDto;
import ir.ac.weblogg.model.Post;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void save(Post post) {
        post.setCreatedAt(LocalDateTime.now());
        postRepository.save(post);
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAllByDisableDateIsNull();
    }

    @Override
    public Post findById(int id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new RuleException("post.not.found"));
    }

    @Override
    public void update(int id, Post updatePost) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuleException("post.not.found"));

        post.setTitle(updatePost.getTitle());
        post.setContent(updatePost.getContent());
        post.setAuthor(updatePost.getAuthor());
        post.setStatus(updatePost.getStatus());
        post.setUpdatedAt(LocalDateTime.now());
        post.setImage(updatePost.getImage());
        post.setCategory(updatePost.getCategory());
        postRepository.save(post);
    }

    @Override
    public void delete(int id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuleException("post.not.found"));
        post.setDisableDate(LocalDateTime.now());
        postRepository.save(post);
    }

    @Override
    public List<PostDto> findByCategoryId(int categoryId) {
        return
                postRepository.findByCategoryId(categoryId).stream()
                        .map(PostDto::convertToDto).toList();
    }
}