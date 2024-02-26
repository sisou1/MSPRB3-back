package fr.epsi.msprb3bootjpamaven.dal;

import fr.epsi.msprb3bootjpamaven.bo.Utilisateur;
import fr.epsi.msprb3bootjpamaven.dal.UtilisateurRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest // Charge le contexte complet de l'application
public class UtilisateurRepositoryTest {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    public void cleanUp() {
        utilisateurRepository.deleteAllInBatch(); // Assurez-vous que la base de données est propre
    }

    @Test
    public void testPasswordHashingBeforeSave() {
        // Créez un nouvel utilisateur avec un mot de passe en clair
        String rawPassword = "plainPassword";
        Utilisateur user = new Utilisateur();
        user.setEmail("test@example.com");
        user.setPassword(rawPassword); // Mot de passe non hashé initialement

        // Sauvegardez l'utilisateur
        utilisateurRepository.save(user);

        // Récupérez l'utilisateur par email
        Utilisateur savedUser = utilisateurRepository.findByEmail(user.getEmail());

        // Vérifiez que le mot de passe enregistré est hashé et différent du mot de passe en clair
        assertNotEquals(rawPassword, savedUser.getPassword());

        // Vérifiez que le mot de passe en clair correspond au mot de passe hashé stocké
        assertTrue(passwordEncoder.matches(rawPassword, savedUser.getPassword()));
    }
}
