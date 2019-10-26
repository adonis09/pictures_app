package pl.coderslab.pictures.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.pictures.model.Mark;

@Repository("markRepository")
public interface MarkRepository extends JpaRepository<Mark, Integer> {

}
