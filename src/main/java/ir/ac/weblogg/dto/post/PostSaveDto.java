package ir.ac.weblogg.dto.post;
import ir.ac.weblogg.model.Category;
import ir.ac.weblogg.model.Post;
import ir.ac.weblogg.model.PostStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PostSaveDto {

    private final String title;
    private final String content;
    private final String author;
    private final PostStatus status;
    private final Integer categoryId;

    public PostSaveDto(String title, String content, String author, PostStatus status, Integer categoryId) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.status = status;
        this.categoryId = categoryId;
    }

    @NotBlank(message = "post.save.dto.title.blank")
    public String getTitle() {
        return title;
    }

    @NotBlank(message = "post.save.dto.content.blank")
    public String getContent() {
        return content;
    }

    @NotBlank(message = "post.save.dto.author.blank")
    public String getAuthor() {
        return author;
    }

    @NotNull(message = "post.save.dto.status.null")
    public PostStatus getStatus() {
        return status;
    }

    @NotNull(message = "post.save.dto.category.null")
    public Integer getCategoryId() {
        return categoryId;
    }


    public Post convertToPost(Category category) {
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setAuthor(author);
        post.setStatus(status);
        post.setCategory(category);
        return post;
    }
}