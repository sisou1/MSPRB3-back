package fr.epsi.msprb3bootjpamaven.dal;

import fr.epsi.msprb3bootjpamaven.bo.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "topics")
public interface TopicRepository extends JpaRepository<Topic, Long> {
    // Méthodes personnalisées si nécessaire
}
