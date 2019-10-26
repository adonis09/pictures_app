package pl.coderslab.pictures.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.pictures.model.Comment;

@Repository("commentRepository")
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    Comment findByParentCommentId(Long parentCommentId);
}
