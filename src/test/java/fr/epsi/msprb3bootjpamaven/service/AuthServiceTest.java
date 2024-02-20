package fr.epsi.msprb3bootjpamaven.service;

import fr.epsi.msprb3bootjpamaven.bo.Utilisateur;
import fr.epsi.msprb3bootjpamaven.dal.UtilisateurRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AuthServiceTest {

    @Mock
    private UtilisateurRepository userRepository;

    @InjectMocks
    private AuthService authService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAuthenticate() {
        // Créer un utilisateur de test
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setEmail("test@example.com");
        utilisateur.setPassword("password123");

        // Attendu
        when(userRepository.findByEmailAndPassword("test@example.com", "password123")).thenReturn(utilisateur);

        Utilisateur authenticatedUser = authService.authenticate("test@example.com", "password123");

        assertEquals(utilisateur, authenticatedUser);
    }
}
