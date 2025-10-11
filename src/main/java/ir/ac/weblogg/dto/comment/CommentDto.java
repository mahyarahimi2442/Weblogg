package ir.ac.weblogg.dto.comment;

import ir.ac.weblogg.dto.post.PostDto;
import ir.ac.weblogg.model.Comment;
import ir.ac.weblogg.model.Post;

public class CommentDto {
    private final int id;
    private final String authorName;
    private final String authorEmail;
    private final String content;
    private final boolean approved;
    private final int postId;

    public CommentDto(int id, String authorName, String authorEmail, String content, boolean approved, int postId) {
        this.id = id;
        this.authorName = authorName;
        this.authorEmail = authorEmail;
        this.content = content;
        this.approved = approved;
        this.postId = postId;
    }

    public int getId() {
        return id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public String getContent() {
        return content;
    }

    public boolean isApproved() {
        return approved;
    }

    public int getPostId() {
        return postId;
    }

    public static CommentDto convertToDto(Comment comment) {
        return new CommentDto(
                comment.getId(),
                comment.getAuthorName(),
                comment.getAuthorEmail(),
                comment.getContent(),
                comment.isApproved(),
                comment.getPost().getId()
        );
    }
}