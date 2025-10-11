package ir.ac.weblogg.dto.comment;

import ir.ac.weblogg.model.Post;
import ir.ac.weblogg.model.Comment;
import jakarta.validation.constraints.NotBlank;

public class CommentSaveDto {
    private String authorName;
    private String authorEmail;
    private String content;
    private int postId;

    @NotBlank(message = "comment.title.blank")
    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @NotBlank(message = "comment.email.blank")
    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    @NotBlank(message = "comment.content.blank")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }


    public Comment convertToEntity(Post post) {
        Comment comment = new Comment();
        comment.setAuthorName(this.authorName);
        comment.setAuthorEmail(this.authorEmail);
        comment.setContent(this.content);
        comment.setApproved(false);
        comment.setPost(post);
        return comment;
    }
}
