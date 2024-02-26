package fr.epsi.msprb3bootjpamaven.dal;

import fr.epsi.msprb3bootjpamaven.bo.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "utilisateurs")
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Utilisateur findByEmailAndPassword(String email, String password);

    Utilisateur findByEmail(String email);
}
