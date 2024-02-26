package fr.epsi.msprb3bootjpamaven.service;

import fr.epsi.msprb3bootjpamaven.bo.Utilisateur;
import fr.epsi.msprb3bootjpamaven.dal.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Dans AuthService.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Utilisateur authenticate(String email, String password) {
        Utilisateur user = utilisateurRepository.findByEmail(email);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            // Le mot de passe correspond, l'utilisateur est authentifié
            return user;
        }
        return null; // L'authentification a échoué
    }
}

