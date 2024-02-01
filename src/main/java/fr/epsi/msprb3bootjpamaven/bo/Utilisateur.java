package fr.epsi.msprb3bootjpamaven.bo;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "utilisateurs")
public class Utilisateur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String email;
    private String password;

    @Column(name = "is_botanist")
    private boolean isBotanist;

    @OneToMany(mappedBy = "utilisateur")
    private List<Plante> plantes;

    public Utilisateur() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

    public List<Plante> getPlantes() {
        return plantes;
    }

    public void setPlantes(List<Plante> plantes) {
        this.plantes = plantes;
    }

    // Constructeurs, getters et setters
    // ...
}
