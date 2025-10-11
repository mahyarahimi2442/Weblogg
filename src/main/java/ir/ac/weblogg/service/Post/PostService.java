package ir.ac.weblogg.service.Post;

import ir.ac.weblogg.dto.post.PostDto;
import ir.ac.weblogg.model.Post;

import java.util.List;

public interface PostService {
    void save(Post post);

    List<Post> findAll();

    Post findById(int id);

    void delete(int id);
    List<PostDto> findByCategoryId(int categoryId);

    void update(int id, Post updatePost);

}
