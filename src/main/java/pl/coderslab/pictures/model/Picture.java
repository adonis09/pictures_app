package pl.coderslab.pictures.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "picture")
public class Picture {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "approved")
    private LocalDateTime approved;

    @Column(name = "valid")
    private int valid;

    @OneToOne(optional = false)
    private PicFile picFile;

    @ManyToOne
    private User user;

    @Column(name = "created")
    @PrePersist
    public void prePersist() {
        created = LocalDateTime.now();
    }

    @Column(name = "approved")
    @PreUpdate
    public void preUpdate() {
        approved = LocalDateTime.now();
    }

    @OneToMany(mappedBy = "picture")
    private List<Mark> marks = new ArrayList<>();

    @OneToMany(mappedBy = "picture")
    private List<Comment> comments = new ArrayList<>();

    @ManyToMany(mappedBy = "pictures")
    private List<Tag> tags = new ArrayList<>();

}
