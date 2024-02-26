package fr.epsi.msprb3bootjpamaven.service;

import fr.epsi.msprb3bootjpamaven.bo.Utilisateur;
import fr.epsi.msprb3bootjpamaven.dal.UtilisateurRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AuthServiceTest {

    @Mock
    private UtilisateurRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

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
        // Supposons que c'est le mot de passe hashé stocké en base de données
        utilisateur.setPassword("hashedPassword123");

        // Lorsque findByEmail est appelé, renvoyez l'utilisateur de test
        when(userRepository.findByEmail("test@example.com")).thenReturn(utilisateur);

        // Simuler le comportement du PasswordEncoder pour qu'il confirme que le mot de passe fourni correspond
        // au mot de passe hashé (comme si le mot de passe 'password123' avait été hashé en 'hashedPassword123')
        when(passwordEncoder.matches(anyString(), anyString())).thenAnswer(invocation -> {
            String rawPassword = invocation.getArgument(0);
            String encodedPassword = invocation.getArgument(1);

            // Ici, nous supposons que 'password123' est le mot de passe en clair et 'hashedPassword123' est la version hashée
            return "password123".equals(rawPassword) && "hashedPassword123".equals(encodedPassword);
        });

        // Tester l'authentification avec le mot de passe en clair
        Utilisateur authenticatedUser = authService.authenticate("test@example.com", "password123");

        // Vérifier que l'utilisateur est bien authentifié
        assertTrue(authenticatedUser != null && authenticatedUser.getEmail().equals("test@example.com"));
    }
}
