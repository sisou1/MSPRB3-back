package fr.epsi.msprb3bootjpamaven.bo;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "topics")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @ManyToMany(mappedBy = "topics")
    private List<Plante> plantes;

    @OneToMany(mappedBy = "topic")
    private List<Article> articles;

    public Topic() {
    }

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

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
