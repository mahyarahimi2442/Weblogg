package ir.ac.weblogg.dto.post;
import ir.ac.weblogg.model.Post;
import ir.ac.weblogg.model.PostStatus;

import java.time.LocalDateTime;

public class PostDto {
    private final int id;
    private final String title;
    private final LocalDateTime creationDate;
    private final LocalDateTime updatedAt;
    private final String content;
    private final String author;
    private final PostStatus status;
    private final LocalDateTime publishedAt;
    private final String categoryName;
    private final int categoryId;

    public PostDto(int id, String title, LocalDateTime creationDate, LocalDateTime updatedAt, String content, String author, PostStatus status
                   , LocalDateTime publishedAt, String categoryName, int categoryId) {
        this.id = id;
        this.title = title;
        this.creationDate = creationDate;
        this.updatedAt = updatedAt;
        this.content = content;
        this.author = author;
        this.status = status;
        this.publishedAt = publishedAt;
        this.categoryName = categoryName;
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public PostStatus getStatus() {
        return status;
    }


    public LocalDateTime getPublishedAt() {
        return publishedAt;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public static PostDto convertToDto(Post post)
    {return new PostDto(
            post.getId(),
            post.getTitle(),
            post.getCreatedAt(),
            post.getUpdatedAt(),
            post.getContent(),
            post.getAuthor(),
            post.getStatus(),
            post.getPublishedAt(),
            post.getCategory().getName(),
            post.getCategory().getId());

    }
}

