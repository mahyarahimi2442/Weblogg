package ir.ac.weblogg.service.Post;

import ir.ac.weblogg.Repasitory.PostRepository;
import ir.ac.weblogg.customExeption.RuleException;
import ir.ac.weblogg.model.Post;

import java.time.LocalDateTime;
import java.util.List;

public class PostServiceImp implements PostService {

    private final PostRepository postRepository;

    public PostServiceImp(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void save(Post post) {
        postRepository.save(post);

    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAllByDisableDateIsNull();
    }

    @Override
    public Post findById(int id) {
        return postRepository.findById(id)
                .orElseThrow(()->new RuleException("post.not.found"));
    }

    @Override
    public void delete(int id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuleException("post.not.found"));
        post.setDisableDate(LocalDateTime.now());
        postRepository.save(post);
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
          postRepository.save(post);

    }
}
