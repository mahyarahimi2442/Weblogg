package ir.ac.weblogg.service.comment;

import ir.ac.weblogg.dto.comment.CommentDto;
import ir.ac.weblogg.dto.comment.CommentSaveDto;
import java.util.List;

public interface CommentService {
    CommentDto save(CommentSaveDto dto);
    List<CommentDto> findAll();
    void deleteById(int id);
    void approveComment(int id);
    List<CommentDto> getApprovedCommentsByPostId(int postId);
}
