package ir.ac.weblogg.Repasitory;

import ir.ac.weblogg.dto.comment.CommentDto;
import ir.ac.weblogg.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface CommentRepository extends JpaRepository<Comment, Integer> {

        List<Comment> findByApprovedTrue();

        List<Comment> findByPostIdAndApprovedTrue(int postId);
    }

