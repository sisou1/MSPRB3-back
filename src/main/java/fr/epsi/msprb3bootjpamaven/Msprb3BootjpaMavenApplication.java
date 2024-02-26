package fr.epsi.msprb3bootjpamaven;

import fr.epsi.msprb3bootjpamaven.bo.Utilisateur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Msprb3BootjpaMavenApplication {

    public static void main(String[] args) {
        SpringApplication.run(Msprb3BootjpaMavenApplication.class, args);
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Bean
    public CommandLineRunner init() {
        return args -> {
            insertData();
        };
    }

    @Transactional
    public void insertData() {
        // Creation et insertions d'entité ici

    }
}
