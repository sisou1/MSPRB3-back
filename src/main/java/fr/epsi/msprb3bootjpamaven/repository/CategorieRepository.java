package fr.epsi.msprb3bootjpamaven.repository;

import fr.epsi.msprb3bootjpamaven.bo.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "categories")
public interface CategorieRepository  extends JpaRepository<Categorie, Long>{
}
