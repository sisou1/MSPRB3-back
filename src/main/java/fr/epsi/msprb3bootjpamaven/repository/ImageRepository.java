package fr.epsi.msprb3bootjpamaven.repository;

import fr.epsi.msprb3bootjpamaven.bo.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "image")
public interface ImageRepository  extends JpaRepository<Image, Long>{
}
