package fr.epsi.msprb3bootjpamaven.bo;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "categories")
public class Categorie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @OneToMany(mappedBy = "categorie")
    private List<Plante> plantes;

    // Constructeurs, getters et setters
    public Categorie() {}

    // Getters et Setters pour chaque attribut
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

    public List<Plante> getPlantes() {
        return plantes;
    }

    public void setPlantes(List<Plante> plantes) {
        this.plantes = plantes;
    }
}
