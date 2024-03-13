package fr.epsi.msprb3bootjpamaven.repository;

import fr.epsi.msprb3bootjpamaven.bo.Plante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "plantes")
public interface PlanteRepository extends JpaRepository<Plante, Long> {
    // Des méthodes personnalisées peuvent être ajoutées ici si nécessaire
}
