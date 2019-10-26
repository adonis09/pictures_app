package pl.coderslab.pictures.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.pictures.model.Picture;

@Repository("pictureRepository")
public interface PictureRepository extends JpaRepository<Picture, Integer> {

}
