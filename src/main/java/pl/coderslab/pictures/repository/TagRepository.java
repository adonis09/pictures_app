package pl.coderslab.pictures.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.pictures.model.Tag;

@Repository("tagRepository")
public interface TagRepository extends JpaRepository<Tag, Long> {
    Tag findByTitle(String title);
}
