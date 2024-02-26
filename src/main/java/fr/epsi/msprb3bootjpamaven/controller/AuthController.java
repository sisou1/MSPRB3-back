package fr.epsi.msprb3bootjpamaven.controller;

import fr.epsi.msprb3bootjpamaven.bo.Utilisateur;
import fr.epsi.msprb3bootjpamaven.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Utilisateur utilisateur) {
        Utilisateur authenticatedUser = authService.authenticate(utilisateur.getEmail(), utilisateur.getPassword());
        if (authenticatedUser != null) {
            // Authentification réussie
            return new ResponseEntity<>(authenticatedUser, HttpStatus.OK);
        } else {
            // Échec de l'authentification
            return new ResponseEntity<>("Invalid email or password", HttpStatus.UNAUTHORIZED);
        }
    }
}
