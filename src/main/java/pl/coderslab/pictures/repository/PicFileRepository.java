package pl.coderslab.pictures.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.pictures.model.PicFile;

@Repository("picFileRepository")
public interface PicFileRepository extends JpaRepository<PicFile, Long> {

}
