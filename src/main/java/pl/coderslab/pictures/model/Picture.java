package pl.coderslab.pictures.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

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
    private Set<Mark> marks = new HashSet<>();

    @OneToMany(mappedBy = "picture")
    private Set<Comment> comments = new HashSet<>();

    @ManyToMany(mappedBy = "pictures")
    private Set<Tag> tags = new HashSet<>();

}
