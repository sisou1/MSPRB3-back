package fr.epsi.msprb3bootjpamaven.service;

import fr.epsi.msprb3bootjpamaven.bo.Utilisateur;
import fr.epsi.msprb3bootjpamaven.dal.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public Utilisateur authenticate(String email, String password) {
        return utilisateurRepository.findByEmailAndPassword(email, password);
    }
}
