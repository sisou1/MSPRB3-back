package fr.epsi.msprb3bootjpamaven.controller;

import fr.epsi.msprb3bootjpamaven.bo.Utilisateur;
import fr.epsi.msprb3bootjpamaven.service.AuthService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AuthControllerTest {

    @Mock
    private AuthService authService;

    @InjectMocks
    private AuthController authController;

    @Test
    public void testLogin_Success() {
        // Créer un utilisateur de test
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setEmail("test@example.com");
        utilisateur.setPassword("password123");

        // Définir le comportement attendu lors de l'appel à authService.authenticate
        when(authService.authenticate("test@example.com", "password123")).thenReturn(utilisateur);

        // Appeler la méthode login du contrôleur
        ResponseEntity<?> responseEntity = authController.login(utilisateur);

        // Vérifier si la réponse est OK et si elle contient l'utilisateur authentifié
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(utilisateur, responseEntity.getBody());
    }

    @Test
    public void testLogin_Failure() {
        // Définir le comportement attendu lors de l'appel à authService.authenticate avec des informations incorrectes
        when(authService.authenticate("wrong@example.com", "wrongpassword")).thenReturn(null);

        // Appeler la méthode login du contrôleur avec des informations incorrectes
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setEmail("wrong@example.com");
        utilisateur.setPassword("wrongpassword");
        ResponseEntity<?> responseEntity = authController.login(utilisateur);

        // Vérifier si la réponse est UNAUTHORIZED (401)
        assertEquals(HttpStatus.UNAUTHORIZED, responseEntity.getStatusCode());
    }
}
