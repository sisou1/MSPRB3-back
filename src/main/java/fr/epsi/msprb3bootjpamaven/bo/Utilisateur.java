package fr.epsi.msprb3bootjpamaven.bo;

import fr.epsi.msprb3bootjpamaven.bo.listener.UtilisateurListener;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.Entity;

@Entity
@Table(name = "utilisateurs")
@EntityListeners(UtilisateurListener.class)
public class Utilisateur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "is_botanist")
    private boolean isBotanist;
    @OneToMany(mappedBy = "utilisateur")
    private List<Plante> plantes;
    @OneToMany(mappedBy = "utilisateur")
    private List<Article> articles;

    public Utilisateur() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isBotanist() {
        return isBotanist;
    }

    public void setBotanist(boolean botanist) {
        isBotanist = botanist;
    }

    public void setPlantes(List<Plante> plantes) {
        this.plantes = plantes;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
