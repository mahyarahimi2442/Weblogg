package ir.ac.weblogg.service.comment;


import ir.ac.weblogg.Repasitory.CommentRepository;
import ir.ac.weblogg.Repasitory.PostRepository;
import ir.ac.weblogg.dto.comment.CommentDto;
import ir.ac.weblogg.dto.comment.CommentSaveDto;
import ir.ac.weblogg.model.Comment;
import ir.ac.weblogg.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public CommentDto save(CommentSaveDto dto) {
        Post post = postRepository.findById(dto.getPostId())
                .orElseThrow(() -> new RuntimeException("پست مورد نظر پیدا نشد"));
        Comment comment = dto.convertToEntity(post);
        Comment saved = commentRepository.save(comment);
        return CommentDto.convertToDto(saved);
    }

    @Override
    public List<CommentDto> getApprovedCommentsByPostId(int postId) {
        return commentRepository.findByPostIdAndApprovedTrue(postId)
                .stream()
                .map(CommentDto::convertToDto)
                .collect(Collectors.toList());
    }
    @Override
    public List<CommentDto> findAll() {
        return commentRepository.findAll()
                .stream()
                .map(CommentDto::convertToDto)
                .toList();
    }

    @Override
    public void approveComment(int id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("کامنت یافت نشد"));
        comment.setApproved(true);
        commentRepository.save(comment);
    }

    @Override
    public void deleteById(int id) {
        commentRepository.deleteById(id);
    }
}