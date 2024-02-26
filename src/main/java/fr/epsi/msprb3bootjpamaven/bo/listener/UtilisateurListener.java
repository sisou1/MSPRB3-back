package fr.epsi.msprb3bootjpamaven.bo.listener;

import fr.epsi.msprb3bootjpamaven.bo.Utilisateur;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UtilisateurListener {

    private static ApplicationContext context;

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        context = applicationContext; // Stocker le contexte de l'application
    }

    @PrePersist
    @PreUpdate
    public void hashPasswordBeforeInsertOrUpdate(Utilisateur utilisateur) {
        PasswordEncoder passwordEncoder = context.getBean(PasswordEncoder.class);
        String hashedPassword = passwordEncoder.encode(utilisateur.getPassword());
        utilisateur.setPassword(hashedPassword);
    }
}
