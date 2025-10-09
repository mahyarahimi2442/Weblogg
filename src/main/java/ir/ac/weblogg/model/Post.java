package ir.ac.weblogg.model;

import jakarta.persistence.*;

import java.awt.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "post")
public class Post extends BaseEntity {
    private String title;
    private String content;
    private String author;
    @Enumerated(EnumType.STRING)
    private PostStatus status;
    private LocalDateTime publishedAt;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    public LocalDateTime getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(LocalDateTime publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public PostStatus getStatus() {
        return status;
    }

    public void setStatus(PostStatus status) {
        this.status = status;
    }
}
