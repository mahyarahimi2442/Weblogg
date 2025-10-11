package ir.ac.weblogg.Repasitory;

import ir.ac.weblogg.dto.post.PostDto;
import ir.ac.weblogg.model.Category;
import ir.ac.weblogg.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    List<Post> findAllByDisableDateIsNull();
    List<Post> findByCategory(Category category);
    List<Post> findByCategoryId(int categoryId);

}
