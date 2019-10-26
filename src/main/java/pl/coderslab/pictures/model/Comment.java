package pl.coderslab.pictures.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content")
    @Length(min = 1, max = 200, message = "*Your comment must not be empty or longer than 200 characters")
    private String content;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "flags")
    private Integer flags;

    @ManyToOne
    private User user;

    @ManyToOne
    private Picture picture;

    @ManyToOne
    @JoinColumn(name = "parent_comment_id")
    private Comment parentComment;

    @OneToMany(mappedBy = "parentComment")
    private Set<Comment> childComments = new HashSet<>();

}
