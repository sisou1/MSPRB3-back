package fr.epsi.msprb3bootjpamaven.repository;

import fr.epsi.msprb3bootjpamaven.bo.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "article")
public interface ArticleRepository extends JpaRepository<Article, Long> {
    // Des méthodes personnalisées peuvent être ajoutées ici si nécessaire
}
